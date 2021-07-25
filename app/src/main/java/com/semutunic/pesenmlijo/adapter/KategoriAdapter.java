package com.semutunic.pesenmlijo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.KategoriModel;

import java.util.ArrayList;

public class KategoriAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context ctx;
    private ArrayList<KategoriModel> imageModelArrayList;
    private ImageView ivGallery;
    private TextView textView;

    public KategoriAdapter(Context ctx, ArrayList<KategoriModel> imageModelArrayList) {

        this.ctx = ctx;
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.col_kategori, parent, false);

        ivGallery = (ImageView) itemView.findViewById(R.id.ivGallery);
        textView = (TextView) itemView.findViewById(R.id.tv);

        ivGallery.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        textView.setText(imageModelArrayList.get(position).getName());

        return itemView;
    }
}