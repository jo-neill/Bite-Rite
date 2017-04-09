package com.example.joe.healthhacker.data;
import org.json.JSONObject;
/**
 * Created by Joe on 4/8/17.
 */

public class IngredientsList {
    String ingredients;

    public void populate(JSONObject data){
        ingredients = data.optString("nf_ingredient_statement");
    }
}
