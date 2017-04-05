import java.util.HashMap;
import java.util.Iterator;
/**
 * Class Room - a room in an adventure game.
 * 
 * This class is part of the "Campus of Kings" application. "Campus of Kings" is a
 * very simple, text based adventure game.
 * 
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via doors. The doors are labeled north, east, south, west.
 * For each direction, the room stores a reference to an instance of door.
 * 
 * @author Maria Jump
 * @version 2015.02.01
 */
public class Room {
    /** Counter for the total number of rooms created in the world. */
    private static int counter;
    /** The name of this room.  Room names should be unique. */
    private String name;
    /** The description of this room. */
    private String description;
    /** The number of points that the player will receive upon entering a room. */
    private int points;

    /** The room's exits. */
    private HashMap<String, Door> exits;

    /**
     * Static initializer.
     */
    static {
        counter = 0;
    }
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param name  The room's name.
     * @param description
     *            The room's description.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<String, Door>();
        counter++;
    }
    
    /**
     * Returns the name of this room.
     * 
     * @return The name of this room.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of this room.
     * 
     * @return The description of this room.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Returns the number of rooms that have been created in the world.
     * @return The number of rooms that have been created in the wo rld.
     */
    public static int getCounter() {
        return counter;
    }
    
    /**
     * Returns a string description including all the details of a Room.
     * For example,
     *          Outside:
     *          You are outside in the center of the King's College campus.
     *          Exits: north east south west
     *          
     * @return A string representing all the detail of a Room.
     */
    public String toString() {
        String roomDetails = "";
        
        roomDetails += (getName() + ":" + "\n");
        roomDetails += (getDescription() + "\n");
        roomDetails += ("Exits: ");

        Iterator<String> iter = exits.keySet().iterator();
        
        while(iter.hasNext()) {
            String current = iter.next();
           
            if(getExit(current) != null) {
                roomDetails += current + " ";
            }
        }
        
        roomDetails += "\n";
        
        return roomDetails;
    }
    
    /**
     * Defines an exit from this room.
     * 
     * @param direction The direction of the exit.
     * @param neighbor The door in the given direction.
     */
    public void setExit(String direction, Door neighbor) {
        exits.put(direction, neighbor);
    }
    
    /**
     * Gets a door in a specified direction if it exists.
     * 
     * @param direction The direction of the exit.
     * @return The door in the specified direction or null if it does not exist.
     */
    public Door getExit(String direction) {
        return exits.get(direction);
    }
    
    /**
     * Sets the number of points that a player will receive upon entering a room.
     * 
     * @param thePoints The number of points that a player will receive upon entering a room.
     */
    public void setPoints(int thePoints) {
        points = thePoints;
    }
    
    /**
     * Gets the number of points that a player will receive upon entering a room.
     * 
     * @return The number of points that a player will receive upon entering a room.
     */
    public int getPoints() {
        int roomPoints = points;
        setPoints(0);
        
        return roomPoints;
    }
}
