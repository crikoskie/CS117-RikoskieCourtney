
/**
 * Represents an item within the game.
 * 
 * @author Courtney Rikoskie
 * @version Spring 2017
 */
public class Item
{
    /** The name of the item. */
    private String name;
    /** The description of the item. */
    private String description;
    /** The point value of the item. */
    private int pointValue;
    /** The weight (in ounces) of the item. */
    private double weight;

    /**
     * Constructs a new Item.
     * 
     * @param theName The name of the item.
     * @param theDescription The description of the item.
     * @param thePointValue The point value of the item.
     * @param theWeight The weight (in ounces) of the item.
     */
    public Item(String theName, String theDescription, int thePointValue, double theWeight) {
        name = theName;
        description = theDescription;
        pointValue = thePointValue;
        weight = theWeight;
    }

    /**
     * Gets the name of the item.
     * 
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the description of the item.
     * 
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Gets the point value of the item.
     * 
     * @return The point value of the item.
     */
    public int getPointValue() {
        return pointValue;
    }
    
    /**
     * Gets the weight (in ounces) of the item.
     * 
     * @return The weight (in ounces) of the item.
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * Sets the description of the item.
     * 
     * @param theDescription The new description of the item.
     */
    public void setDescription(String theDescription) {
        description = theDescription;
    }
    
    /**
     * Sets the weight (in ounces) of the item.
     * 
     * @param theWeight The new weight (in ounces) of the item.
     */
    public void setWeight(double theWeight) {
        weight = theWeight;
    }
    
    /**
     * Gets a complete description of the item.
     * 
     * @return A complete description of the item.
     */
    public String toString() {
        String result = name + ": " + description;
        
        return result;
    }
}
