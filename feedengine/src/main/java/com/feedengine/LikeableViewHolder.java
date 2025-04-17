package com.feedengine;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class LikeableViewHolder extends RecyclerView.ViewHolder {
    public ImageView likeButton;

    public LikeableViewHolder(@NonNull View itemView) {
        super(itemView);
        likeButton = itemView.findViewById(R.id.like_button);
        if (likeButton == null) {
            throw new IllegalStateException("Item view must contain an ImageView with id 'like_button'");
        }
    }
}