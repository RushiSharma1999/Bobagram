package com.example.bobagram;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        getWindow().setStatusBarColor(ContextCompat.getColor(DashboardActivity.this,R.color.statusBarColor));// set status background white
        setContentView(R.layout.activity_dashboard);
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#583b39"));
        actionBar = getSupportActionBar();
        actionBar.setTitle("Profile Activity");

        navigationView = findViewById(R.id.dashboard_navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);
        actionBar.setTitle("Home");

        actionBar.setBackgroundDrawable(colorDrawable);

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
                    actionBar.setTitle("Add Post");
                    AddBlogsFragment addFrag = new AddBlogsFragment();
                    FragmentTransaction afragTrans = getSupportFragmentManager().beginTransaction();
                    afragTrans.replace(R.id.dashboard_content, addFrag, "");
                    afragTrans.commit();
                    return true;
            }
            return false;
        }
    };
}
