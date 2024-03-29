package com.example.joe.healthhacker.Utility;

import java.util.ArrayList;

/**
 * Created by Mario Brosko on 4/8/2017.
 */

public class Restriction {

    private String name;
    private int desirability;
    private ArrayList<String> ingredients;
    private boolean active;
    private static int id;
    private static int idCounter = 0;

    //com.example.joe.healthhacker.Utility.Restriction constructor
    Restriction(String nm, ArrayList<String> ingr, boolean act) {

        id = idCounter;
        idCounter++;
        name = nm;
        desirability = 0;
        ingredients = ingr;
        active = act;
    }

    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
    }

    public void setDesirability(String des) {
        switch(des) {
            case "Dislike": desirability = 0;
                break;
            case "Avoid": desirability = 1;
                break;
            default: desirability = 2;
        }
    }

    public int getDesirability() {
        return desirability;
    }

    public String getIngredient(int index){
       return ingredients.get(index);
    }

    public int getNumIngredients(){
        return ingredients.size();
    }

    public void changeStatus(boolean flip) {
        active = flip;
    }

    public boolean getStatus() {
        return active;
    }
}
