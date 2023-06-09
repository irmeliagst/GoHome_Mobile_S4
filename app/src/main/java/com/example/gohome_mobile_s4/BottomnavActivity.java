package com.example.gohome_mobile_s4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomnavActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    homeFragment homeFragment = new homeFragment();
    TransaksiFragment TransaksiFragment = new TransaksiFragment();
    ProfileFragment ProfileFragment = new ProfileFragment();
    SesionManager sesionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnav);
        bottomNav = findViewById(R.id.bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
        sesionManager= new SesionManager(BottomnavActivity.this);
        if(!sesionManager.isLogin()){
            movetoLogin();
        }

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
                        return true;
                    case R.id.transaksi:
//
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, TransaksiFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, ProfileFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
    private void movetoLogin(){
        Intent intent = new Intent (BottomnavActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

}