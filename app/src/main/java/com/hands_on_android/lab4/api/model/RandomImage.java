package com.hands_on_android.lab4.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RandomImage implements Serializable {
    @SerializedName("message")
    String url;

    public String getUrl() {
        return url;
    }
}
