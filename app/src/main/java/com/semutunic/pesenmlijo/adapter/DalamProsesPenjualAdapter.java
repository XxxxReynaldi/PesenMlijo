package com.semutunic.pesenmlijo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.DalamProsesPenjualModel;

import java.util.ArrayList;

public class DalamProsesPenjualAdapter extends RecyclerView.Adapter<DalamProsesPenjualAdapter.ProsesPenjualViewHolder> {

    ArrayList<DalamProsesPenjualModel> dataholderprosespenjual;

    public DalamProsesPenjualAdapter(ArrayList<DalamProsesPenjualModel>  dataholderprosespenjual) {
        this.dataholderprosespenjual =  dataholderprosespenjual;
    }

    @NonNull
    @Override
    public DalamProsesPenjualAdapter.ProsesPenjualViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_dalam_proses_penjual, parent, false);
        return new DalamProsesPenjualAdapter.ProsesPenjualViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DalamProsesPenjualAdapter.ProsesPenjualViewHolder  holder, int position) {
        holder.img.setImageResource(dataholderprosespenjual.get(position).getImage());
        holder.tanggal.setText(dataholderprosespenjual.get(position).getTanggal());
        holder.namapembeli.setText(dataholderprosespenjual.get(position).getNamapembeli());
        holder.jumlahproduk.setText(dataholderprosespenjual.get(position).getJumlahproduk());
    }

    @Override
    public int getItemCount() {
        return (dataholderprosespenjual != null) ? dataholderprosespenjual.size() : 0;
    }

    class ProsesPenjualViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tanggal, namapembeli, jumlahproduk;

        public ProsesPenjualViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImgProduk);
            tanggal = itemView.findViewById(R.id.TvTgl);
            namapembeli = itemView.findViewById(R.id.TVNamaPembeli);
            jumlahproduk = itemView.findViewById(R.id.TvJumlahProduk);
        }
    }
}