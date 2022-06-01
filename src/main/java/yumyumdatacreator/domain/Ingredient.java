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

/**
 *
 * @author Jani Eriksson <https://github.com/jani-e>
 */
class Ingredient {
    private String name;
    private double quantity;
    private String prefix; //kg dl

    public Ingredient(String name, double quantity, String prefix) {
        this.name = name;
        this.quantity = quantity;
        this.prefix = prefix;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "name=" + name + ", quantity=" + quantity + ", prefix=" + prefix + '}';
    }
    
    
}
