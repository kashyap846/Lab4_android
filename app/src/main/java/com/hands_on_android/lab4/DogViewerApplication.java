package com.hands_on_android.lab4;

import android.app.Application;
import android.content.Context;

public class DogViewerApplication extends Application {

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

    public static Context getContext() {
        return applicationContext;
    }
}
