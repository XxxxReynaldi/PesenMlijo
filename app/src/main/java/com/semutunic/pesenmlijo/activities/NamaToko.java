package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.adapter.DitolakAdapter;
import com.semutunic.pesenmlijo.adapter.NamaTokoAdapter;
import com.semutunic.pesenmlijo.models.DitolakModel;
import com.semutunic.pesenmlijo.models.NamaTokoModel;

import java.util.ArrayList;

public class NamaToko extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NamaTokoAdapter Adapter;
    private ArrayList<NamaTokoModel> namatokoArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nama_toko);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.NamaTokorecview);

        Adapter = new NamaTokoAdapter(namatokoArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NamaToko.this);

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
        namatokoArrayList = new ArrayList<>();
        namatokoArrayList.add(new NamaTokoModel(R.drawable.produk, "Budi doremi", "Tomat", "10000"));
        namatokoArrayList.add(new NamaTokoModel(R.drawable.produk, "Ariel Noah", "Bawang Merah", "10000"));
        namatokoArrayList.add(new NamaTokoModel(R.drawable.produk, "Cak nan", "Cabai", "10000"));
    }
}