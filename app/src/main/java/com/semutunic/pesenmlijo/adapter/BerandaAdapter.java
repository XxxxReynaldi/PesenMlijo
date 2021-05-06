package com.semutunic.pesenmlijo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semutunic.pesenmlijo.R;
import com.semutunic.pesenmlijo.models.BerandaModel;

import java.util.ArrayList;

public class BerandaAdapter extends RecyclerView.Adapter<BerandaAdapter.myviewholder>
{
    ArrayList<BerandaModel> dataholder;

    public BerandaAdapter(ArrayList<BerandaModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_beranda,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.img.setImageResource(dataholder.get(position).getImage());
        holder.header.setText(dataholder.get(position).getHeader());
        holder.desc.setText(dataholder.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView header,desc;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=itemView.findViewById(R.id.Img1);
            header=itemView.findViewById(R.id.TVNamaPembeli);
            desc=itemView.findViewById(R.id.TVNamaBarang);
        }
    }
}
