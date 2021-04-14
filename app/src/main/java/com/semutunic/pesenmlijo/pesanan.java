package com.semutunic.pesenmlijo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.semutunic.pesenmlijo.activities.MainActivity;
import com.semutunic.pesenmlijo.activities.ProdukActivity;

public class pesanan extends AppCompatActivity {
    private BottomNavigationView menu_bawah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        menu_bawah = findViewById(R.id.menu_bawah);
        menu_bawah.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()){
            case R.id.home:
                //aksi ketika home di klik
                intent = new Intent(pesanan.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.pesanan:
                //aksi ketika profile di klik
                intent = new Intent(pesanan.this, pesanan.class);
                startActivity(intent);
                break;
            case R.id.produk:
                //aksi ketika folder di klik
                intent = new Intent(pesanan.this, ProdukActivity.class);
                startActivity(intent);
                break;
            case R.id.akun:
                //aksi ketika pesan di klik

                break;
        }
        return true;
    }
}