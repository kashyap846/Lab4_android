package com.hands_on_android.lab4.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.hands_on_android.lab4.R;
import com.hands_on_android.lab4.api.model.BreedInfo;

import java.util.ArrayList;
import java.util.HashMap;

import static android.view.View.GONE;

public class MainAdapter extends ListAdapter<BreedInfo, MainViewHolder>  {
    private ArrayList<BreedInfo> data;

    private static final DiffUtil.ItemCallback<BreedInfo> DIFF_CALLBACK = new DiffUtil.ItemCallback<BreedInfo>() {
        @Override
        public boolean areItemsTheSame(@NonNull BreedInfo oldItem, @NonNull BreedInfo newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull BreedInfo oldItem, @NonNull BreedInfo newItem) {
            return oldItem.equals(newItem);
        }
    };

    public MainAdapter(ArrayList<BreedInfo> data) {
        super(DIFF_CALLBACK);
        this.data = data;
        submitList(data);
       // sub
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_main_recycler_view_item,parent,false);
        return  new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.getBreed_name().setText(data.get(position).getBreedName());
        if(data.get(position).getSubBreedCountText()==null){
            holder.getSub_breed().setVisibility(View.GONE);

        }else{
            holder.getSub_breed().setVisibility(View.VISIBLE);
            holder.getSub_breed().setText(data.get(position).getSubBreedCountText());
        }

    }
}
