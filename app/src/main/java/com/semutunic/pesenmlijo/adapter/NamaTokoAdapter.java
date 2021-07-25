package com.semutunic.pesenmlijo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.NamaTokoModel;

import java.util.ArrayList;

public class NamaTokoAdapter extends RecyclerView.Adapter<NamaTokoAdapter.NamaTokoviewholder> {

    ArrayList<NamaTokoModel> dataholdernamatoko;

    public NamaTokoAdapter(ArrayList<NamaTokoModel> dataholdernamatoko) {
        this.dataholdernamatoko = dataholdernamatoko;
    }

    @NonNull
    @Override
    public NamaTokoAdapter.NamaTokoviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_nama_toko, parent, false);
        return new NamaTokoAdapter.NamaTokoviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamaTokoAdapter.NamaTokoviewholder holder, int position) {
        holder.imgproduk.setImageResource(dataholdernamatoko.get(position).getImage());
        holder.namatoko.setText(dataholdernamatoko.get(position).getNamatoko());
        holder.namaproduk.setText(dataholdernamatoko.get(position).getNamaproduk());
        holder.harga.setText(dataholdernamatoko.get(position).getHargaproduk());
    }

    @Override
    public int getItemCount() {
        return (dataholdernamatoko != null) ? dataholdernamatoko.size() : 0;
    }

    class NamaTokoviewholder extends RecyclerView.ViewHolder {
        private ImageView imgproduk;
        private TextView namatoko, namaproduk, harga;

        public NamaTokoviewholder(@NonNull View itemView) {
            super(itemView);
            imgproduk = itemView.findViewById(R.id.ImgProduk);
            namatoko = itemView.findViewById(R.id.TVNamaToko);
            namaproduk = itemView.findViewById(R.id.TVNamaProduk2);
            harga = itemView.findViewById(R.id.TVHargaProduk2);
        }
    }
}
