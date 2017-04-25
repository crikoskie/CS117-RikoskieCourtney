import java.util.HashSet;
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
    private HashSet<Item> inventory;
    
    /**
     * Constructs a new Character.
     * 
     * @param theName The name of the non-player character.
     * @param theResponses The responses that the non-player character is able to give.
     */
    public Character(String theName, Conversation theResponses) {
        name = theName;
        responses = theResponses;
        inventory = new HashSet<Item>();
    }
    
    /**
     * Adds an item to the inventory.
     * 
     * @param theItem The item to add.
     */
    public void addToInventory(Item theItem) {
        inventory.add(theItem);
    }
}
