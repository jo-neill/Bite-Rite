package com.example.joe.healthhacker.Utility;

/**
 * Created by Mario Brosko on 4/8/2017.
 */

public class Product {

    private String name;
    private String description;
    private String nfAllIngredients;

    public Product(String nm, String des, String all) {

        name = nm;
        description = des;
        nfAllIngredients = all;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        if(nfAllIngredients != null && !nfAllIngredients.isEmpty()) {
            return nfAllIngredients;
        }
        return "Sorry! No ingredients listed.";
    }

    public boolean checkForIngredient(String checkingFor) {
        if(nfAllIngredients.contains(checkingFor) ||
                nfAllIngredients.toLowerCase().contains(checkingFor.toLowerCase())) {
            return true;
        }
        return false;
    }
}
