package com.example.bobagram;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {
    FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;

    String myuid;
    BottomNavigationView navigationView;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Profile Activity");

        navigationView = findViewById(R.id.dashboard_navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);
        actionBar.setTitle("Home");

        firebaseAuth = FirebaseAuth.getInstance();

        HomeFragment frag = new HomeFragment();
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.dashboard_content, frag, "");
        fragTrans.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.nav_home:
                    actionBar.setTitle("Home");
                    HomeFragment frag= new HomeFragment();
                    FragmentTransaction fragTrans= getSupportFragmentManager().beginTransaction();
                    fragTrans.replace(R.id.dashboard_content, frag, "");
                    fragTrans.commit();
                    return true;

                case R.id.nav_users:
                    actionBar.setTitle("Users");
                    UsersFragment userFrag = new UsersFragment();
                    FragmentTransaction ufragTrans = getSupportFragmentManager().beginTransaction();
                    ufragTrans.replace(R.id.dashboard_content, userFrag, "");
                    ufragTrans.commit();
                    return true;

                case R.id.nav_profile:
                    actionBar.setTitle("Profile");
                    ProfileFragment profFrag = new ProfileFragment();
                    FragmentTransaction pfragTrans = getSupportFragmentManager().beginTransaction();
                    pfragTrans.replace(R.id.dashboard_content, profFrag);
                    pfragTrans.commit();
                    return true;

                case R.id.nav_addblogs:
                    actionBar.setTitle("Add Blogs");
                    AddBlogsFragment addFrag = new AddBlogsFragment();
                    FragmentTransaction afragTrans = getSupportFragmentManager().beginTransaction();
                    afragTrans.replace(R.id.dashboard_content, addFrag, "");
                    afragTrans.commit();
                    return true;

                case R.id.nav_chat:
                    actionBar.setTitle("Chats");
                    ChatListFragment chatFragment = new ChatListFragment();
                    FragmentTransaction cfragTrans = getSupportFragmentManager().beginTransaction();
                    cfragTrans.replace(R.id.dashboard_content, chatFragment, "");
                    cfragTrans.commit();
                    return true;
            }
            return false;
        }
    };
}
