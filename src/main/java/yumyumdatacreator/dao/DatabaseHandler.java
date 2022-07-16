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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import yumyumdatacreator.domain.Recipe;

/**
 *
 * @author Jani Eriksson <https://github.com/jani-e>
 */
public class DatabaseHandler {

    private CredentialsLoader cl;
    private ConnectionManager cm;

    public DatabaseHandler() {
        this.cl = new CredentialsLoader();
        this.cm = new ConnectionManager(cl.getIp(), cl.getUser(), cl.getPassword());
    }

    public void createTables() {
        if (cm.getDatabaseConnection() == null) {
            System.out.println("Connection is null");
        } else {
            TableCreator tc = new TableCreator(cm.getDatabaseConnection());
            tc.createTables();
        }
    }

    public boolean saveRecipe(Recipe recipe) {
        String insert_SQL = "INSERT INTO recipe (name, type, imageurl, instructions) VALUES (?, ?, ?, ?);"; //missing ingredients
        try {
            Connection conn = this.cm.getDatabaseConnection();
            PreparedStatement st = conn.prepareStatement(insert_SQL);
            st.setString(1, recipe.getName());
            st.setInt(2, 1); //temp, type is mandatory (1 = lunch)
            st.setString(3, recipe.getImageURL());
            st.setString(4, recipe.getInstructions());
            st.executeUpdate();
            st.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Recipe> loadRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        String query_SQL = "SELECT * FROM recipe;";
        try {
            Connection conn = this.cm.getDatabaseConnection();
            PreparedStatement st = conn.prepareStatement(query_SQL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                //int type = rs.getInt("type"); //temp
                String type = "lunch";
                String imageurl = rs.getString("imageurl");
                String instructions = rs.getString("instructions");
                List ingredients = null; //temp
                recipes.add(new Recipe(name, type, imageurl, instructions, ingredients));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }
}
