package com.semutunic.pesenmlijo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.model.ProdukModel;

import java.util.List;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<ProdukModel> productList;

    //getting the context and product list with constructor
    public ProdukAdapter(Context mCtx, List<ProdukModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_add_produk, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        ProdukModel product = productList.get(position);

        //binding the data with the viewholder views
        holder.namaproduk.setText(product.getNamaProduk());
//        holder.textViewShortDesc.setText(product.getShortdesc());
//        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.hargaproduk.setText(String.valueOf(product.getHargaProduk()));

        holder.image_produk.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView namaproduk, hargaproduk;
        ImageView image_produk;

        public ProductViewHolder(View itemView) {
            super(itemView);

            namaproduk = itemView.findViewById(R.id.namaP);
//            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
//            textViewRating = itemView.findViewById(R.id.textViewRating);
            hargaproduk = itemView.findViewById(R.id.hargaP);
            image_produk = itemView.findViewById(R.id.image_produk);
        }
    }
}