package com.semutunic.pesenmlijo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.DibatalkanModel;

import java.util.ArrayList;

public class DibatalkanAdapter extends RecyclerView.Adapter<DibatalkanAdapter.DibatalkanViewHolder> {

    ArrayList<DibatalkanModel> dataholdedibatalkan;

    public DibatalkanAdapter(ArrayList<DibatalkanModel> dataholdedibatalkan) {
        this.dataholdedibatalkan =  dataholdedibatalkan;
    }

    @NonNull
    @Override
    public DibatalkanAdapter.DibatalkanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_dibatalkan, parent, false);
        return new DibatalkanAdapter.DibatalkanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DibatalkanAdapter.DibatalkanViewHolder holder, int position) {
        holder.img.setImageResource(dataholdedibatalkan.get(position).getImage());
        holder.tanggal.setText(dataholdedibatalkan.get(position).getTanggal());
        holder.namapembeli.setText(dataholdedibatalkan.get(position).getNamapembeli());
        holder.jumlahproduk.setText(dataholdedibatalkan.get(position).getJumlahproduk());
    }

    @Override
    public int getItemCount() {
        return (dataholdedibatalkan != null) ? dataholdedibatalkan.size() : 0;
    }

    class DibatalkanViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tanggal, namapembeli, jumlahproduk;

        public DibatalkanViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImgProduk);
            tanggal = itemView.findViewById(R.id.TvTgl);
            namapembeli = itemView.findViewById(R.id.TVNamaPembeli);
            jumlahproduk = itemView.findViewById(R.id.TvJumlahProduk);
        }
    }
}