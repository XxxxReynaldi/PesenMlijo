package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.adapter.PesananBaruAdapter;
import com.semutunic.pesenmlijo.adapter.ProdukAdapter;
import com.semutunic.pesenmlijo.models.PesananBaruModel;
import com.semutunic.pesenmlijo.models.ProdukModel;

import java.util.ArrayList;

public class PesananBaru extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PesananBaruAdapter Adapter;
    private ArrayList<PesananBaruModel> pesanArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_baru);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.PesananRecview);

        Adapter = new PesananBaruAdapter(pesanArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PesananBaru.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(Adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle button click here
        if (item.getItemId() == android.R.id.home) {
            setResult(Activity.RESULT_CANCELED);
            finish(); // close this activity and return to preview activity
        }
        return super.onOptionsItemSelected(item);
    }

    void addData(){
        pesanArrayList = new ArrayList<>();
        pesanArrayList.add(new PesananBaruModel(R.drawable.produk,"18 Mei 2021", "Peter", "2"));
        pesanArrayList.add(new PesananBaruModel(R.drawable.produk, "18 Mei 2021", "Rey", "2"));
        pesanArrayList.add(new PesananBaruModel(R.drawable.produk,"18 Mei 2021", "Ulum", "4"));
    }
}