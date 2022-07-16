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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import yumyumdatacreator.dao.DatabaseHandler;

/**
 *
 * @author Jani Eriksson <https://github.com/jani-e>
 */
public class RecipeHandlerTest {
    
    private RecipeHandler recipeHandler;
    private DatabaseHandler databaseHandler;
    private List<Recipe> dummyRecipes;
    
    public RecipeHandlerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.databaseHandler = mock(DatabaseHandler.class);
        this.recipeHandler = new RecipeHandler(databaseHandler);
        this.dummyRecipes = new ArrayList<>();
        this.dummyRecipes.add(new Recipe("Soup", "Lunch", "www.food.com", "Cook it", null));
        this.dummyRecipes.add(new Recipe("Crepes", "Dessert", "www.crepes.com", "Fry them", null));
        when(this.databaseHandler.loadRecipes()).thenReturn(this.dummyRecipes);
        this.recipeHandler.loadRecipes();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void recipesAreReturned() {
        assertEquals(this.dummyRecipes, this.recipeHandler.getRecipes());
    }
    
    @Test
    public void recipeNamesAreReturned() {
        List<String> testRecipeNames = new ArrayList<>();
        testRecipeNames.add("Soup");
        testRecipeNames.add("Crepes");
        List<String> recipeNames = this.recipeHandler.getRecipesByName();
        assertEquals(testRecipeNames, recipeNames);
    }
    
    @Test
    public void recipeCanBeAdded() {
        assertTrue(this.recipeHandler.addable(new Recipe("NewRecipe", "Dinner", "www.dinner.com", "Cena", null)));
    }
    
    @Test
    public void existingRecipeCantBeAdded() {
        assertFalse(this.recipeHandler.addable(new Recipe("Soup", "Lunch", "www.food.com", "Cook it", null)));
    }
    
    @Test
    public void recipeIsSaved() {
        Recipe newRecipe = new Recipe("Taco", "Lunch", "www.tacos.com", "Not a burrito", null);
        when(this.databaseHandler.saveRecipe(newRecipe)).thenReturn(true);
        assertTrue(this.recipeHandler.saveRecipe(newRecipe));
    }
    
    @Test
    public void recipeIsNotSaved() {
        Recipe duplicate = new Recipe("Soup", "Lunch", "www.food.com", "Cook it", null);
        when(this.databaseHandler.saveRecipe(duplicate)).thenReturn(false);
        assertFalse(this.recipeHandler.saveRecipe(duplicate));
    }
    
    @Test
    public void searchFindsRecipe() {
        assertEquals("Soup", this.recipeHandler.searchRecipe("Soup").getName());
    }
    
    @Test
    public void failedSearchReturnsNull() {
        assertNull(this.recipeHandler.searchRecipe("Not in the recipes"));
    }
}
