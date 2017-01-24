
/**
 * Represents the player character in the game.
 * 
 * @author Courtney Rikoskie 
 * @version 2017.01.24
 */
public class Player
{
    /** The room that the player character is currently in. */
    private Room currentRoom;
    
    /**
     * Constructs a new Player.
     * 
     * @param startingRoom The room that the player character starts in.
     */
    public Player(Room startingRoom) {
        currentRoom = startingRoom;
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
     * Sets the room that the player character is currently in.
     * 
     * @param theCurrentRoom The room that the player character has moved into.
     */
    public void setCurrentRoom(Room theCurrentRoom) {
        currentRoom = theCurrentRoom;
    }
}
