package com.hands_on_android.lab4.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hands_on_android.lab4.R;
import com.hands_on_android.lab4.api.ServiceGenerator;
import com.hands_on_android.lab4.api.model.RandomImage;
import com.hands_on_android.lab4.utils.Const;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageActivity extends AppCompatActivity {
    private String breed;
    private String currentUrl = null;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.imageView);

        breed = getIntent().getStringExtra(Const.BREED_NAME);
        currentUrl = getIntent().getStringExtra(Const.SELECTED_URL);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(breed);
        }

        //handleRefresh();
        loadImage();
    }

    private void handleRefresh() {
        ServiceGenerator.getService().getRandomImage(breed).enqueue(new Callback<RandomImage>() {
            @Override
            public void onResponse(Call<RandomImage> call, Response<RandomImage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    currentUrl = response.body().getUrl();
                    loadImage();
                }
            }

            @Override
            public void onFailure(Call<RandomImage> call, Throwable t) {

            }
        });

    }

    private void loadImage() {
        Picasso.get().load(currentUrl).fit().centerInside().into(imageView);
    }

    private void handleOpen() {
        if (currentUrl == null) {
            return;
        }

        Intent open = new Intent(Intent.ACTION_VIEW, Uri.parse(currentUrl));
        startActivity(open);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_refresh:
                handleRefresh();
                break;
            case R.id.action_open:
                handleOpen();
                break;
        }

        return true;
    }
}
