package com.my_recipe_book;

import com.feedengine.LikeableItem;

public class Recipe implements LikeableItem {
    private final String id;
    private boolean liked;
    private final String title;
    private final String ingredients;
    private final String instructions;
    private final int imageRes;

    public Recipe(String id, String title, String ingredients, String instructions, int imageRes) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imageRes = imageRes;
        this.liked = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isLiked() {
        return liked;
    }

    @Override
    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getImageRes() {
        return imageRes;
    }
}