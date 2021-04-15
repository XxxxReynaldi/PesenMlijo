package com.semutunic.pesenmlijo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.adapter.ProdukAdapter;
import com.semutunic.pesenmlijo.model.ProdukModel;

import java.util.ArrayList;
import java.util.List;

public class ProdukActivity extends AppCompatActivity {
    private BottomNavigationView menu_bawah;
        //a list to store all the products
        List<ProdukModel> productList;

        //the recyclerview
        RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_produk);

            menu_bawah = findViewById(R.id.menu_bawah);
            menu_bawah.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);

            //getting the recyclerview from xml
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            //initializing the productlist
            productList = new ArrayList<>();


            //adding some items to our list
            productList.add(
                    new ProdukModel(
                            1,
                            "Tomat",
                            60000,
                            R.drawable.produk));

            productList.add(
                    new ProdukModel(
                            1,
                            "Bawang",
                            60000,
                            R.drawable.produk));

            productList.add(
                    new ProdukModel(
                            1,
                            "Ikan",
                            60000,
                            R.drawable.produk));

            productList.add(
                    new ProdukModel(
                            1,
                            "Ikan",
                            60000,
                            R.drawable.produk));

            //creating recyclerview adapter
            ProdukAdapter adapter = new ProdukAdapter(this, productList);

            //setting adapter to recyclerview
            recyclerView.setAdapter(adapter);
        }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()){
            case R.id.home:
                //aksi ketika home di klik
                intent = new Intent(ProdukActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.pesanan:
                //aksi ketika profile di klik
                intent = new Intent(ProdukActivity.this, PesananActivity.class);
                startActivity(intent);
                break;
            case R.id.produk:
                //aksi ketika folder di klik
                intent = new Intent(ProdukActivity.this, ProdukActivity.class);
                startActivity(intent);
                break;
            case R.id.akun:
                //aksi ketika pesan di klik

                break;
        }
        return true;
    }
}


