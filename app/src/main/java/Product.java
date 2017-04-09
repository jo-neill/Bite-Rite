import java.util.ArrayList;

/**
 * Created by Mario Brosko on 4/8/2017.
 */

public class Product {

    private String name;
    private String description;
    private String nfAllIngredients;
    private ArrayList<String> allIngredients;

    public Product(String nm, String des, String all) {

        name = nm;
        description = des;
        nfAllIngredients = all;
        formatIngredients();
    }

    //Parse ingredient string for individual ingredients & add to list
    private void formatIngredients() {

    }

    public String getIngredient(int index) {
        return allIngredients.get(index);
    }

    public int numIngredients() {
        return allIngredients.size();
    }
}
