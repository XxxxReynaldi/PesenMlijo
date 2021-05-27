package com.semutunic.pesenmlijo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.DalamPengirimanPenjualModel;

import java.util.ArrayList;

public class DalamPengirimanPenjualAdapter extends RecyclerView.Adapter<DalamPengirimanPenjualAdapter.PengirimanPenjualViewHolder> {

    ArrayList<DalamPengirimanPenjualModel> dataholderpengirimanpenjual;

    public DalamPengirimanPenjualAdapter(ArrayList<DalamPengirimanPenjualModel>  dataholderpengirimanpenjual) {
        this.dataholderpengirimanpenjual =  dataholderpengirimanpenjual;
    }

    @NonNull
    @Override
    public DalamPengirimanPenjualAdapter.PengirimanPenjualViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_dalam_pengiriman_penjual, parent, false);
        return new DalamPengirimanPenjualAdapter.PengirimanPenjualViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DalamPengirimanPenjualAdapter.PengirimanPenjualViewHolder holder, int position) {
        holder.img.setImageResource(dataholderpengirimanpenjual.get(position).getImage());
        holder.tanggal.setText(dataholderpengirimanpenjual.get(position).getTanggal());
        holder.namapembeli.setText(dataholderpengirimanpenjual.get(position).getNamapembeli());
        holder.jumlahproduk.setText(dataholderpengirimanpenjual.get(position).getJumlahproduk());
    }

    @Override
    public int getItemCount() {
        return (dataholderpengirimanpenjual != null) ? dataholderpengirimanpenjual.size() : 0;
    }

    class PengirimanPenjualViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tanggal, namapembeli, jumlahproduk;

        public PengirimanPenjualViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImgProduk);
            tanggal = itemView.findViewById(R.id.TvTgl);
            namapembeli = itemView.findViewById(R.id.TVNamaPembeli);
            jumlahproduk = itemView.findViewById(R.id.TvJumlahProduk);
        }
    }
}