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
/**
 *
 * @author Jani Eriksson <https://github.com/jani-e>
 */
package yumyumdatacreator.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import yumyumdatacreator.domain.Recipe;
import yumyumdatacreator.domain.RecipeHandler;

public class GUIController {

    private RecipeHandler recipeHandler;

    @FXML
    private ListView recipeList;
    
    private ObservableList<String> recipeNames;

    @FXML
    private TextField recipeName;

    @FXML
    private TextField recipeType;

    @FXML
    private TextField recipeURL;

    @FXML
    private TextArea recipeInstructions;

    @FXML
    private Button saveRecipeButton;

    public GUIController() {
    }

    @FXML
    private void initialize() {
        recipeHandler = new RecipeHandler();
        populateRecipeList();
    }

    public void populateRecipeList() {
        recipeList.getItems().clear();
        recipeNames = FXCollections.observableArrayList(recipeHandler.getRecipesByName());
        recipeList.setItems(recipeNames);
    }

    public void loadRecipeDetails(MouseEvent event) {
        if (recipeList.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        String searchable = recipeList.getSelectionModel().getSelectedItem().toString();
        Recipe foundRecipe = recipeHandler.searchRecipe(searchable);

        recipeName.setText(foundRecipe.getName());
        recipeType.setText(foundRecipe.getMealType());
        recipeURL.setText(foundRecipe.getImageURL());
        recipeInstructions.setText(foundRecipe.getInstructions());

    }

    public void saveRecipeDetails() {
        String name = recipeName.getText();
        String mealType = recipeType.getText();
        String imageURL = recipeURL.getText();
        String instructions = recipeInstructions.getText();

        //Recipe createdRecipe = new Recipe(name, mealType, imageURL, instructions);
        //this.recipeHandler.addRecipe(createdRecipe);
        
        this.recipeHandler.addRecipe(name, mealType, imageURL, instructions); //temp until ingredients supported

        populateRecipeList();
    }

}
