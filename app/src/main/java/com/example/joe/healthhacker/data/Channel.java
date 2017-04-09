package com.example.joe.healthhacker.data;

import org.json.JSONObject;
import android.util.Log;
/**
 * Created by Joe on 4/8/17.
 */

public class Channel implements JSONPopulator {
    private ItemDescription itemDescription;
    private ItemName itemName;
    private IngredientsList ingredients;

    public ItemName getItemName() {
        return itemName;
    }

    public ItemDescription getItemDesc() {
        return itemDescription;
    }

    public IngredientsList getIngredients(){
        return ingredients;
    }

    @Override
    public void populate(JSONObject data) {

        itemName = new ItemName();
        itemName.populate(data.optJSONObject("item_name"));

        itemDescription = new ItemDescription();
        itemDescription.populate(data.optJSONObject("item_description"));

        ingredients = new IngredientsList();
        ingredients.populate(data.optJSONObject("nf_ingredient_statement"));

    }
}