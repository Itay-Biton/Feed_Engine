package com.feedengine;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseFeedAdapter<T extends LikeableItem> extends RecyclerView.Adapter<LikeableViewHolder> {
    protected final List<T> items;

    protected int filledHeart = R.drawable.ic_heart_filled;
    protected int outlinedHeart = R.drawable.ic_heart_outline;

    public BaseFeedAdapter(List<T> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public LikeableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return (LikeableViewHolder) onCreateCustomViewHolder(parent, viewType);
    }

    public abstract RecyclerView.ViewHolder onCreateCustomViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull LikeableViewHolder holder, int position) {
        T item = items.get(position);
        ImageView likeButton = holder.likeButton;

        likeButton.setImageResource(item.isLiked()
                ? filledHeart
                : outlinedHeart
        );

        likeButton.setOnClickListener(v -> {
            item.setLiked(!item.isLiked());
            notifyItemChanged(position);
            animateLike(likeButton);
        });

        onBindCustomViewHolder(holder, item, position);
    }

    public abstract void onBindCustomViewHolder(@NonNull LikeableViewHolder holder, T item, int position);

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected void animateLike(ImageView likeButton) {
        likeButton.animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(100)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .withEndAction(() -> likeButton.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                        .start())
                .start();
    }

    public int getFilledHeart() {
        return filledHeart;
    }

    public void setFilledHeart(int _filledHeart) {
        filledHeart = _filledHeart;
    }

    public int getOutlinedHeart() {
        return outlinedHeart;
    }

    public void setOutlinedHeart(int _outlinedHeart) {
        outlinedHeart = _outlinedHeart;
    }
}