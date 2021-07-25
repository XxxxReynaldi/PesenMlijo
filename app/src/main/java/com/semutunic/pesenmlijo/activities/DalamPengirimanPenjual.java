package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.adapter.DalamPengirimanPenjualAdapter;
import com.semutunic.pesenmlijo.adapter.DalamProsesPenjualAdapter;
import com.semutunic.pesenmlijo.models.DalamPengirimanPenjualModel;
import com.semutunic.pesenmlijo.models.DalamProsesPenjualModel;

import java.util.ArrayList;

public class DalamPengirimanPenjual extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DalamPengirimanPenjualAdapter Adapter;
    private ArrayList<DalamPengirimanPenjualModel> pengirimanArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dalam_pengiriman_penjual);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.DalamPengirimanPenjualRecview);

        Adapter = new DalamPengirimanPenjualAdapter(pengirimanArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DalamPengirimanPenjual.this);

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
        pengirimanArrayList = new ArrayList<>();
        pengirimanArrayList.add(new DalamPengirimanPenjualModel(R.drawable.produk,"18 Mei 2021", "Peter", "2"));
        pengirimanArrayList.add(new DalamPengirimanPenjualModel(R.drawable.produk, "18 Mei 2021", "Rey", "2"));
        pengirimanArrayList.add(new DalamPengirimanPenjualModel(R.drawable.produk,"18 Mei 2021", "Ulum", "4"));
    }
}