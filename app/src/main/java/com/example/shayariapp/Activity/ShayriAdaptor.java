package com.example.shayariapp.Activity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shayariapp.R;

public class ShayriAdaptor extends RecyclerView.Adapter<ShayriAdaptor.ShayriHolder> {

    String[] shayri;
    ShayriClick click;
    Context context;
    public ShayriAdaptor(String[] shayri, ShayriClick click) {
        this.shayri = shayri;
        this.click = click;
    }
    
    @NonNull
    @Override
    public ShayriAdaptor.ShayriHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shayri_item,parent,false);
        return new ShayriHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShayriAdaptor.ShayriHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.txtShayri.setText(shayri[position]);
        holder.itemView.setOnClickListener(view -> click.getShayri(shayri[position]));

    }


    @Override
    public int getItemCount() {
        return shayri.length;
    }

    class ShayriHolder extends RecyclerView.ViewHolder {
        TextView txtShayri;
        public ShayriHolder(@NonNull View itemView) {
            super(itemView);

            txtShayri = itemView.findViewById(R.id.txtShayri);
        }
    }

}
