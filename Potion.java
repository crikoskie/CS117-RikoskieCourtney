import java.util.HashSet;
import java.util.Iterator;
/**
 * Represents a potion.
 * 
 * @author Courtney Rikoskie
 * @version Spring 2017
 */
public class Potion extends Item implements Makeable, Useable {
    /** The ingredients needed to make the potion. */
    private HashSet<Ingredient> ingredients;
    /** The container that the potion is in. */
    private PotionContainer potionContainer;
    /** Whether or not the potion has been made. */
    private boolean made;
    
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
        ingredients = new HashSet<Ingredient>();
        potionContainer = null;
        made = false;
    }
    
    /**
     * Adds an ingredient needed to make the potion.
     * 
     * @param ingredient An ingredient needed to make the potion.
     */
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    
    /**
     * Sets the potion's container.
     * 
     * @param container The potion's container.
     */
    public void setContainer(PotionContainer container) {
        potionContainer = container;
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
    public String makePotion(Player player, Room room, World world, Container container, PotionContainer cauldron) {
        boolean found = false;
        boolean allFound = true;
        String result = null;
        
        Iterator<Ingredient> firstIter = ingredients.iterator();
        
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
            
            Iterator<Ingredient> secondIter = ingredients.iterator();
        
            while (secondIter.hasNext()) {
                Ingredient current = secondIter.next();
                Item ingredient = null;
                String itemName = current.getName();
                
                result += "      " + itemName;
                
                if (player.isInInventory(itemName)) {
                    ingredient = player.getItem(itemName);
                }
                else if (room.isInRoom(itemName)) {
                    ingredient = room.getItem(itemName);
                }
                else if (container.isInContainer(itemName)) {
                    ingredient = container.getItem(itemName);
                }
                
                Ingredient anIngredient = (Ingredient)ingredient;
                anIngredient.setNumberInGroup(anIngredient.getNumberInGroup() - 1);
                
                int numberInGroup = anIngredient.getNumberInGroup();
                String ingredientName = ingredient.getName();
                
                if (numberInGroup == 0) {
                    if (player.isInInventory(ingredientName)) {
                        player.removeItem(ingredientName);
                    }
                    else if (room.isInRoom(ingredientName)) {
                        room.removeItem(ingredientName);
                    }
                    else if (container.isInContainer(ingredientName)) {
                        container.removeItem(ingredientName);
                    }
                }
            }
            
            cauldron.addPotion(this);
            made = true;
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
        
        Iterator<Ingredient> iter = ingredients.iterator();
        
        while (iter.hasNext()) {
            Item current = iter.next();
            String itemName = current.getName();
            
            result += "      " + itemName + "\n";
        }
        
        return result;
    }
    
    /**
    * Uses a potion on specified item.
    * 
    * @param theItem The specified item.
    * @return Whether the potion was successfully used on the item.
    */
    public String use(Player player, Room room, Item theItem) {
        String result = "You used the" + getName() + ".";
        
        switch (getName()) {
            case "shrinking potion":
                double weight = theItem.getWeight();
                theItem.setWeight(weight/4);
                break;
            case "duplication potion":
                String itemName = theItem.getName();
                
                if (!(itemName.equals("shed") || itemName.equals("cat"))) {
                    Item item = new Item(theItem.getName(), theItem.getDescription(), 0, theItem.getWeight());
                    result += "\n\nA new " + itemName + " appeared in front of you.";
                    room.add(item);
                }
                else {
                    result = "You probably shouldn't use a duplication potion on that.  It's asking for trouble.";
                }
                break;
            case "scent remover":
                
                break;
        }
        
        return result;
    }
    
   
}
