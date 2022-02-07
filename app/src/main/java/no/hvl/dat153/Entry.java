package no.hvl.dat153;

import androidx.annotation.NonNull;

public class Entry {
    public String name;
    public int imageId; // Resource ID, for images in drawable. Example, R.drawable.duckimage

    public Entry(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public String toString() {
        return "name: " + name + " imageId: " + String.valueOf(imageId);
    }

    public int getImageId() {
        return imageId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Entry)
            return (((Entry)obj).getImageId() == imageId);
        else
            return false;
    }
}
