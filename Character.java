import java.util.HashSet;
import java.util.Iterator;
/**
 * Represents a non-player character.
 * 
 * @author Courtney Rikoskie.
 * @version Spring 2017
 */
public class Character {
    /** The name of the non-player character. */
    private String name;
    /** The responses that the non-player character is able to give. */
    private Conversation responses;
    /** The inventory of the non-player character. */
    private Item inventory;
    /** The items that the non-player character will trade for. */
    private HashSet<Item> tradeItems;
    
    /**
     * Constructs a new Character.
     * 
     * @param theName The name of the non-player character.
     * @param theResponses The responses that the non-player character is able to give.
     */
    public Character(String theName, Conversation theResponses) {
        name = theName;
        responses = theResponses;
        inventory = null;
        tradeItems = new HashSet<Item>();
    }
    
    /**
     * Gets the item from the non-player character's inventory.
     */
    public Item getItem() {
        return inventory;
    }
    
    /**
     * Sets the non-player character's inventory.
     * 
     * @param theItem The new inventory item.
     */
    public void setInventory(Item theItem) {
        inventory = theItem;
    }
    
    /**
     * Gets whether or not the specified item is one that the non-player character will trade for.
     * 
     * @param theItem The specified item.
     * @return Whether or not the specified item is one that the non-player character will trade for.
     */
    public boolean isTradeItem(Item theItem) {
        boolean found = false;
        Iterator<Item> iter = tradeItems.iterator();
        
        while (iter.hasNext() && !found) {
            Item current = iter.next();
            
            if (theItem.equals(current)) {
                found = true;
            }
        }
        
        return found;
    }
    
    /**
     * Adds an item that the non-player character will trade for.
     * 
     * @param theItem The new item that the non-player character will trade for.
     */
    public void addTradeItem(Item theItem) {
        tradeItems.add(theItem);
    }
}
