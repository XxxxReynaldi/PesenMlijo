package com.semutunic.pesenmlijo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.SampaiTujuanPenjualModel;
import com.semutunic.pesenmlijo.models.SelesaiModel;

import java.util.ArrayList;

public class SelesaiAdapter extends RecyclerView.Adapter<SelesaiAdapter.SelesaiViewHolder> {

    ArrayList<SelesaiModel> dataholderselesai;

    public SelesaiAdapter(ArrayList<SelesaiModel> dataholderselesai) {
        this.dataholderselesai =  dataholderselesai;
    }

    @NonNull
    @Override
    public SelesaiAdapter.SelesaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_selesai, parent, false);
        return new SelesaiAdapter.SelesaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelesaiAdapter.SelesaiViewHolder holder, int position) {
        holder.img.setImageResource(dataholderselesai.get(position).getImage());
        holder.tanggal.setText(dataholderselesai.get(position).getTanggal());
        holder.namapembeli.setText(dataholderselesai.get(position).getNamapembeli());
        holder.jumlahproduk.setText(dataholderselesai.get(position).getJumlahproduk());
    }

    @Override
    public int getItemCount() {
        return (dataholderselesai != null) ? dataholderselesai.size() : 0;
    }

    class SelesaiViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tanggal, namapembeli, jumlahproduk;

        public SelesaiViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImgProduk);
            tanggal = itemView.findViewById(R.id.TvTgl);
            namapembeli = itemView.findViewById(R.id.TVNamaPembeli);
            jumlahproduk = itemView.findViewById(R.id.TvJumlahProduk);
        }
    }
}