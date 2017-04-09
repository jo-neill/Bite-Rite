package com.example.joe.healthhacker.data;
import org.json.JSONObject;

/**
 * Created by Joe on 4/8/17.
 */

public class ItemName implements JSONPopulator{

    String itemName;

    public void populate(JSONObject data){
        itemName = data.optString("item_name");
    }

}
