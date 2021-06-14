package com.semutunic.pesenmlijo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.semutunic.pesenmlijo.R;

public class RegisterPembeli extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pembeli);

        Button daftarpembeli = findViewById(R.id.BtnDaftarPembeli);

        daftarpembeli.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPembeli.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}