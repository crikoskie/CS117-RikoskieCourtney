
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
    public String empty(Container container);
    
    /**
     * Returns whether or not the potion container is empty.
     * 
     * @return Whether or not the potion container is empty.
     */
    public boolean isEmpty();
    
    /**
     * Pours a specified potion into a specified potion container.
     * 
     * @param potion The specfied potion.
     * @param container The specified potion container.
     */
    public String pour(Potion potion, PotionContainer giver, PotionContainer receiver);
}
