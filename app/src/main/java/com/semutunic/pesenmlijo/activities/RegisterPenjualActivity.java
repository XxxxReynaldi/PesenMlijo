package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.fragments.BerandaFragment;

public class RegisterPenjualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_penjual);

        Button daftarpenjual = findViewById(R.id.BtnDaftarPenjual);

        daftarpenjual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPenjualActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}