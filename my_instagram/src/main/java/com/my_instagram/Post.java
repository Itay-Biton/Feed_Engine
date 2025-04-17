package com.my_instagram;

import com.feedengine.LikeableItem;

public class Post implements LikeableItem {
    private final String id;
    private boolean liked;
    private final String title;
    private final String description;
    private final int imageRes;

    public Post(String id, String title, String description, int imageRes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageRes = imageRes;
        this.liked = false;
    }

    @Override
    public boolean isLiked() {
        return liked;
    }

    @Override
    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageRes() {
        return imageRes;
    }
}