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
import com.semutunic.pesenmlijo.adapter.DitolakAdapter;
import com.semutunic.pesenmlijo.models.DibatalkanModel;
import com.semutunic.pesenmlijo.models.DitolakModel;

import java.util.ArrayList;

public class Ditolak extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DitolakAdapter Adapter;
    private ArrayList<DitolakModel> ditolakArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ditolak);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.DitolakRecview);

        Adapter = new DitolakAdapter(ditolakArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Ditolak.this);

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
        ditolakArrayList = new ArrayList<>();
        ditolakArrayList.add(new DitolakModel(R.drawable.produk,"18 Mei 2021", "Peter", "2"));
        ditolakArrayList.add(new DitolakModel(R.drawable.produk, "18 Mei 2021", "Rey", "2"));
        ditolakArrayList.add(new DitolakModel(R.drawable.produk,"18 Mei 2021", "Ulum", "4"));
    }
}