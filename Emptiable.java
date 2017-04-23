
/**
 * Write a description of interface Emptiable here.
 * 
 * @author Courtney Rikoskie
 * @version Spring 2017
 */
public interface Emptiable {
    /**
     * Empties a specific container.
     * 
     * @param container A container which can hold potions.
     */
    public String empty();
    
    /**
     * Returns whether or not the potion container is empty.
     * 
     * @return Whether or not the potion container is empty.
     */
    public boolean isEmpty();
    
    /**
     * Adds an item to the potion container.
     * 
     * @param theItem The name of the item to be added.
     * @return A String containing whether or not adding the item was successful.
     */
    public String addPotion(Item theItem);
}
