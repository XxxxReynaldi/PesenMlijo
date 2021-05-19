package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.adapter.GridArrayAdapter;
import com.semutunic.pesenmlijo.adapter.KategoriAdapter;
import com.semutunic.pesenmlijo.models.KategoriModel;

import java.util.ArrayList;

public class Kategori extends AppCompatActivity {
    private GridView gridView;

    private int[] images = new int[]{R.drawable.bmerah, R.drawable.cabai, R.drawable.tomat, R.drawable.brokoli, R.drawable.wortel, R.drawable.kangkung, R.drawable.kubis, R.drawable.timun};
    private String[] names = new String[]{"Bawang Merah", "Cabai", "Tomat", "Brokoli", "Wortel", "Kangkung", "Kubis", "Timun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        gridView = findViewById(R.id.gv);

        GridArrayAdapter gridArrayAdapter = new GridArrayAdapter(this,R.layout.col_kategori,images,names);
        gridView.setAdapter(gridArrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Kategori.this, names[position], Toast.LENGTH_SHORT).show();
            }
        });

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

}
