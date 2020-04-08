package com.hands_on_android.lab4.views;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hands_on_android.lab4.DogViewerApplication;
import com.hands_on_android.lab4.R;
import com.hands_on_android.lab4.activities.ImageActivity;
import com.hands_on_android.lab4.utils.Const;

public class ImageGridViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private String current_url;

    public void setBreed(String breed) {
        this.breed = breed;
    }

    private String breed;

    public ImageView getImageView() {
        return imageView;
    }



    public void setCurrent_url(String current_url) {
        this.current_url = current_url;
    }



    public ImageGridViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView);
        //imageView.get

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ImageGridViewHolder", "ImageGridViewHolder");
                Intent intent;
                intent = new Intent(DogViewerApplication.getContext(), ImageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Log.e("onClick:current_url ", ""+current_url);
                Log.e("onClick:breed ", ""+breed);
                intent.putExtra(Const.SELECTED_URL,current_url);
                intent.putExtra(Const.BREED_NAME,breed);
                DogViewerApplication.getContext().startActivity(intent);
            }
        });
    }
}
