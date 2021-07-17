package com.semutunic.pesenmlijo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.KecamatanModel;
import com.semutunic.pesenmlijo.models.KotaKabupatenModel;
import com.semutunic.pesenmlijo.models.ProvinsiModel;
import com.semutunic.pesenmlijo.models.UserModel;

public class ProfilActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    private TextView tvNama, tvNoTelp, tvEmail, tvAlamat, tvJamBuka, tvJamTutup;
    private TextView tvProvinsi, tvKotaKabupaten, tvKecamatan;

    private FirebaseAuth auth;
    private ProgressBar progressBar;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collRef ;
    private DocumentReference docRef;

    private String userID;

    private int idProvinsi  = 0;
    private int idKotaKab   = 0;
    private int idKecamatan = 0;
    private String namaKotaKab      = "";
    private String namaKecamatan    = "";
    private String namaProvinsi     = "";

    private String mJamBuka         = "";
    private String mJamTutup        = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        component();

        auth    = FirebaseAuth.getInstance();
        userID  = auth.getCurrentUser().getUid();
        collRef = db.collection("users"); // getCollection
        docRef  = collRef.document(userID); // getDocument

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();

                    if (document.exists()) {
                        UserModel userModel = document.toObject(UserModel.class);
                        Log.d(TAG, "Document Snapshot data: "+document.getData());
                        int role            = userModel.getRoleID();
                        String nama         = userModel.getNama();
                        String alamat       = userModel.getAlamat();
                        String noTelp       = userModel.getNoTelp();
                        String email        = userModel.getEmail();

                        ProvinsiModel provinsi = null;
                        KotaKabupatenModel kotaKabupaten = null;
                        KecamatanModel kecamatan = null;

                        // Log.d(TAG, "UserModel Prov :"+userModel.getProvinsi());
                        // Log.d(TAG, "Provinsi :"+provinsi);

                        if (userModel.getProvinsi() != null) {
                            provinsi = userModel.getProvinsi();
                            idProvinsi      = provinsi.getId();
                            namaProvinsi    = provinsi.getNama();
                        }
                        if (userModel.getKotaKabupaten() != null) {
                            kotaKabupaten = userModel.getKotaKabupaten();
                            idKotaKab       = kotaKabupaten.getId();
                            namaKotaKab     = kotaKabupaten.getNama();
                        }
                        if (userModel.getKecamatan() != null) {
                            kecamatan = userModel.getKecamatan();
                            idKecamatan     = kecamatan.getId();
                            namaKecamatan   = kecamatan.getNama();
                        }

                        if (provinsi != null ) {
                            tvProvinsi.setText(namaProvinsi);
                        }
                        if (kotaKabupaten != null ) {
                            tvKotaKabupaten.setText(namaKotaKab);
                        }
                        if (kecamatan != null) {
                            tvKecamatan.setText(namaKecamatan);
                        }

                        String jamBuka = "";
                        String jamTutup= "";
                        if (!userModel.getJamBuka().isEmpty() ) {
                            jamBuka = userModel.getJamBuka();
                            tvJamBuka.setText(jamBuka);
                        }
                        if (!userModel.getJamTutup().isEmpty() ) {
                            jamTutup = userModel.getJamTutup();
                            tvJamTutup.setText(jamTutup);
                        }

                        Log.d(TAG, "" +
                                "Provinsi : " +provinsi+"\n"+
                                "Kota / Kab : "+kotaKabupaten+"\n"+
                                "Kecamatan : "+kecamatan);

                        Log.d(TAG, "" +
                                "Jam Buka : " +jamBuka+"\n"+
                                "Jam Tutup : "+jamTutup);

                        tvNama.setText(nama);
                        tvAlamat.setText(alamat);
                        tvNoTelp.setText(noTelp);
                        tvEmail.setText(email);

                    } else {
                        Log.d(TAG, "Document tidak ditemukan");
                    }

                } else {
                    Log.d(TAG, "get Task failed with ", task.getException());
                }
            }
        });
    }

    private void component() {
        tvNama          = findViewById(R.id.TvNama);
        tvNoTelp        = findViewById(R.id.TvNoTelp);
        tvEmail         = findViewById(R.id.TvEmail);
        tvProvinsi      = findViewById(R.id.TvProvinsi);
        tvKotaKabupaten = findViewById(R.id.TvKotaKabupaten);
        tvKecamatan     = findViewById(R.id.TvKecamatan);
        tvAlamat        = findViewById(R.id.TvAlamat);
        tvJamBuka       = findViewById(R.id.TvJamBuka);
        tvJamTutup      = findViewById(R.id.TvJamTutup);
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

    public void EditProfile(View view) {
        Intent intent = new Intent(ProfilActivity.this, EditProfilActivity.class);
        startActivity(intent);
    }


}