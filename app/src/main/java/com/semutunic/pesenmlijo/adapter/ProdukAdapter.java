package com.semutunic.pesenmlijo.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.fragments.ProdukFragment;
import com.semutunic.pesenmlijo.models.ProdukModel;

import java.util.ArrayList;
import java.util.List;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProductViewHolder> {
    private ProdukFragment activity;
    private List<ProdukModel> mList;

    public ProdukAdapter(ProdukFragment activity, List<ProdukModel> mList){
        this.activity = activity;
        this.mList = mList;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_produk, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
//        holder.img.setImageResource(dataholders.get(position).getImage());
//        holder.headerP.setText(dataholders.get(position).getHeaderP());
//        holder.descP.setText(dataholders.get(position).getDescP());

        holder.namaproduk.setText(mList.get(position).getNamaproduk());
        holder.harga.setText(mList.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
//        ImageView img;
//        TextView headerP, descP;

        TextView namaproduk, kategori, harga, minorder, desc;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
//            img = itemView.findViewById(R.id.ImgProduk);
//            headerP = itemView.findViewById(R.id.TVNamaProduk);
//            descP = itemView.findViewById(R.id.TVHargaProduk);

            namaproduk  =   itemView.findViewById(R.id.TVNamaProduk);
            harga       =   itemView.findViewById(R.id.TVHargaProduk);
        }
    }
}