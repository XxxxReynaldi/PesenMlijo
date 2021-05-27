package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.semutunic.pesenmlijo.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button pembeli = findViewById(R.id.BtnPembeli);
        Button penjual = findViewById(R.id.BtnPenjual);

        pembeli.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                  // pindah halaman ke register pembeli
              startActivity(new Intent(LoginActivity.this, RegisterPembeli.class));
            }
        });

        penjual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // pindah halaman ke register penjual
                startActivity(new Intent(LoginActivity.this, RegisterPenjualActivity.class));
            }
        });
    }
}