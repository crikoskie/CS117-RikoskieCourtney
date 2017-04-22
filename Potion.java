import java.util.HashSet;
import java.util.Iterator;
/**
 * Represents a potion.
 * 
 * @author Courtney Rikoskie
 * @version Spring 2017
 */
public class Potion extends Item implements Makeable {
    /** The ingredients needed to make the potion. */
    private HashSet<Item> ingredients;
    /** The container that the potion is in. */
    private PotionContainer potionContainer;
    
    /**
     * Constructs a new Potion.
     * 
     * @param theName The name of the potion.
     * @param theDescription The description of the potion.
     * @param thePointValue The point value of the potion.
     * @param theWeight The weight(in ounces) of the potion.
     */
    public Potion(String theName, String theDescription, int thePointValue, double theWeight) {
        super(theName, theDescription, thePointValue, theWeight);
        ingredients = new HashSet<Item>();
        potionContainer = null;
    }
    
    /**
     * Adds an ingredient needed to make the potion.
     * 
     * @param ingredient An ingredient needed to make the potion.
     */
    public void addIngredient(Item ingredient) {
        ingredients.add(ingredient);
    }
    
    /**
     * Gets the container that the potion is in.
     * 
     * @return The container that the potion is in.
     */ 
    public PotionContainer getContainer() {
        return potionContainer;
    }
   
    /**
     * Makes a potion, if all needed ingredients are available.
     * 
     * @param player The player character.
     * @param room The current room.
     * @param container A container that ingredients may be found in.
     * @param cauldron The container which holds newly made potions.
     */
    public String makePotion(Player player, Room room, Container container, Container cauldron) {
        boolean found = false;
        boolean allFound = true;
        String result = null;
        
        Iterator<Item> firstIter = ingredients.iterator();
        
        while (firstIter.hasNext() && allFound == true) {
            String itemName = firstIter.next().getName();
            
            if ((player.isInInventory(itemName) || room.isInRoom(itemName) || container.isInContainer(itemName))) {
                found = true;
            }
            if (found == false) {
                allFound = false;
            }
        }
        
        if (allFound == true) {
            result = "You made a " + super.getName() + "\n\n";
            result += "To do so, you used:\n";
            
            Iterator<Item> secondIter = ingredients.iterator();
        
            while (secondIter.hasNext()) {
                Item current = secondIter.next();
                String itemName = current.getName();
                
                result += "      " + itemName;
                
                if (player.isInInventory(itemName)) {
                    player.removeItem(itemName);
                }
                else if (room.isInRoom(itemName)) {
                    room.removeItem(itemName);
                }
                else if (container.isInContainer(itemName)) {
                    container.removeItem(itemName);
                }
            }
            
            cauldron.addItem(this);
        }
        else {
            result = "You don't have the necessary ingredients.";
        }
        
        return result;
    }
    
    /**
     * Gets a description of the ingredients needed to make the potion.
     * 
     * @return A description of the ingredients needed to make the potion.
     */
    public String toString() {
        String result = "Ingredients needed to make a " + getName() + ":\n";
        
        Iterator<Item> iter = ingredients.iterator();
        
        while (iter.hasNext()) {
            Item current = iter.next();
            String itemName = current.getName();
            
            result += "      " + itemName + "\n";
        }
        
        return result;
    }
}
