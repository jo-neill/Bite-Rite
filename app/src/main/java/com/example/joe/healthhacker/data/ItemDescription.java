package com.example.joe.healthhacker.data;
import org.json.JSONObject;
/**
 * Created by Joe on 4/8/17.
 */

public class ItemDescription implements JSONPopulator{
    String itemDescription;

    public void populate(JSONObject data){
        itemDescription = data.optString("item_description");
    }
}
