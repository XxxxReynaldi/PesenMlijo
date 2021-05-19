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
import com.semutunic.pesenmlijo.models.DitolakModel;

import java.util.ArrayList;

public class DitolakAdapter extends RecyclerView.Adapter<DitolakAdapter.DitolakViewHolder> {

    ArrayList<DitolakModel> dataholdeditolak;

    public DitolakAdapter(ArrayList<DitolakModel> dataholdeditolak) {
        this.dataholdeditolak =  dataholdeditolak;
    }

    @NonNull
    @Override
    public DitolakAdapter.DitolakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_ditolak, parent, false);
        return new DitolakAdapter.DitolakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DitolakAdapter.DitolakViewHolder holder, int position) {
        holder.img.setImageResource(dataholdeditolak.get(position).getImage());
        holder.tanggal.setText(dataholdeditolak.get(position).getTanggal());
        holder.namapembeli.setText(dataholdeditolak.get(position).getNamapembeli());
        holder.jumlahproduk.setText(dataholdeditolak.get(position).getJumlahproduk());
    }

    @Override
    public int getItemCount() {
        return (dataholdeditolak != null) ? dataholdeditolak.size() : 0;
    }

    class DitolakViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tanggal, namapembeli, jumlahproduk;

        public DitolakViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImgProduk);
            tanggal = itemView.findViewById(R.id.TvTgl);
            namapembeli = itemView.findViewById(R.id.TVNamaPembeli);
            jumlahproduk = itemView.findViewById(R.id.TvJumlahProduk);
        }
    }
}