package com.example.instagramnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    Fragment feedFragment = new FeedFragment();
    Fragment searchFragment = new SearchFragment();
    Fragment likeFragment = new LikeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, feedFragment).commit();

        BottomNavigationView bottomNavView = findViewById(R.id.bottomNavView);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.homeNavButton:
                        selectedFragment = feedFragment;
                        break;
                    case R.id.searchNavButton:
                        selectedFragment = searchFragment;
                        break;
                    case R.id.likeNavButton:
                        selectedFragment = likeFragment;
                        break;
                }

                if (selectedFragment != null)
                    fragmentTransaction.replace(R.id.frameLayout, selectedFragment).commit();

                return true;
            }
        });
    }

}
