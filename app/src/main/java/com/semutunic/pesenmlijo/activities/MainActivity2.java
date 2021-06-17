package com.semutunic.pesenmlijo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.fragments.AkunFragment;
import com.semutunic.pesenmlijo.fragments.BerandaFragment;
import com.semutunic.pesenmlijo.fragments.BerandaPembeliFragment;
import com.semutunic.pesenmlijo.fragments.PesananFragment;
import com.semutunic.pesenmlijo.fragments.PesananPembeliFragment;
import com.semutunic.pesenmlijo.fragments.ProdukFragment;

public class MainActivity2 extends AppCompatActivity {
    private BottomNavigationView bottomNavigation;
    private static final String TAG = "tes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigation = findViewById(R.id.bottom_navigation2);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(BerandaFragment.newInstance("", ""));
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_beranda:
                            openFragment(BerandaPembeliFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_pesanan:
                            openFragment(PesananPembeliFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_akun:
                            openFragment(AkunFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

}