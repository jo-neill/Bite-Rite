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

    //com.example.joe.healthhacker.Utility.Restriction constructor
    Restriction(String nm, boolean actv, int des, ArrayList<String> ing, boolean act) {
        name = nm;
        desirability = des;
        ingredients = ing;
        active = act;
    }

    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
    }

    public void setDesirability(int des) {
        desirability = des;
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
