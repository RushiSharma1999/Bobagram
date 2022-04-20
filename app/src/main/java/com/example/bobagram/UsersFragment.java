package com.example.bobagram;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment {

    FirebaseAuth fbAuth;
    RecyclerView rView;
    List<ModelUsers> usersList;
    AdapterUsers adapterUsers;

    public UsersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        usersList = new ArrayList<>();
        fbAuth = FirebaseAuth.getInstance();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        rView = view.findViewById(R.id.recycle_user);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getAllUsers();
        return view;
    }

    private void getAllUsers() {
        final FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference dReference = FirebaseDatabase.getInstance().getReference("Users");

        dReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();

                for (DataSnapshot dSnap : dataSnapshot.getChildren()) {
                    ModelUsers mUsers = dSnap.getValue(ModelUsers.class);
                    if (mUsers.getUid() != null && !mUsers.getUid().equals(fUser.getUid())) {
                        usersList.add(mUsers);
                    }
                    adapterUsers = new AdapterUsers(getActivity(), usersList);
                    rView.setAdapter(adapterUsers);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void searchUsers(final String s) {
        final FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference dReference = FirebaseDatabase.getInstance().getReference("Users");

        dReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();

                for (DataSnapshot dSnap : dataSnapshot.getChildren()) {
                    ModelUsers modelUsers = dSnap.getValue(ModelUsers.class);
                    if (modelUsers.getUid() != null && !modelUsers.getUid().equals(fUser.getUid())) {
                        if (modelUsers.getName().toLowerCase().contains(s.toLowerCase()) ||
                                modelUsers.getEmail().toLowerCase().contains(s.toLowerCase())) {
                            usersList.add(modelUsers);
                        }
                    }
                    adapterUsers = new AdapterUsers(getActivity(), usersList);
                    adapterUsers.notifyDataSetChanged();
                    rView.setAdapter(adapterUsers);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.logout).setVisible(false);
        MenuItem item = menu.findItem(R.id.search);
        SearchView sView = (SearchView) MenuItemCompat.getActionView(item);
        sView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!TextUtils.isEmpty(query.trim())) {
                    searchUsers(query);
                } else {
                    getAllUsers();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText.trim())) {
                    searchUsers(newText);
                } else {
                    getAllUsers();
                }
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

}
