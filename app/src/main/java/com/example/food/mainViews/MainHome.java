package com.example.food.mainViews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.food.R;
import com.example.food.fragments.AlmuerzosFragment;
import com.example.food.fragments.DesayunosFragment;
import com.example.food.fragments.HomeFragment;
import com.example.food.fragments.PostresFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_desayuno:
                            selectedFragment = new DesayunosFragment();
                            break;
                        case R.id.nav_almuerzo:
                            selectedFragment = new AlmuerzosFragment();
                            break;
                        case R.id.nav_postres:
                            selectedFragment = new PostresFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}