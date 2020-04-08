package com.hands_on_android.lab4.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hands_on_android.lab4.R;
import com.hands_on_android.lab4.api.ServiceGenerator;
import com.hands_on_android.lab4.api.model.BreedImageList;
import com.hands_on_android.lab4.api.model.BreedList;
import com.hands_on_android.lab4.utils.Const;
import com.hands_on_android.lab4.views.ImageGridAdapter;
import com.hands_on_android.lab4.views.MainAdapter;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageGridActivity extends AppCompatActivity {
    String breed;
    RecyclerView recyclerView;
    private ImageGridAdapter adapter;
    private ImageView backdrop;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        breed = getIntent().getStringExtra(Const.BREED_NAME);

        if (getSupportActionBar() != null) {
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(breed);
        }
        backdrop = findViewById(R.id.backdropImage);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,Const.GRID_LAYOUT_COUNT));


        ServiceGenerator.getService().getBreedImageList(breed).enqueue(new Callback<BreedImageList>() {
            @Override
            public void onResponse(Call<BreedImageList> call, Response<BreedImageList> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    return;
                }
                Picasso.get().load(response.body().getImageUrls().get(0)).placeholder(R.color.placeholder_color).centerCrop().fit().into(backdrop);
                adapter = new ImageGridAdapter(breed,response.body().getImageUrls());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BreedImageList> call, Throwable t) {

            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return true;
    }
}
