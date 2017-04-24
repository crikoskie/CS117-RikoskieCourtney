
/**
 * Allows the user to use a potion.
 * 
 * @author Courtney Rikoskie
 * @version Spring 2017
 */
public interface Useable {
   /**
    * Uses a potion on specified item.
    * 
    * @param theItem The specified item.
    */
   public String use(Room room, Item theItem);
}
