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

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jani Eriksson <https://github.com/jani-e>
 */
public class Recipe {
    private String name;
    private String mealType;
    private String imageURL;
    private String instructions;
    private List<Ingredient> ingredients;

    public Recipe(String name, String mealType, String imageURL, String instructions, List<Ingredient> ingredients) {
        this.name = name;
        this.mealType = mealType;
        this.imageURL = imageURL;
        this.instructions = instructions;
        this.ingredients = ingredients;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getMealType() {
        return this.mealType;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getInstructions() {
        return this.instructions;
    }
    
    public List getIngredients() {
        return this.ingredients;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipe other = (Recipe) obj;
        return Objects.equals(this.name, other.name);
    }
    
    
}
