package com.feedengine;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class BaseFeedActivity<T extends LikeableItem> extends AppCompatActivity {
    protected RecyclerView recyclerView;
    protected BaseFeedAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<T> items = getFeedItems();
        adapter = createAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    protected abstract void initLayout();
    protected abstract List<T> getFeedItems();
    protected abstract BaseFeedAdapter createAdapter(List<T> items);
}