package com.hands_on_android.lab4.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hands_on_android.lab4.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageGridAdapter extends RecyclerView.Adapter<ImageGridViewHolder> {

    private String breedName;
    private ArrayList<String> imageUrls;

    public ImageGridAdapter(String breedName, ArrayList<String> imageUrls) {
        this.breedName = breedName;
        this.imageUrls = imageUrls;
    }

    @NonNull
    @Override
    public ImageGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_grid_item,parent,false);
        return  new ImageGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageGridViewHolder holder, int position) {
        Picasso.get().load(imageUrls.get(position)).placeholder(R.color.placeholder_color).centerCrop().
                fit().into(holder.getImageView());
        holder.setCurrent_url(imageUrls.get(position));
        holder.setBreed(breedName);

    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }
}
