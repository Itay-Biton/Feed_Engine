package com.my_instagram;

import android.content.Intent;
import android.os.Bundle;

import com.feedengine.BaseFeedActivity;
import com.feedengine.BaseFeedAdapter;

import java.util.ArrayList;
import java.util.List;

public class InstagramFeedActivity extends BaseFeedActivity<Post> {
    private static final List<Post> posts = new ArrayList<>();

    public static void addPost(Post post) {
        posts.add(0, post);
    }
    @Override
    protected List<Post> getFeedItems() {
        return posts;
    }

    @Override
    protected BaseFeedAdapter createAdapter(List<Post> items) {
        return new PostAdapter(items);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.fab_create_post).setOnClickListener(v -> {
            startActivity(new Intent(this, CreateNewPostActivity.class));
        });
    }

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_instagram_feed);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}