package com.my_instagram;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.feedengine.LikeableViewHolder;

public class PostViewHolder extends LikeableViewHolder {
    ImageView postImage;
    TextView postTitle;
    TextView postDescription;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        postImage = itemView.findViewById(R.id.post_image);
        postTitle = itemView.findViewById(R.id.post_title);
        postDescription = itemView.findViewById(R.id.post_description);
        likeButton = itemView.findViewById(R.id.like_button);
    }
}