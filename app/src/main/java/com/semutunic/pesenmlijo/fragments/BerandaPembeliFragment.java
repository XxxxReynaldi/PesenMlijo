package com.semutunic.pesenmlijo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.activities.Ditolak;
import com.semutunic.pesenmlijo.activities.Kategori;
import com.semutunic.pesenmlijo.adapter.BerandaAdapter;
import com.semutunic.pesenmlijo.adapter.BerandaPembeliAdapter;
import com.semutunic.pesenmlijo.models.BerandaModel;
import com.semutunic.pesenmlijo.models.BerandaPembeliModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BerandaPembeliFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BerandaPembeliFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<BerandaPembeliModel> dataholderberanda;
    TextView textView;

    public BerandaPembeliFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BerandaPembeliFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BerandaPembeliFragment newInstance(String param1, String param2) {
        BerandaPembeliFragment fragment = new BerandaPembeliFragment();
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
        View view = inflater.inflate(R.layout.fragment_beranda_pembeli, container, false);
        recyclerView = view.findViewById(R.id.Berandarecview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholderberanda = new ArrayList<>();

        BerandaPembeliModel data1 = new BerandaPembeliModel(R.drawable.produk, "Bahagia", "Tomat", "10000");
        dataholderberanda.add(data1);

        BerandaPembeliModel data2 = new BerandaPembeliModel(R.drawable.produk, "Sumber Rezeki", "Bawang Merah", "10000");
        dataholderberanda.add(data2);

        BerandaPembeliModel data3 = new BerandaPembeliModel(R.drawable.produk, "Berkah", "Cabai", "10000");
        dataholderberanda.add(data3);

        recyclerView.setAdapter(new BerandaPembeliAdapter(dataholderberanda));

        // lihat semua kategoti
        textView = view.findViewById(R.id.TvLihatSemua);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lihat();
            }
        });

        return view;
    }
    public void Lihat() {
        Intent intent = new Intent(getActivity(), Kategori.class);
        startActivity(intent);
    }
}