package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.fragments.AkunFragment;
import com.semutunic.pesenmlijo.fragments.BerandaFragment;
import com.semutunic.pesenmlijo.fragments.PesananFragment;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    private static final String TAG = "tes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.menu_bawah);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.beranda));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.pesanan));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.produk1));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.akun));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment selectedFragment = null;
                Intent intent = new Intent();
                switch (item.getId()) {
                    case 1:
                        selectedFragment = new BerandaFragment();
                        break;
                    case 2:
                        selectedFragment = new PesananFragment();
                        break;
                    case 3:
//                        Log.i(TAG, "onShowItem: "+item.getId());
                        intent = new Intent(MainActivity.this, ProdukActivity.class);
                        startActivity(intent);
//                        finish();
                        break;
                    case 4:
                        selectedFragment = new AkunFragment();
                        break;
                }
                if (selectedFragment != null ){
                    loadFragment(selectedFragment);
                } else {
                    Log.i(TAG, "onShowItem: "+item.getId());
                }


            }
        });

        //set

        bottomNavigation.show(1, true);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(getApplicationContext(),"ini " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(getApplicationContext(),"ini " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Fragment selectedFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                selectedFragment).commit();
    }


}