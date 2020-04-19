package com.example.instagramnavigation;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class FeedItemData {
    private Bitmap image;
    private int like;
    private String content;

    public FeedItemData(Bitmap image, int like, String content) {
        this.image = image;
        this.like = like;
        this.content = content;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getContent() {
        return content;
    }
}
