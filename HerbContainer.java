
/**
 * Represents an herb container.
 * 
 * @author Courtney Rikoskie
 * @version Spring 2017
 */
public class HerbContainer extends Container {
    /** The max number of herbs able to be carried. */
    public static final int MAX_HERBS;
    /** Keeps track of the number of herbs in container. */
    private int herbCounter;
    
    /**
     * Static initializer.
     */
    static {
        MAX_HERBS = 15;
    }
    
    /**
     * Constructs a new HerbContainer.
     * 
     * @param theName The name of the herb container.
     * @param theDescription The description of the herb container.
     * @param thePointValue The point value of the herb container.
     * @param theWeight The weight(in ounces) of the herb container.
     */
    public HerbContainer(String theName, String theDescription, int thePointValue, double theWeight) {
        super(theName, theDescription, thePointValue, theWeight);
    }
    
    /**
     * Adds the specified item to the herb container.
     * 
     * @param theItem The item to be added.
     * @return Whether adding the item was successful.
     */
    public String addHerb(Item theItem) {
        String result = "You cannot safely put in any more herbs.";
        
        if (herbCounter < MAX_HERBS) {
            super.addItem(theItem);
            result = "Packed.";
            herbCounter += 1;
        }
        
        return result;
    }
}
