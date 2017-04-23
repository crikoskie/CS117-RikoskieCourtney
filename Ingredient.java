
/**
 * Represents an ingredient for a potion.
 * 
 * @author Courtney Rikoskie 
 * @version Spring 2017
 */
public class Ingredient extends Item {
    /**
     * Constructs a new Ingredient.
     * 
     * @param theName The name of the ingredient.
     * @param theDescription The description of the ingredient.
     * @param thePointValue The point value of the ingredient.
     * @param theWeight The weight (in ounces) of the ingredient.
     */
    public Ingredient(String theName, String theDescription, int thePointValue, double theWeight) {
        super(theName, theDescription, thePointValue, theWeight);
    }
}
