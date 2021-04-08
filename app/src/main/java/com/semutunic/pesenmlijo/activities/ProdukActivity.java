package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.semutunic.pesenmlijo.R;

import java.util.ArrayList;
import java.util.List;

public class ProdukActivity extends AppCompatActivity {

        //a list to store all the products
        List<ProdukModel> productList;

        //the recyclerview
        RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_produk);

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
}


