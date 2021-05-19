package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.adapter.DibatalkanAdapter;
import com.semutunic.pesenmlijo.adapter.SelesaiAdapter;
import com.semutunic.pesenmlijo.models.DibatalkanModel;
import com.semutunic.pesenmlijo.models.SelesaiModel;

import java.util.ArrayList;

public class Dibatalkan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DibatalkanAdapter Adapter;
    private ArrayList<DibatalkanModel> batalArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibatalkan);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.DibatalkanRecview);

        Adapter = new DibatalkanAdapter(batalArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Dibatalkan.this);

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
        batalArrayList = new ArrayList<>();
        batalArrayList.add(new DibatalkanModel(R.drawable.produk,"18 Mei 2021", "Peter", "2"));
        batalArrayList.add(new DibatalkanModel(R.drawable.produk, "18 Mei 2021", "Rey", "2"));
        batalArrayList.add(new DibatalkanModel(R.drawable.produk,"18 Mei 2021", "Ulum", "4"));
    }
}