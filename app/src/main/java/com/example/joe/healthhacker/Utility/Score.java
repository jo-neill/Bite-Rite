package com.example.joe.healthhacker.Utility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mario Brosko on 4/8/2017.
 */

public class Score {

    private double score;
    private double multiplier;
    private Product product;
    private ArrayList<Restriction> restrictions;
    private ArrayList<String> badIngredients;


    public Score() {

        //Instantiate the other private fields
        score = 10;
        multiplier = 1.0;
        badIngredients = new ArrayList();
        setInitialRestrictions();
    }

    public void refreshScore(Product prod) {
        product = prod;
        score = 10;
        multiplier = 1.0;
        badIngredients.clear();
        computeMultiplier();
    }

    private void computeMultiplier() {

            //Get the current restriction item from the lsit of restrictions
            for (int y = 0; y < restrictions.size(); y++) {

                Restriction currentRestriction = restrictions.get(y);
                if(currentRestriction.getStatus())

                //Get the current ingredient from the restriction if active
                    for (int z = 0; z < currentRestriction.getNumIngredients(); z++) {

                        String restrictedIngredient = currentRestriction.getIngredient(z);

                        //Check if the ingredient from the restriction equals
                        //the current ingredient from the product
                        //If it is, badIngredient is now true
                        if (product.checkForIngredient(restrictedIngredient)) {

                            if(!badIngredients.contains(currentRestriction.getName()))
                                badIngredients.add(currentRestriction.getName());
                            System.out.println(badIngredients);

                            if (currentRestriction.getDesirability() == 0) {
                                multiplier *= .66;
                            } else if (currentRestriction.getDesirability() == 1) {
                                multiplier *= .33;
                            } else {
                                multiplier *= 0;
                            }
                        }
                    }

            }
        }

    private void setInitialRestrictions() {

        String[] items1 = {"High Fructose Corn Syrup", "Fructose Corn Syrup"};
        ArrayList<String> listItems1 = new ArrayList<String>(Arrays.asList(items1));
        restrictions.add(new Restriction("Corn Syrup", listItems1, true));

    }

}