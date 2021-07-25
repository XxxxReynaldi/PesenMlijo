package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.adapter.DalamProsesPenjualAdapter;
import com.semutunic.pesenmlijo.adapter.PesananBaruAdapter;
import com.semutunic.pesenmlijo.models.DalamProsesPenjualModel;
import com.semutunic.pesenmlijo.models.PesananBaruModel;

import java.util.ArrayList;

public class DalamProsesPenjual extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DalamProsesPenjualAdapter Adapter;
    private ArrayList<DalamProsesPenjualModel> prosesArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dalam_proses_penjual);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.DalamProsesPenjualRecview);

        Adapter = new DalamProsesPenjualAdapter(prosesArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DalamProsesPenjual.this);

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
        prosesArrayList = new ArrayList<>();
        prosesArrayList.add(new DalamProsesPenjualModel(R.drawable.produk,"18 Mei 2021", "Peter", "2"));
        prosesArrayList.add(new DalamProsesPenjualModel(R.drawable.produk, "18 Mei 2021", "Rey", "2"));
        prosesArrayList.add(new DalamProsesPenjualModel(R.drawable.produk,"18 Mei 2021", "Ulum", "4"));
    }
}