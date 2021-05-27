package com.semutunic.pesenmlijo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.activities.ProfilActivity;
import com.semutunic.pesenmlijo.activities.TambahProduk;
import com.semutunic.pesenmlijo.adapter.BerandaAdapter;
import com.semutunic.pesenmlijo.adapter.ProdukAdapter;
import com.semutunic.pesenmlijo.models.BerandaModel;
import com.semutunic.pesenmlijo.models.ProdukModel;

import java.util.ArrayList;

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
    RecyclerView recyclerView;
    ArrayList<ProdukModel> dataholders;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produk, container, false);
        recyclerView = view.findViewById(R.id.Precview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholders = new ArrayList<>();

        ProdukModel ob1 = new ProdukModel(R.drawable.produk, "Tomat", "60000");
        dataholders.add(ob1);

        ProdukModel ob2 = new ProdukModel(R.drawable.produk, "Bawang Merah", "55000");
        dataholders.add(ob2);

        ProdukModel ob3 = new ProdukModel(R.drawable.produk, "Cabai", "800000");
        dataholders.add(ob3);

        recyclerView.setAdapter(new ProdukAdapter(dataholders));

        //button tambah produk
        Button button = (Button) view.findViewById(R.id.BtnTambahProduk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahProduk();
            }
        });

        return view;
    }

    public void tambahProduk() {
        Intent intent = new Intent(getActivity(), TambahProduk.class);
        startActivity(intent);
    }
}