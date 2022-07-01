/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package yumyumdatacreator.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author janie
 */
public class RecipeTest {
    
    private Recipe recipe;
    
    public RecipeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.recipe = new Recipe("Soup", "Lunch", "www.food.com", "Cook it", null);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void correctName() {
        assertEquals("Soup", this.recipe.getName());
    }
    
    @Test
    public void correctMealType() {
        assertEquals("Lunch", this.recipe.getMealType());
    }
    
    @Test
    public void correctURL() {
        assertEquals("www.food.com", this.recipe.getImageURL());
    }
    
    @Test
    public void correctInstructions() {
        assertEquals("Cook it", this.recipe.getInstructions());
    }
    
    @Test
    public void temporarilyIngredientsReturnsNull() {
        assertNull(this.recipe.getIngredients());
    }
    
    @Test
    public void isEqual() {
        assertTrue(this.recipe.equals(this.recipe));
    }
    
    @Test
    public void equalIsNull() {
        assertFalse(this.recipe.equals(null));
    }
    
    @Test
    public void isNotEqual() {
        Recipe diffRecipe = new Recipe("Different", "Lunch", "www.false.com", "False", null);
        assertFalse(this.recipe.equals(diffRecipe));
    }
    
    @Test
    public void differentObject() {
        String diffObject = "Different";
        assertFalse(this.recipe.equals(diffObject));
    }
}
