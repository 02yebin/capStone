package com.cookandroid.capstonedesign;

import android.widget.ImageView;

import java.util.List;

public class RecipeVO {

    private ImageView Img;
    private List<String> ingredient;
    private String recipeName;
    private String recipe;

    public ImageView getImg() {
        return Img;
    }

    public void setImg(ImageView img) {
        Img = img;
    }

    public List<String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<String> ingredient) {
        this.ingredient = ingredient;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

}
