package com.hands_on_android.lab4.api;

import com.hands_on_android.lab4.api.model.BreedImageList;
import com.hands_on_android.lab4.api.model.BreedList;
import com.hands_on_android.lab4.api.model.RandomImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("breeds/list/all")
    Call<BreedList> getBreedsList();

    @GET("breed/{breed}/images/random")
    Call<RandomImage> getRandomImage(@Path("breed") String breed);

    @GET("breed/{breed}/images")
    Call<BreedImageList> getBreedImageList(@Path("breed") String breed);
}
