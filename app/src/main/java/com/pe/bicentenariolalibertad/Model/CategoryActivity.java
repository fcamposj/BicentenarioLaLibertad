package com.pe.bicentenariolalibertad.Model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryActivity {

    String name, story;
    int image;

    public CategoryActivity(String name, String story, int image) {
        this.name = name;
        this.story = story;
        this.image = image;
    }

    public CategoryActivity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
