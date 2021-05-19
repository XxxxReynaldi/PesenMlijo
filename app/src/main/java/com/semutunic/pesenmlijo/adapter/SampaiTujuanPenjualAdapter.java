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
import com.semutunic.pesenmlijo.models.SampaiTujuanPenjualModel;

import java.util.ArrayList;

public class SampaiTujuanPenjualAdapter extends RecyclerView.Adapter<SampaiTujuanPenjualAdapter.SampaiTujuanPenjualViewHolder> {

    ArrayList<SampaiTujuanPenjualModel> dataholdersampaipenjual;

    public SampaiTujuanPenjualAdapter(ArrayList<SampaiTujuanPenjualModel> dataholdersampaipenjual) {
        this.dataholdersampaipenjual =  dataholdersampaipenjual;
    }

    @NonNull
    @Override
    public SampaiTujuanPenjualAdapter.SampaiTujuanPenjualViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_sampai_tujuan_penjual, parent, false);
        return new SampaiTujuanPenjualAdapter.SampaiTujuanPenjualViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampaiTujuanPenjualAdapter.SampaiTujuanPenjualViewHolder holder, int position) {
        holder.img.setImageResource(dataholdersampaipenjual.get(position).getImage());
        holder.tanggal.setText(dataholdersampaipenjual.get(position).getTanggal());
        holder.namapembeli.setText(dataholdersampaipenjual.get(position).getNamapembeli());
        holder.jumlahproduk.setText(dataholdersampaipenjual.get(position).getJumlahproduk());
    }

    @Override
    public int getItemCount() {
        return (dataholdersampaipenjual != null) ? dataholdersampaipenjual.size() : 0;
    }

    class SampaiTujuanPenjualViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tanggal, namapembeli, jumlahproduk;

        public SampaiTujuanPenjualViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImgProduk);
            tanggal = itemView.findViewById(R.id.TvTgl);
            namapembeli = itemView.findViewById(R.id.TVNamaPembeli);
            jumlahproduk = itemView.findViewById(R.id.TvJumlahProduk);
        }
    }
}