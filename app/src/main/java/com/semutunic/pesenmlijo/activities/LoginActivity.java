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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.UserModel;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    private TextInputLayout lyEmail, lyPassword;
    private EditText etEmail, etPassword;
    private Button btnPembeli, btnPenjual, btnMasuk;

    private FirebaseAuth auth;
    private ProgressBar progressBar;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();;
    private CollectionReference collRef ;
    private DocumentReference docRef;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            userID = auth.getCurrentUser().getUid();
            Log.d(TAG, "onSuccess: user Login is "+ userID);
            collRef = db.collection("users"); // getCollection
            docRef  = collRef.document(userID); // getDocument

            checkUserRoute();
        }
        setContentView(R.layout.activity_login);

        btnPembeli  = findViewById(R.id.BtnPembeli);
        btnPenjual  = findViewById(R.id.BtnPenjual);
        btnMasuk    = findViewById(R.id.BtnMasuk);
        etEmail     = findViewById(R.id.EtEmail);
        etPassword  = findViewById(R.id.EtPassword);

        lyEmail     = findViewById(R.id.LyEmail);
        lyPassword  = findViewById(R.id.LyPassword);

        progressBar = findViewById(R.id.loading);

        auth = FirebaseAuth.getInstance();

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email            = etEmail.getText().toString();
                final String password   = etPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Masukkan email !", Toast.LENGTH_SHORT).show();
                    lyEmail.setError("Masukkan email!");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Masukkan password!", Toast.LENGTH_SHORT).show();
                    lyPassword.setError("Masukkan password!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if (!task.isSuccessful()) {

                                    if (password.length() < 6) {
                                        etPassword.setError(getString(R.string.minimum_password));
                                    } else if (password.length() > 25) {
                                        etPassword.setError((getString(R.string.maximum_password)));
                                    } else {
                                        Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_SHORT).show();
                                    }

                                } else {

                                    userID = auth.getCurrentUser().getUid();
                                    Log.d(TAG, "onSuccess: user Login is "+ userID);
                                    collRef = db.collection("users"); // getCollection
                                    docRef  = collRef.document(userID); // getDocument

                                    checkUserRoute();

                                }
                            }
                        });
            }
        });

        btnPembeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // pindah halaman ke register pembeli
                startActivity(new Intent(LoginActivity.this, RegisterPembeliActivity.class));
            }
        });

        btnPenjual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // pindah halaman ke register penjual
                startActivity(new Intent(LoginActivity.this, RegisterPenjualActivity.class));
            }
        });
    }

    private void checkUserRoute(){
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        // UserModel userModel = document.toObject(UserModel.class);
                        Log.d(TAG, "Document Snapshot data: "+document.getData());

                        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                UserModel userModel = documentSnapshot.toObject(UserModel.class);
                                int role            = userModel.getRoleID();
                                Log.d(TAG, "Role : "+role);

                                if (role == 1 ){
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                } else if (role == 2){
                                    startActivity(new Intent(LoginActivity.this, MainActivity2.class));
                                    finish();
                                }
                            }
                        });

                    } else {
                        Log.d(TAG, "Document tidak ditemukan");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}