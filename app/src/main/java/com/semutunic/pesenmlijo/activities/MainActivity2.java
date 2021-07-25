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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigation = findViewById(R.id.bottom_navigation2);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(BerandaFragment.newInstance("", ""));

        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(MainActivity2.this, LoginActivity.class));
                    finish();
                }
            }
        };
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

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

}