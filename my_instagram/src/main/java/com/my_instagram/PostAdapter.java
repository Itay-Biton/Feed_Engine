package com.my_instagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.feedengine.BaseFeedAdapter;
import com.feedengine.LikeableViewHolder;

import java.util.List;

public class PostAdapter extends BaseFeedAdapter<Post> {
    public PostAdapter(List<Post> items) {
        super(items);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateCustomViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feed, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindCustomViewHolder(@NonNull LikeableViewHolder holder, Post post, int position) {
        PostViewHolder postHolder = (PostViewHolder) holder;
        postHolder.postTitle.setText(post.getTitle());
        postHolder.postDescription.setText((post.getDescription()));
        postHolder.postImage.setImageResource(post.getImageRes());
    }
}