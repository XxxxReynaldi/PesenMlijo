package com.semutunic.pesenmlijo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.PesananBaruModel;
import com.semutunic.pesenmlijo.models.ProdukModel;

import java.util.ArrayList;

public class PesananBaruAdapter extends RecyclerView.Adapter<PesananBaruAdapter.PesananViewHolder> {

    ArrayList<PesananBaruModel> dataholderpesanan;

    public PesananBaruAdapter(ArrayList<PesananBaruModel>  dataholderpesanan) {
        this.dataholderpesanan =  dataholderpesanan;
    }

    @NonNull
    @Override
    public PesananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_pesanan_baru, parent, false);
        return new PesananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesananViewHolder holder, int position) {
        holder.img.setImageResource(dataholderpesanan.get(position).getImage());
        holder.tanggal.setText(dataholderpesanan.get(position).getTanggal());
        holder.namapembeli.setText(dataholderpesanan.get(position).getNamapembeli());
        holder.jumlahproduk.setText(dataholderpesanan.get(position).getJumlahproduk());
    }

    @Override
    public int getItemCount() {
        return (dataholderpesanan != null) ? dataholderpesanan.size() : 0;
    }

    class PesananViewHolder extends RecyclerView.ViewHolder {
       private ImageView img;
       private TextView tanggal, namapembeli, jumlahproduk;

        public PesananViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImgProduk);
            tanggal = itemView.findViewById(R.id.TvTgl);
            namapembeli = itemView.findViewById(R.id.TVNamaPembeli);
            jumlahproduk = itemView.findViewById(R.id.TvJumlahProduk);
        }
    }
}
