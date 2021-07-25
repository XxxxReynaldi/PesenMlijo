package com.semutunic.pesenmlijo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class EditProfilActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    private TextInputLayout lyNama, lyNotelp, lyEmail, lyAlamat;
    private TextInputLayout lyJamBuka, lyJamTutup;

    private EditText etNama, etNotelp, etEmail, etAlamat;
    private EditText etJamBuka, etJamTutup;
    private Spinner spProvinsi;
//    AutoCompleteTextView spProvinsi;
    private Spinner spKotaKabupaten, spKecamatan;

    private Button btnSimpanEditProfil;

    private FirebaseAuth auth;
    private ProgressBar progressBar;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collRef ;
    private DocumentReference docRef;

    private String userID;

    private static String URL_READ_PROVINSI     = "https://dev.farizdotid.com/api/daerahindonesia/provinsi";
    private static String URL_READ_KOTAKAB      = "https://dev.farizdotid.com/api/daerahindonesia/kota";

    private ArrayList<ProvinsiModel> provinsiList = new ArrayList<>();
    private ArrayList<KotaKabupatenModel> kotaKabList = new ArrayList<>();

    private int idProvinsi  = 0;
    private int idKotaKab   = 0;
    private int idKecamatan = 0;
    private String namaKotaKab      = "";
    private String namaKecamatan    = "";
    private String namaProvinsi     = "";

    private String mJamBuka         = "";
    private String mJamTutup        = "";

    private int roleID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        component();
        getProfile();

        initSpinnerProvinsi();
        btnJamBukaTutup();

        saveProfile();
    }

    private void component() {
        lyNama      = findViewById(R.id.LyNama);
        lyNotelp    = findViewById(R.id.LyNotelp);
        lyEmail     = findViewById(R.id.LyEmail);
        lyAlamat    = findViewById(R.id.LyAlamat);

        etNama      = findViewById(R.id.EtNama);
        etNotelp    = findViewById(R.id.EtNotelp);
        etEmail     = findViewById(R.id.EtEmail);
        etAlamat    = findViewById(R.id.EtAlamat);

        spProvinsi      = findViewById(R.id.SpProvinsi);
        spKotaKabupaten = findViewById(R.id.SpKotaKabupaten);
        spKecamatan     = findViewById(R.id.SpKecamatan);

        etJamBuka   = findViewById(R.id.EtJamBuka);
        etJamTutup  = findViewById(R.id.EtJamTutup);

        btnSimpanEditProfil = findViewById(R.id.BtnSimpanEditProfil);

        auth    = FirebaseAuth.getInstance();
        userID  = auth.getCurrentUser().getUid();
        collRef = db.collection("users"); // getCollection
        docRef  = collRef.document(userID); // getDocument
    }

    private void getProfile() {
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

                        roleID  = role;

                        ProvinsiModel provinsi = null;
                        KotaKabupatenModel kotaKabupaten = null;
                        KecamatanModel kecamatan = null;

                        if (userModel.getProvinsi() != null) {
                            provinsi        = userModel.getProvinsi();
                            idProvinsi      = provinsi.getId();
                            namaProvinsi    = provinsi.getNama();
                        }
                        if (userModel.getKotaKabupaten() != null) {
                            kotaKabupaten   = userModel.getKotaKabupaten();
                            idKotaKab       = kotaKabupaten.getId();
                            namaKotaKab     = kotaKabupaten.getNama();
                        }
                        if (userModel.getKecamatan() != null) {
                            kecamatan       = userModel.getKecamatan();
                            idKecamatan     = kecamatan.getId();
                            namaKecamatan   = kecamatan.getNama();
                        }

                        if (idProvinsi != 0 || !namaProvinsi.isEmpty() ) {
                            provinsiList.add(new ProvinsiModel(idProvinsi, namaProvinsi));
                        } else {
                            provinsiList.add(new ProvinsiModel(0, "-Pilih Provinsi-"));
                        }

                        if (!userModel.getJamBuka().isEmpty() ) {
                            mJamBuka = userModel.getJamBuka();
                            etJamBuka.setText(mJamBuka);
                            Log.d(TAG, "jam buka :"+mJamBuka);
                        }
                        if (!userModel.getJamTutup().isEmpty() ) {
                            mJamTutup = userModel.getJamTutup();
                            etJamTutup.setText(mJamTutup);
                            Log.d(TAG, "jam tutup :"+mJamTutup);
                        }

                        Log.d(TAG, "" +
                                "Nama : " +nama+"\n"+
                                "Alamat : "+alamat+"\n"+
                                "NoTelp : "+noTelp+"\n"+
                                "Email : "+email);

                        Log.d(TAG, "" +
                                "Provinsi : " +provinsi+"\n"+
                                "Kota / Kab : "+kotaKabupaten+"\n"+
                                "Kecamatan : "+kecamatan);

                        Log.d(TAG, "" +
                                "Jam Buka : " +mJamBuka+"\n"+
                                "Jam Tutup : "+mJamTutup);

                        etNama.setText(nama);
                        etAlamat.setText(alamat);
                        etNotelp.setText(noTelp);
                        etEmail.setText(email);

                    } else {
                        Log.d(TAG, "Document tidak ditemukan");
                    }

                } else {
                    Log.d(TAG, "get Task failed with ", task.getException());
                }
            }
        });
    }

    private void initSpinnerProvinsi() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_READ_PROVINSI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("provinsi");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject object = jsonArray.getJSONObject(i);

                                int mId = object.getInt("id");
                                String mNama = object.getString("nama").trim();

                                ProvinsiModel provinsiModel = new ProvinsiModel(mId, mNama);
                                provinsiList.add(provinsiModel);

                                adapterProvinsi();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(EditProfilActivity.this, "Catch data gagal " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditProfilActivity.this, "Error Listener "+error.toString() , Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(EditProfilActivity.this);
        requestQueue.add(stringRequest);

        Log.d(TAG, "stringReq Prov"+stringRequest);

    }

    private void adapterProvinsi () {
        ArrayAdapter<ProvinsiModel> adapter = new ArrayAdapter<ProvinsiModel>(
                EditProfilActivity.this,android.R.layout.simple_spinner_item, provinsiList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        ArrayAdapter<ProvinsiModel> adapter = new ArrayAdapter<ProvinsiModel>(
//                EditProfilActivity.this, android.R.layout.simple_expandable_list_item_1,provinsiList);
//        spProvinsi.setThreshold(1);//akan dibaca dari karakter pertama

        spProvinsi.setAdapter(adapter);

        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ProvinsiModel provinsiModel = (ProvinsiModel) parent.getSelectedItem();
                // initSpinnerKotaKabupaten(provinsiModel); // still bug
                idProvinsi      = provinsiModel.getId();
                namaProvinsi    = provinsiModel.getNama();

                int provinsiID = provinsiList.get(position).getId();
                Toast.makeText(EditProfilActivity.this, "Id : "+provinsiID, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initSpinnerKotaKabupaten(final ProvinsiModel provinsiModel) {
        final ProgressDialog progressDialog = new ProgressDialog(EditProfilActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_READ_KOTAKAB, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.d(TAG, "jsonObj KotaKab : "+jsonObject);
                    JSONArray jsonArray = jsonObject.getJSONArray("kota_kabupaten");
                    Log.d(TAG, "Kota Kab : "+jsonArray);

                    if (kotaKabList.isEmpty()) {
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);

                            int mId = object.getInt("id");
                            // String mIdProv = object.getString("id_provinsi");
                            String mNama = object.getString("nama").trim();

                            KotaKabupatenModel kotaKabModel = new KotaKabupatenModel(mId, mNama);
                            kotaKabList.add(kotaKabModel);

                        }

                    } else {

                        kotaKabList.clear();

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);

                            int mId = object.getInt("id");
                            String mIdProv = object.getString("id_provinsi");
                            String mNama = object.getString("nama").trim();

                            KotaKabupatenModel kotaKabModel = new KotaKabupatenModel(mId, mNama);
                            kotaKabList.add(kotaKabModel);

                        }
                    }

                    adapterKotaKab();

                } catch (JSONException e) {
                    e.printStackTrace();
                    kotaKabList.clear();
                    Toast.makeText(EditProfilActivity.this, "Catch data gagal " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditProfilActivity.this, "Error Listener "+error.toString() , Toast.LENGTH_SHORT).show(); // trouble koneksi
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                idProvinsi = provinsiModel.getId();
                params.put("id_kategori", String.valueOf(idProvinsi));
                return params;
            }

        };

//        RequestQueue requestQueue = Volley.newRequestQueue(EditProfilActivity.this);
//        requestQueue.add(stringRequest);
        Volley.newRequestQueue(this).add(stringRequest);

        Log.d(TAG, "stringReq Kota Kab"+stringRequest);

    }

    private void adapterKotaKab() {
        ArrayAdapter<KotaKabupatenModel> adapter = new ArrayAdapter<KotaKabupatenModel>(
                EditProfilActivity.this,android.R.layout.simple_spinner_item, kotaKabList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spKotaKabupaten.setAdapter(adapter);
        spKotaKabupaten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                KotaKabupatenModel mKotaKabModel = (KotaKabupatenModel) parent.getSelectedItem();
                displayKotaKab(mKotaKabModel);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void displayKotaKab(KotaKabupatenModel mKotaKabModel) {
        idKotaKab = mKotaKabModel.getId();
        namaKotaKab = mKotaKabModel.getNama();

        Toast.makeText(EditProfilActivity.this, ""+idKotaKab,Toast.LENGTH_SHORT).show();
    }

    private void btnJamBukaTutup() {
        etJamBuka.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EditProfilActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mJamBuka = selectedHour + ":" + selectedMinute;
                        etJamBuka.setText(mJamBuka);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Pilih waktu");
                mTimePicker.show();

            }
        });

        etJamTutup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EditProfilActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mJamTutup = selectedHour + ":" + selectedMinute;
                        etJamTutup.setText(mJamTutup);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Pilih waktu");
                mTimePicker.show();

            }
        });
    }

    private void saveProfile() {
        btnSimpanEditProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama         = etNama.getText().toString().trim();
                String NoTelp       = etNotelp.getText().toString().trim();
                String Email        = etEmail.getText().toString().trim();
                String Alamat       = etAlamat.getText().toString().trim();
                String JamBuka      = mJamBuka;
                String JamTutup     = mJamTutup;

                if(TextUtils.isEmpty(Nama)){
                    Toast.makeText(getApplicationContext(), "Masukkan nama anda!", Toast.LENGTH_SHORT).show();
                    lyNama.setError("Masukkan nama anda!");
                    return;
                }
                if(TextUtils.isEmpty(NoTelp)){
                    Toast.makeText(getApplicationContext(), "Masukkan telp anda!", Toast.LENGTH_SHORT).show();
                    lyNotelp.setError("Masukkan telp anda!");
                    return;
                }
                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplicationContext(), "Masukkan email anda!", Toast.LENGTH_SHORT).show();
                    lyEmail.setError("Masukkan email anda!");
                    return;
                }
                if(TextUtils.isEmpty(Alamat)){
                    Toast.makeText(getApplicationContext(), "Masukkan alamat anda!", Toast.LENGTH_SHORT).show();
                    lyAlamat.setError("Masukkan alamat anda!");
                    return;
                }


                ProvinsiModel provinsi = new ProvinsiModel();
                provinsi = new ProvinsiModel(idProvinsi, namaProvinsi);

                KotaKabupatenModel kotaKab = new KotaKabupatenModel();
                kotaKab = new KotaKabupatenModel(idKotaKab, namaKotaKab);

                KecamatanModel kecamatan = new KecamatanModel();
                kecamatan = new KecamatanModel(idKecamatan, namaKecamatan);

                UserModel userModel = new UserModel(Nama, Alamat, NoTelp, Email, provinsi, kotaKab, kecamatan, JamBuka, JamTutup, roleID );
                CollectionReference collRefUser = db.collection("users");
                DocumentReference docRefUser = collRefUser.document(userID);
                docRefUser.set(userModel);

                Toast.makeText(getApplicationContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                closeKeyboard();

            }
        });
    }

    private void closeKeyboard() {
        View view = EditProfilActivity.this.getCurrentFocus();
        if(view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}