package com.hands_on_android.lab4.api.model;

import com.hands_on_android.lab4.DogViewerApplication;
import com.hands_on_android.lab4.R;

public class BreedInfo {
    private final String breedName;
    private final int subBreedCount;

    public BreedInfo(String breedName, int subBreedCount) {
        this.breedName = breedName;
        this.subBreedCount = subBreedCount;
    }

    public String getBreedName() {
        return breedName;
    }

    public String getSubBreedCountText() {
        if (subBreedCount <= 0) {
            return null;
        }

        return DogViewerApplication.getContext().getString(R.string.sub_breeds)
                .replace("{count}", String.valueOf(subBreedCount))
                .replace("{s}", subBreedCount > 1 ? "s" : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BreedInfo breedInfo = (BreedInfo) o;

        return breedName.equals(breedInfo.breedName);
    }

    @Override
    public int hashCode() {
        return breedName.hashCode();
    }
}
