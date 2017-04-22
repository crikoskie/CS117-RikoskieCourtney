
/**
 * Write a description of interface Makeable here.
 * 
 * @author Courtney Rikoskie
 * @version Spring 2017
 */
public interface Makeable {
    /**
     * Adds an ingredient needed to make the potion.
     * 
     * @param ingredient An ingredient needed to make the potion.
     */
    public abstract void addIngredient(Item ingredient);
    
    /**
     * Makes a potion, if all needed ingredients are available.
     * 
     * @param player The player character.
     * @param room The current room.
     * @param container A container that ingredients may be found in.
     * @param cauldron The container which holds newly made potions.
     */
    public abstract String makePotion(Player player, Room room, Container container, Container cauldron);    
}
