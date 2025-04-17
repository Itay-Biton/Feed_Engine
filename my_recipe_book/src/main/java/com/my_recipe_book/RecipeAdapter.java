package com.my_recipe_book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.feedengine.BaseFeedAdapter;
import com.feedengine.LikeableItem;
import com.feedengine.LikeableViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends BaseFeedAdapter {
    private List<Recipe> originalItems;

    public RecipeAdapter(List<Recipe> items) {
        super(new ArrayList<>(items)); // mutable copy
        this.originalItems = new ArrayList<>(items);
    }

    public void updateItems(List<Recipe> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    public void resetItems() {
        updateItems(originalItems);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateCustomViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindCustomViewHolder(@NonNull LikeableViewHolder holder, LikeableItem item, int position) {
        RecipeViewHolder recipeHolder = (RecipeViewHolder) holder;
        Recipe recipe = (Recipe) item;

        recipeHolder.recipeImage.setImageResource(recipe.getImageRes());
        recipeHolder.recipeTitle.setText(recipe.getTitle());
        recipeHolder.recipeIngredients.setText("Ingredients: " + recipe.getIngredients());
        recipeHolder.recipeInstructions.setText("Instructions: " + recipe.getInstructions());
    }

    public class RecipeViewHolder extends LikeableViewHolder {
        public ImageView recipeImage;
        public TextView recipeTitle;
        public TextView recipeIngredients;
        public TextView recipeInstructions;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.recipe_image);
            recipeTitle = itemView.findViewById(R.id.recipe_title);
            recipeIngredients = itemView.findViewById(R.id.recipe_ingredients);
            recipeInstructions = itemView.findViewById(R.id.recipe_instructions);
        }
    }
}