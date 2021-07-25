package com.semutunic.pesenmlijo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.semutunic.pesenmlijo.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterPembeliActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    private TextInputLayout lyNama, lyAlamat, lyNotelp, lyEmail, lyPassword;
    private EditText etNama, etAlamat, etNotelp, etEmail, etPassword;
    private TextView tvMasuk;
    private Button btnDaftarPembeli;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private FirebaseFirestore fStore;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pembeli);

        component();

        if(auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
            finish();
        }

        btnDaftarPembeli.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final String nama       = etNama.getText().toString().trim();
                final String alamat     = etAlamat.getText().toString().trim();
                final String notelp     = etNotelp.getText().toString().trim();
                final String email      = etEmail.getText().toString().trim();
                final String password   = etPassword.getText().toString().trim();

                if(TextUtils.isEmpty(nama)){
                    Toast.makeText(getApplicationContext(), "Masukkan nama anda!", Toast.LENGTH_SHORT).show();
                    lyNama.setError("Masukkan nama anda!");
                    return;
                }

                if(TextUtils.isEmpty(alamat)){
                    Toast.makeText(getApplicationContext(), "Masukkan alamat anda!", Toast.LENGTH_SHORT).show();
                    lyAlamat.setError("Masukkan alamat anda!");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Masukkan alamat email!", Toast.LENGTH_SHORT).show();
                    lyEmail.setError("Masukkan alamat email!");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Masukkan password!", Toast.LENGTH_SHORT).show();
                    lyPassword.setError("Masukkan password!");
                    return;
                }

                if(password.length() < 6 ) {
                    Toast.makeText(getApplicationContext(), "Password terlalu pendek (harus => 6)", Toast.LENGTH_SHORT).show();
                    lyPassword.setError("Password terlalu pendek (harus => 6)");
                    return;
                } else if(password.length() > 25) {
                    Toast.makeText(getApplicationContext(), "Password terlalu panjang", Toast.LENGTH_SHORT).show();
                    lyPassword.setError("Password terlalu panjang");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                btnDaftarPembeli.setVisibility(View.GONE);

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterPembeliActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterPembeliActivity.this, "createUserWithEmail:onComplete: " + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                btnDaftarPembeli.setVisibility(View.VISIBLE);

                                if (!task.isSuccessful()){
                                    Toast.makeText(RegisterPembeliActivity.this, "Autentikasi Gagal : "+task.getException().getMessage()
                                            , Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RegisterPembeliActivity.this, "User berhasil terdaftar", Toast.LENGTH_LONG).show();

                                    userID = auth.getCurrentUser().getUid();
                                    DocumentReference documentReference = fStore.collection("users").document(userID);
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("Nama", nama);
                                    user.put("Alamat", alamat);
                                    user.put("NoTelp", notelp);
                                    user.put("Email", email);
                                    user.put("Password", password);
                                    user.put("RoleID", 2);

                                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d(TAG, "onFailure: " + e.toString());
                                        }
                                    });

                                    startActivity(new Intent(RegisterPembeliActivity.this, MainActivity2.class));
                                    finish();
                                }
                            }
                        });
            }
        });

        tvMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void component() {
        lyNama      = findViewById(R.id.LyNama);
        lyAlamat    = findViewById(R.id.LyAlamat);
        lyNotelp    = findViewById(R.id.LyNotelp);
        lyEmail     = findViewById(R.id.LyEmail);
        lyPassword  = findViewById(R.id.LyPassword);

        etNama      = findViewById(R.id.EtNama);
        etAlamat    = findViewById(R.id.EtAlamat);
        etNotelp    = findViewById(R.id.EtNotelp);
        etEmail     = findViewById(R.id.EtEmail);
        etPassword  = findViewById(R.id.EtPassword);

        progressBar = findViewById(R.id.loading);

        btnDaftarPembeli    = findViewById(R.id.BtnDaftarPembeli);
        tvMasuk             = findViewById(R.id.TvMasuk);

        auth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}