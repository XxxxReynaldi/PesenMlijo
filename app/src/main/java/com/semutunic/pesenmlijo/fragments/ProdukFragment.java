package com.semutunic.pesenmlijo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.activities.ProfilActivity;
import com.semutunic.pesenmlijo.activities.TambahProduk;
import com.semutunic.pesenmlijo.adapter.BerandaAdapter;
import com.semutunic.pesenmlijo.adapter.ProdukAdapter;
import com.semutunic.pesenmlijo.models.BerandaModel;
import com.semutunic.pesenmlijo.models.ProdukModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProdukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdukFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
//    RecyclerView recyclerView;
//    ArrayList<ProdukModel> dataholders;

    public ProdukFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProdukFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProdukFragment newInstance(String param1, String param2) {
        ProdukFragment fragment = new ProdukFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private ProdukAdapter adapter;
    private List<ProdukModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produk, container, false);
        recyclerView = view.findViewById(R.id.Precview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        db = FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        adapter = new ProdukAdapter(this, list);
        recyclerView.setAdapter(adapter);

        //button tambah produk
        Button button = (Button) view.findViewById(R.id.BtnTambahProduk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahProduk();
            }
        });

        showData(view);
        return view;
    }

    private void showData(View view){

        db.collection("Produk").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()){

                            ProdukModel model = new ProdukModel(snapshot.getString("id"), snapshot.getString("nama produk"), snapshot.getString("harga"));
                            list.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Oops ... something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Tambah Produk
    public void tambahProduk() {
        Intent intent = new Intent(getActivity(), TambahProduk.class);
        startActivity(intent);
    }
}