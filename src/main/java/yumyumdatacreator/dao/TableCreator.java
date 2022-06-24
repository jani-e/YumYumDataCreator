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
package yumyumdatacreator.dao;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Jani Eriksson <https://github.com/jani-e>
 */
public class TableCreator {

    private Connection conn;

    public TableCreator(Connection conn) {
        this.conn = conn;
    }

    public void createTables() {
        String ingredient_SQL = "CREATE TABLE IF NOT EXISTS ingredient ("
                + "ingredientid SERIAL PRIMARY KEY, "
                + "name VARCHAR(32) NOT NULL, "
                + "prefix VARCHAR(3)"
                + ");";
        
        String recipe_SQL = "";
        String type_SQL = "";
        String recipeIngredient_SQL = "";
        
        try {
            Statement st = this.conn.createStatement();
            st.execute(ingredient_SQL);
            //st.execute(recipe_SQL);
            //st.execute(type_SQL);
            //st.execute(recipeIngredient_SQL);
            st.close();
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
