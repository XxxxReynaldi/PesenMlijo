package com.semutunic.pesenmlijo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.activities.Dibatalkan;
import com.semutunic.pesenmlijo.activities.Ditolak;
import com.semutunic.pesenmlijo.activities.Selesai;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PesananPembeliFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PesananPembeliFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    LinearLayout linearLayout;
    public PesananPembeliFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PesananPembeliFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PesananPembeliFragment newInstance(String param1, String param2) {
        PesananPembeliFragment fragment = new PesananPembeliFragment();
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
        View view = inflater.inflate(R.layout.fragment_pesanan_pembeli, container, false);

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