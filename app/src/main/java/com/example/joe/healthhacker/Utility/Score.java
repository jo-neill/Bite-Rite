package com.example.joe.healthhacker.Utility;

import java.util.ArrayList;

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
        badIngredients = new ArrayList<>();
        computeMultiplier();
        computeScore();
        String test = getBadIngredients();
        //System.out.println(score);
    }

    private void computeMultiplier() {

            //Get the current restriction item from the lsit of restrictions
            for (int y = 0; y < restrictions.size(); y++) {

                Restriction currentRestriction = restrictions.get(y);
                if(currentRestriction.getStatus())

                //Get the current ingredient from the restriction if active
                    for (int z = 0; z < currentRestriction.getNumIngredients(); z++) {
                        System.out.println(z);
                        String restrictedIngredient = currentRestriction.getIngredient(z);

                        //Check if the ingredient from the restriction equals
                        //the current ingredient from the product
                        //If it is, badIngredient is now true
                        if (product.checkForIngredient(restrictedIngredient)) {

                            if(!badIngredients.contains(currentRestriction.getName())) {
                                badIngredients.add(currentRestriction.getName());
                            }

                            if (currentRestriction.getDesirability() == 0) {
                                multiplier *= .75;
                            } else if (currentRestriction.getDesirability() == 1) {
                                multiplier *= .50;
                            } else {
                                multiplier *= 0;
                            }
                        }
                    }

            }
        }

    private void setInitialRestrictions() {

        restrictions = new ArrayList<>();

        ArrayList<String> items1 = new ArrayList<String>();
        items1.add("High Fructose Corn Syrup");
        items1.add("Fructose Corn Syrup");
        items1.add("Corn Syrup");
        restrictions.add(new Restriction("Corn Syrup", items1, true));

        ArrayList<String> items2 = new ArrayList<String>();
        items2.add("Glutamate");
        items2.add("Hydrolyzed");
        items2.add("Yeast Extract");
        restrictions.add(new Restriction("MSG", items2, true));

        ArrayList<String> items3 = new ArrayList<String>();
        items3.add("Aspartame");
        items3.add("Sucralose");
        items3.add("Acesulfame");
        items3.add("Saccharin");
        items3.add("Xylitol");
        items3.add("Sorbital");
        items3.add("Splenda");
        restrictions.add(new Restriction("Artificial Sweeteners", items3, true));

        ArrayList<String> items4 = new ArrayList<String>();
        items4.add("Soy");
        items4.add("Miso");
        items4.add("Shoyu");
        restrictions.add(new Restriction("Soy", items4, false));

        ArrayList<String> items5 = new ArrayList<String>();
        items5.add("Cashew");
        items5.add("Pecan");
        items5.add("Walnut");
        items5.add("Almond");
        items5.add("Hazelnut");
        items5.add("Pistachio");
        restrictions.add(new Restriction("Tree Nuts", items5, false));

    }

    public ArrayList<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<Restriction> set) {
        restrictions = set;
    }

    private void computeScore() {
        score *= multiplier;
    }

    public String getScore() {
        return Double.toString(score);
    }

    public String getBadIngredients() {
        String toReturn = "";
        for(int i = 0; i < badIngredients.size(); i++) {
            if(i > badIngredients.size()-1)
                toReturn = "Nothing bad here!";
            else if(i == badIngredients.size()-1)
                toReturn = toReturn + badIngredients.get(i);
            else
                toReturn = toReturn + badIngredients.get(i) + ", ";
        }
        System.out.println(toReturn);
        return toReturn;
    }
}