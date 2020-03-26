package com.example.instalistview;

public class FeedItemData {
    private int imageId;
    private int like;
    private String content;

    public FeedItemData(int imageId, int like, String content) {
        this.imageId = imageId;
        this.like = like;
        this.content = content;
    }

    public int getImageId() {
        return imageId;
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
