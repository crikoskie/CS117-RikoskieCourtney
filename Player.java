
/**
 * Represents the player character in the game.
 * 
 * @author Courtney Rikoskie 
 * @version 2017.01.24
 */
public class Player {
    /** The room that the player character is currently in. */
    private Room currentRoom;
    /** The room that the player character was previously in. */
    private Room previousRoom;
    
    /**
     * Constructs a new Player.
     * 
     * @param startingRoom The room that the player character starts in.
     */
    public Player(Room startingRoom) {
        currentRoom = startingRoom;
        previousRoom = null;
    }
    
    /**
     * Gets the room that the player character is currently in. 
     * 
     * @return The room that the player character is currently in.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * Gets the room that the player character was previously in.
     * 
     * @return The room that the player character was previously in.
     */
    public Room getPreviousRoom() {
        return previousRoom;
    }
    
    /**
     * Sets the room that the player character is currently in.  The previous room becomes
     * the one that the player was in before the current room.
     * 
     * @param theCurrentRoom The room that the player character has moved into.
     */
    public void setCurrentRoom(Room theCurrentRoom) {
        previousRoom = currentRoom;
        currentRoom = theCurrentRoom;
    }
}
