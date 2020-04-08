package com.hands_on_android.lab4.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class BreedImageList implements Serializable {

    @SerializedName("message")
    ArrayList<String> imageUrls;

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }
}
