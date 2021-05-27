package com.semutunic.pesenmlijo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.BerandaPembeliModel;

import java.util.ArrayList;

public class BerandaPembeliAdapter extends RecyclerView.Adapter<BerandaPembeliAdapter.berandaviewholder> {
    ArrayList<BerandaPembeliModel> dataholderberanda;

    public BerandaPembeliAdapter(ArrayList<BerandaPembeliModel> dataholderberanda) {
        this.dataholderberanda = dataholderberanda;
    }

    @NonNull
    @Override
    public BerandaPembeliAdapter.berandaviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_beranda_pembeli, parent, false);
        return new BerandaPembeliAdapter.berandaviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BerandaPembeliAdapter.berandaviewholder holder, int position) {
        holder.imgproduk.setImageResource(dataholderberanda.get(position).getImage());
        holder.namatoko.setText(dataholderberanda.get(position).getNamatoko());
        holder.namaproduk.setText(dataholderberanda.get(position).getNamaproduk());
        holder.harga.setText(dataholderberanda.get(position).getHargaproduk());
    }

    @Override
    public int getItemCount() {
        return dataholderberanda.size();
    }

    class berandaviewholder extends RecyclerView.ViewHolder {
        private ImageView imgproduk;
        private TextView namatoko, namaproduk, harga;

        public berandaviewholder(@NonNull View itemView) {
            super(itemView);
            imgproduk = itemView.findViewById(R.id.ImgProduk);
            namatoko = itemView.findViewById(R.id.TVNamaToko2);
            namaproduk = itemView.findViewById(R.id.TVNamaProduk3);
            harga = itemView.findViewById(R.id.TVHargaProduk3);
        }
    }
}
