package com.hands_on_android.lab4.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BreedList implements Serializable {
    @SerializedName("message")
    HashMap<String, ArrayList<String>> breedsMap;

//    public ArrayList<HashMap<String, String>> getBreedsList() {
//        ArrayList<String> sortedBreeds = new ArrayList<>(breedsMap.keySet());
//        Collections.sort(sortedBreeds);
//
//        ArrayList<HashMap<String, String>> result = new ArrayList<>();
//
//        for (String breed : sortedBreeds) {
//            HashMap<String, String> item = new HashMap<>();
//            item.put("name", breed);
//            item.put("count", String.valueOf(breedsMap.get(breed).size()));
//            result.add(item);
//        }
//
//        return result;
//    }


    public ArrayList<BreedInfo> getBreedsList() {
        ArrayList<String> sortedBreedsList = new ArrayList<>(breedsMap.keySet());
        Collections.sort(sortedBreedsList);

        ArrayList<BreedInfo> finalResult = new ArrayList<>();

        for (String breedNames : sortedBreedsList)
            finalResult.add(new BreedInfo(breedNames, breedsMap.get(breedNames).size()));


        return finalResult;
    }

    public ArrayList<BreedInfo> getFilteredBreedInfo(String searchKey) {
        ArrayList<String> sortedBreeds = new ArrayList<>(breedsMap.keySet());
        Collections.sort(sortedBreeds);

        ArrayList<BreedInfo> result = new ArrayList<>();

        for (String breed : sortedBreeds) {
            if (searchKey != null && !searchKey.isEmpty() && !breed.contains(searchKey)) {
                continue;
            }
            result.add(new BreedInfo(breed, breedsMap.get(breed).size()));
        }

        return result;
    }
}
