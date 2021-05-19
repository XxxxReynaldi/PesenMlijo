package com.semutunic.pesenmlijo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.activities.DalamPengirimanPenjual;
import com.semutunic.pesenmlijo.activities.DalamProsesPenjual;
import com.semutunic.pesenmlijo.activities.Dibatalkan;
import com.semutunic.pesenmlijo.activities.Ditolak;
import com.semutunic.pesenmlijo.activities.PesananBaru;
import com.semutunic.pesenmlijo.activities.SampaiTujuanPenjual;
import com.semutunic.pesenmlijo.activities.Selesai;
import com.semutunic.pesenmlijo.activities.TambahProduk;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PesananFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PesananFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    LinearLayout linearLayout;
    public PesananFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PesananFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PesananFragment newInstance(String param1, String param2) {
        PesananFragment fragment = new PesananFragment();
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
        View view = inflater.inflate(R.layout.fragment_pesanan, container, false);

        // pesanan baru
        linearLayout = (LinearLayout) view.findViewById(R.id.PesananBaru);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesananbaru();
            }
        });

        // dalam proses
        linearLayout = (LinearLayout) view.findViewById(R.id.Diprosespenjual);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diproses();
            }
        });

        // dalam pengiriman
        linearLayout = (LinearLayout) view.findViewById(R.id.Pengiriman);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pengiriman();
            }
        });

        // Sampai tujuan
        linearLayout = (LinearLayout) view.findViewById(R.id.SampaiTujuan);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sampai();
            }
        });

        // Selesai
        linearLayout = (LinearLayout) view.findViewById(R.id.Selesai);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selesai();
            }
        });

        // dibatalkan
        linearLayout = (LinearLayout) view.findViewById(R.id.Dibatalkan);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batal();
            }
        });

        // ditolak
        linearLayout = (LinearLayout) view.findViewById(R.id.Ditolak);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tolak();
            }
        });

        return view;
    }
    public void pesananbaru() {
        Intent intent = new Intent(getActivity(), PesananBaru.class);
        startActivity(intent);
    }

    public void diproses() {
        Intent intent = new Intent(getActivity(), DalamProsesPenjual.class);
        startActivity(intent);
    }

    public void pengiriman() {
        Intent intent = new Intent(getActivity(), DalamPengirimanPenjual.class);
        startActivity(intent);
    }

    public void sampai() {
        Intent intent = new Intent(getActivity(), SampaiTujuanPenjual.class);
        startActivity(intent);
    }

    public void selesai() {
        Intent intent = new Intent(getActivity(), Selesai.class);
        startActivity(intent);
    }

    public void batal() {
        Intent intent = new Intent(getActivity(), Dibatalkan.class);
        startActivity(intent);
    }

    public void tolak() {
        Intent intent = new Intent(getActivity(), Ditolak.class);
        startActivity(intent);
    }
}