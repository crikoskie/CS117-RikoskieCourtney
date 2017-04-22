
/**
 * Represents a container that can hold potions.
 * 
 * @author Courtney Rikoskie
 * @version Spring 2017
 */
public class PotionContainer extends Container implements Emptiable {
    /** The contents of potion container. **/
    private Potion potion;
    
    /**
     * Constructs a new potion container.
     * 
     * @param theName The name of the container.
     * @param theDescription The description of the container.
     * @param thePointValue The point value of the container.
     * @param theWeight The weight (in ounces) of the container.
     */
    public PotionContainer(String theName, String theDescription, int thePointValue, double theWeight) {
        super(theName, theDescription, thePointValue, theWeight);
        potion = null;
    }    
    
    /**
     * Empties a specific container.
     * 
     * @param container A container which can hold potions.
     */
    public String empty(Container container) {
        String result = "Emptied.";
        String potionName = potion.getName();
        
        container.removeItem(potionName);
        
        return result;
    }
    
    /**
     * Returns whether or not the potion container is empty.
     * 
     * @return Whether or not the potion container is empty.
     */
    public boolean isEmpty() {
        boolean empty = false;
       
        if (potion == null) {
            empty = true;
        }
        
        return empty;
    }
    
    /**
     * Pours a specified potion into a specified potion container.
     * 
     * @param potion The specfied potion.
     * @param container The specified potion container.
     */
    public String pour(Potion potion, PotionContainer giver, PotionContainer receiver) {
        String result = "Poured.";
        String potionName = potion.getName();
        
        receiver.addItem(potion);
        giver.removeItem(potionName);
        
        return result;
    }
    
    /**
     * Adds an item to the potion container.
     * 
     * @param theItem The name of the item to be added.
     */
    public void addItem(Item theItem) {
        if (theItem instanceof Potion) {
            Potion thePotion = (Potion)theItem;
            
            potion = thePotion;
        }
    }
}
