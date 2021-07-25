package com.semutunic.pesenmlijo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.fragments.ProdukFragment;

import java.util.HashMap;
import java.util.UUID;

public class TambahProduk extends AppCompatActivity {

    private EditText mNamaProduk, mHarga, mMinOrder, mBerat, mDeskProduk;
    private Spinner mKategori;
    private Button mSimpan;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_produk);

        mNamaProduk     =   findViewById(R.id.EtNamaProduk);            // 1 nama produk
        mKategori       =   (Spinner)findViewById(R.id.Lkategori);      // 2 kategori
                                                                        // 3 ( Gambar )
        mHarga          =   findViewById(R.id.EtHarga);                 // 4 harga
        mMinOrder       =   findViewById(R.id.EtMinOrder);              // 5 min order
        mDeskProduk     =   findViewById(R.id.EtDeskProduk);            // 6 deskripsi produk

//      Button
        mSimpan         =   findViewById(R.id.BtnSimpanTambahProduk);

//      koneksi to database
        db = FirebaseFirestore.getInstance();

        mSimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TambahProduk.this, ProdukFragment.class));
            }
        });

        mSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaproduk    =      mNamaProduk.getText().toString();
                String kategori      =      mKategori.getSelectedItem().toString();
                String harga         =      mHarga.getText().toString();
                String minorder      =      mMinOrder.getText().toString();
                String desc          =      mDeskProduk.getText().toString();

                String id = UUID.randomUUID().toString();

                saveToFireStore(id, namaproduk, kategori, harga, minorder, desc);
            }
        });
    }

    private void saveToFireStore(String id, String namaproduk, String kategori, String harga, String minorder, String desc){

        // data yang di query
        if (!namaproduk.isEmpty() && !harga.isEmpty()){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("nama produk", namaproduk);
            map.put("kategori", kategori);
            map.put("harga", harga);
            map.put("min Order", minorder);
            map.put("deskripsi", desc);

            // mengirim data
            db.collection("Produk").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(TambahProduk.this, "Data Save !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(TambahProduk.this, "Failed !!", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            Toast.makeText(this, "Empty Fields not Allowed", Toast.LENGTH_SHORT).show();
        }

    }

}