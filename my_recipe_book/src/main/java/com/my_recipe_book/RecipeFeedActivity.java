package com.my_recipe_book;

import android.os.Bundle;
import android.widget.Button;

import com.feedengine.BaseFeedActivity;
import com.feedengine.BaseFeedAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeFeedActivity extends BaseFeedActivity<Recipe> {
    private enum FilterState { ALL, LIKED, UNLIKED }

    private FilterState currentFilter = FilterState.ALL;
    private List<Recipe> allRecipes;
    private RecipeAdapter recipeAdapter;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_recipe_feed);
    }

    @Override
    protected List<Recipe> getFeedItems() {
        allRecipes = new ArrayList<Recipe>();
        allRecipes.add(new Recipe("1", "Pasta Bolognese", "Pasta, Tomato Sauce, Beef", "Cook pasta and mix with sauce.", R.drawable.ic_launcher_background));
        allRecipes.add(new Recipe("2", "Avocado Toast", "Bread, Avocado, Salt", "Toast bread, mash avocado, add salt.", R.drawable.ic_launcher_foreground));
        allRecipes.add(new Recipe("3", "Veggie Omelette", "Eggs, Bell Peppers, Onions", "Beat eggs, cook with veggies.", R.drawable.ic_launcher_background));
        allRecipes.add(new Recipe("4", "Fruit Smoothie", "Banana, Berries, Yogurt", "Blend all ingredients until smooth.", R.drawable.ic_launcher_foreground));
        allRecipes.add(new Recipe("5", "Grilled Cheese", "Bread, Cheese, Butter", "Butter bread, add cheese, grill until golden.", R.drawable.ic_launcher_background));
        allRecipes.add(new Recipe("6", "Peanut Butter Banana", "Bread, Peanut Butter, Banana", "Spread peanut butter and top with sliced banana.", R.drawable.ic_launcher_foreground));
        allRecipes.add(new Recipe("7", "Tomato Soup", "Tomatoes, Garlic, Cream", "Simmer tomatoes with garlic, blend, and add cream.", R.drawable.ic_launcher_background));

        return allRecipes;
    }

    @Override
    protected BaseFeedAdapter createAdapter(List<Recipe> items) {
        recipeAdapter = new RecipeAdapter(items);
        return recipeAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button filterButton = findViewById(R.id.btn_filter);
        filterButton.setOnClickListener(v -> {
            switch (currentFilter) {
                case ALL: currentFilter = FilterState.LIKED; break;
                case LIKED: currentFilter = FilterState.UNLIKED; break;
                case UNLIKED: currentFilter = FilterState.ALL; break;
            }

            String label;
            switch (currentFilter) {
                case ALL:
                    label = "Show: All";
                    break;
                case LIKED:
                    label = "Show: Liked";
                    break;
                case UNLIKED:
                    label = "Show: Unliked";
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            filterButton.setText(label);

            applyFilter();
        });
    }

    private void applyFilter() {
        List<Recipe> filtered;
        switch (currentFilter) {
            case ALL:
                filtered = allRecipes;
                break;
            case LIKED:
                filtered = allRecipes.stream()
                        .filter(Recipe::isLiked)
                        .collect(Collectors.toList());
                break;
            case UNLIKED:
                filtered = allRecipes.stream()
                        .filter(r -> !r.isLiked())
                        .collect(Collectors.toList());
                break;
            default:
                throw new IllegalArgumentException();
        }

        recipeAdapter.updateItems(filtered);
    }
}