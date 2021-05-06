package com.semutunic.pesenmlijo.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.ProdukModel;

import java.util.ArrayList;
public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProductViewHolder> {

    ArrayList<ProdukModel> dataholders;

    public ProdukAdapter(ArrayList<ProdukModel> dataholders) {
        this.dataholders = dataholders;
    }

    @NonNull
    @Override
    public ProdukAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_produk,parent,false);
        return new ProdukAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdukAdapter.ProductViewHolder holder, int position)
    {
        holder.img.setImageResource(dataholders.get(position).getImage());
        holder.headerP.setText(dataholders.get(position).getHeaderP());
        holder.descP.setText(dataholders.get(position).getDescP());
    }

    @Override
    public int getItemCount() {
        return dataholders.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView headerP,descP;
        public ProductViewHolder(@NonNull View itemView)
        {
            super(itemView);
            img=itemView.findViewById(R.id.ImgProduk);
            headerP=itemView.findViewById(R.id.TVNamaProduk);
            descP=itemView.findViewById(R.id.TVHargaProduk);
        }
    }
}