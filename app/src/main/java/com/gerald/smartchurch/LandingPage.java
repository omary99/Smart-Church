package com.gerald.smartchurch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LandingPage extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_devotion:
                        Toast.makeText(LandingPage.this, "Devotion Button Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_pledge:
                        Toast.makeText(LandingPage.this, "Pledge Button Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_location:
                        Toast.makeText(LandingPage.this, "Location Button Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });



    }
}