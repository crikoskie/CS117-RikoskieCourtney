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

    /** This room's north exit, null if none exits. */
    private Door northExit;
    /** This room's south exit, null if none exits. */
    private Door southExit;
    /** This room's east exit, null if none exits. */
    private Door eastExit;
    /** This room's west exit, null if none exits. */
    private Door westExit;

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
     * Gets the room's north exit.
     * 
     * @return The room's north exit.
     */
    public Door getNorthExit() {
        return northExit;
    }
    
    /**
     * Gets the room's south exit.
     * 
     * @return The room's south exit.
     */
    public Door getSouthExit() {
        return southExit;
    }
    
    /**
     * Gets the room's east exit.
     * 
     * @return The room's east exit.
     */
    public Door getEastExit() {
        return eastExit;
    }
    
    /**
     * Gets the room's west exit.
     * 
     * @return The room's west exit.
     */
    public Door getWestExit() {
        return westExit;
    }
    
    /**
     * Sets the room's north exit.
     * 
     * @param theNorthExit The room's new north exit.
     */
    public void setNorthExit(Door theNorthExit) {
        northExit = theNorthExit;
    }
    
    /**
     * Sets the room's south exit.
     * 
     * @param theSouthExit The room's new south exit.
     */
    public void setSouthExit(Door theSouthExit) {
        southExit = theSouthExit;
    }
    
    /**
     * Sets the room's east exit.
     * 
     * @param theEastExit The room's new east exit.
     */
    public void setEastExit(Door theEastExit) {
        eastExit = theEastExit;
    }
    
    /**
     * Sets the room's west exit.
     * 
     * @param theWestExit The room's new west exit.
     */
    public void setWestExit(Door theWestExit) {
        westExit = theWestExit;
    }
}
