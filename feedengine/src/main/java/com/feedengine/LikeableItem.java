package com.feedengine;

public interface LikeableItem {
    boolean isLiked();
    void setLiked(boolean liked);
    String getId();
}
