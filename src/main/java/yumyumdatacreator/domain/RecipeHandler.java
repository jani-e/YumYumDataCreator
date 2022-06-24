/*
 * The MIT License
 *
 * Copyright 2022 Jani Eriksson <https://github.com/jani-e>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package yumyumdatacreator.domain;

import java.util.ArrayList;
import java.util.List;
import yumyumdatacreator.dao.DatabaseHandler;

/**
 *
 * @author Jani Eriksson <https://github.com/jani-e>
 */
public class RecipeHandler {
    private DatabaseHandler dh;
    private List<Recipe> recipes;
    
    public RecipeHandler() { //temporary dummy data
        this.dh = new DatabaseHandler();
        this.dh.createTables();
        
        Ingredient dummyIngredient = new Ingredient("Milk", 5.2, "dl");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(dummyIngredient);
        recipes = new ArrayList<>();
        recipes.add(new Recipe("Name", "lunch", "url", "instructions", ingredients));
        recipes.add(new Recipe("Another", "lunch", "url", "instructions", ingredients));
    }
    
    public List<Recipe> getRecipes() {
        return this.recipes;
    }
    
    public List<String> getRecipesByName() {
        List<String> recipeNames = new ArrayList<>();
        for (Recipe recipe : this.recipes) {
            recipeNames.add(recipe.getName());
        }
        return recipeNames;
    }
    
    public void addRecipe(Recipe addable) {
        if (this.recipes.contains(addable)) {
            System.out.println("recipe already exists"); //temporary message
            return;
        }
        this.recipes.add(addable);
    }
    
    public Recipe searchRecipe(String searchable) {
        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(searchable)) {
                return recipe;
            }
        }
        return null;
    }

    public void addRecipe(String name, String mealType, String imageURL, String instructions) { //temp
        Ingredient dummyIngredient = new Ingredient("Milk", 5.2, "dl");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(dummyIngredient);
        this.recipes.add(new Recipe(name, mealType, imageURL, instructions, ingredients));
    }
}
