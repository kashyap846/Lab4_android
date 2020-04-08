package com.hands_on_android.lab4.views;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hands_on_android.lab4.DogViewerApplication;
import com.hands_on_android.lab4.R;
import com.hands_on_android.lab4.activities.ImageGridActivity;
import com.hands_on_android.lab4.activities.MainActivity;
import com.hands_on_android.lab4.utils.Const;

public class MainViewHolder extends RecyclerView.ViewHolder {

    public TextView getBreed_name() {
        return breed_name;
    }

    public TextView getSub_breed() {
        return sub_breed;
    }

    private TextView breed_name,sub_breed;
    //private CardView cardView;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        this.breed_name = itemView.findViewById(R.id.breed_name);
        this.sub_breed = itemView.findViewById(R.id.sub_breed);
       // this.cardView = itemView.findViewById(R.id.card_view);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("setOnClickListener", "setOnClickListener"+breed_name.getText());
                Intent intent= new Intent(DogViewerApplication.getContext(), ImageGridActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Const.BREED_NAME,breed_name.getText());
                DogViewerApplication.getContext().startActivity(intent);
            }
        });

//        this.cardView.setOnClickListener(v -> {
//            Log.e("MainViewHolder: ", "");
//            Intent intent;
//            intent = new Intent(DogViewerApplication.getContext(), ImageGridActivity.class);
//        });



    }
}
