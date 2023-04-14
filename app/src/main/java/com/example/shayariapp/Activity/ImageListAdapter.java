package com.example.shayariapp.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shayariapp.R;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListHolder> {


    int[] imgArray;
    ImageClick click;
    Context context;
    public ImageListAdapter(int[] imgArray, ImageClick click) {
        this.imgArray = imgArray;
        this.click = click;
    }

    @NonNull
    @Override
    public ImageListAdapter.ImageListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_item,parent,false);
        return new ImageListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ImageListHolder holder, int position) {

        Glide.with(context).load(imgArray[position]).into(holder.imgItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.getImage(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgArray.length;
    }

    public class ImageListHolder extends RecyclerView.ViewHolder{

        ImageView imgItem;
        public ImageListHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
        }
    }
}
