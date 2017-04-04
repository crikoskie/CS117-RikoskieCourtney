import java.util.HashMap;

/**
 * This class represents the entire world that makes up the "Campus of Kings"
 * application. "Campus of Kings" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * 
 * This world class creates the world where the game takes place.
 * 
 * @author Maria Jump
 * @version 2015.02.01
 */
public class World {
    /** The rooms in the world. */
    private HashMap<String, Room> rooms;

    /**
     * Constructor for the world.
     */
    public World() {
        rooms = new HashMap<String, Room>();
        createRooms();
    }

    /**
     * This method takes care of creating all of the aspects of the world for
     * the "Campus of Kings" application.
     * 
     * @param name
     *            The provided name of the room.
     * @return The room associated with the provided name
     */
    public Room getRoom(String name) {
        return rooms.get(name.toLowerCase());
    }

    /////////////////////////////////////////////////////////////////////////////////////
    // Start of private helper methods

    /**
     * Helper method for recreating a Room. Ensure that the room is created and
     * installed in to the collection of Rooms
     * 
     * @param theRoom
     *            The room to add to the world.
     */
    private void addRoom(Room theRoom) {
        rooms.put(theRoom.getName().toLowerCase(), theRoom);
    }

    /**
     * Helper method for creating doors between rooms.
     * 
     * @param from The room where the door originates.
     * @param direction The direction of the door in the from room.
     * @param to The room where the door goes.
     */
    private void createDoor(Room from, String direction, Room to) {
        Door door = new Door(to);
        from.setExit(direction, door);
    }
    
    /**
     * This method creates all of the individual places in this world and all
     * the doors connecting them.
     */
    private void createRooms() {
        // Creating all the rooms.
        Room frontPorch = new Room("Front Porch", "The wood creaks under your feet.  A welcome sign is nailed onto the front door.  Down the stairs is a path."); 
        Room livingRoom = new Room("Living Room", "Curtains hang over the window, making it a bit difficult to see.  The fireplace is unlit, but the warm weather outside makes it feel temperate.  Out the door to the south is the front porch.  To the north is the downstairs hall.");
        Room dHall = new Room("Downstairs Hall", "A painting of a sunset is on the wall to your left.  To the south is the living room.  Light shines from the kitchen to the east.  There are stairs to the second floor.");
        Room kitchen = new Room("Kitchen", "The counter is cluttered with pots and pans, and a head of garlic sits amidst them.  Light streams in through uncovered windows.  The downstairs hall is to the west.  Out the door to the north is the back porch.");
        Room backPorch = new Room("Back Porch", "The wood creaks under your feet.  Down the stairs is the backyard.  Through the door is the back porch.");
        Room backyard = new Room("Backyard", "The wood creaks under your feet.  Down the stairs is the backyard.  Through the door is the back porch.");
        
        // Adding all the rooms to the world.
        this.addRoom(frontPorch);
        this.addRoom(livingRoom);
        this.addRoom(dHall);
        this.addRoom(kitchen);
        this.addRoom(backPorch);
        this.addRoom(backyard);

        // Creating all the doors between the rooms.
        this.createDoor(frontPorch, "north", livingRoom);
        this.createDoor(livingRoom, "south", frontPorch);
        
        this.createDoor(livingRoom, "north", dHall);
        this.createDoor(dHall, "south", livingRoom);
        
        this.createDoor(dHall, "east", kitchen);
        this.createDoor(kitchen, "west", dHall);
        
        this.createDoor(kitchen, "north", backPorch);
        this.createDoor(backPorch, "south", kitchen);
        
        this.createDoor(backPorch, "up", backyard);
        this.createDoor(backyard, "down", backPorch);
    }
}
