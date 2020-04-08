package com.hands_on_android.lab4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hands_on_android.lab4.R;
import com.hands_on_android.lab4.api.ServiceGenerator;
import com.hands_on_android.lab4.api.model.BreedInfo;
import com.hands_on_android.lab4.api.model.BreedList;
import com.hands_on_android.lab4.utils.Const;
import com.hands_on_android.lab4.views.MainAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
Kashyap Kokkiligadda A00209673

Dinesh Challa. A00210581

Sneha Ratakonda A00210429

Likhith Kumar. A00210580
 */

public class MainActivity extends AppCompatActivity {

    private BreedList breedList;
    private MainAdapter adapter;
    private AppCompatEditText searchEditText;
    RecyclerView recycler_View;
    private Button search_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_View = findViewById(R.id.recycler_view);
        recycler_View.setLayoutManager(new LinearLayoutManager(this));
        search_button = findViewById(R.id.search_button);
        searchEditText = findViewById(R.id.search_text);


        ServiceGenerator.getService().getBreedsList().enqueue(new Callback<BreedList>() {
            @Override
            public void onResponse(Call<BreedList> call, Response<BreedList> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    return;
                }
                breedList = response.body();
                adapter = new MainAdapter(breedList.getBreedsList());
                recycler_View.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BreedList> call, Throwable t) {
            }
        });

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(breedList == null){
//                    breedList = new BreedList();
//                }
              //breedInfoArrayList = breedList.getFilteredBreedInfo(searchEditText.getText().toString());
                adapter = new MainAdapter(breedList.getFilteredBreedInfo(searchEditText.getText().toString()));
                recyclerView.setAdapter(adapter);
            }
        });





    }
}
