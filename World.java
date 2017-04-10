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
        createItems();
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
        Room frontPorch = new Room("Front Porch", "The porch is small, only about half the length of the actual house, and the worn wood creaks beneath your feet.  There are no furnishings besides an inelegant wooden chair sitting to the left and a sign which hangs on the door.  Behind the chair, a window peers into the living room, but green curtains block the view.  The forest begins down the stairs."); 
        Room livingRoom = new Room("Living Room", "Curtains hang over the window, making it a bit difficult to see.  The fireplace is unlit, but the warm weather outside makes it feel temperate.  Out the door to the south is the front porch.  To the north is the downstairs hall.");
        Room dHall = new Room("Downstairs Hall", "A painting of a sunset is on the wall to your left.  To the south is the living room.  Light shines from the kitchen to the east.  There are stairs to the second floor.");
        Room kitchen = new Room("Kitchen", "The counter is cluttered with pots and pans, and a head of garlic sits amidst them.  Light streams in through uncovered windows.  The downstairs hall is to the west.  Out the door to the north is the back porch.");
        Room backPorch = new Room("Back Porch", "The wood creaks under your feet.  Down the stairs is the backyard.  Through the door is the back porch.");
        Room backyard = new Room("Backyard", "Rows of plants are spread along the yard, convenient walking paths among them.  A shed stands at the back.  A locked hatch is by the stairs.");
        Room cellar = new Room("Cellar", "Fizzling cauldrons sit on tables which line the walls.  Above your head, a shining plant bulbs provide you the ability to see.  A single empty cauldron is by the far wall.  A book on warding and barriers sits beside it.  There are stairs up to the first floor.");
        Room landing = new Room("Second Floor Landing", "A small cabinet sits on the landing.  There are stairs to the downstairs hall.  To the south is the upstairs hall.  Your bedroom is to the east.");
        Room yourRoom = new Room("Your Bedroom", "Your bed is still unmade.  On your desk is your potion notes, containing information on the ones you know how to make perfectly.  Your herb pouch hangs off your chair.  A jar peaks out from underneath your bed.  The second floor landing is to the west.");
        Room uHall = new Room("Upstairs Hall", "A railing lines one side of the hall.  The closed door of the bathroom is on the other.  To the north is the second floor landing.  You can see your master’s bedroom to the south.");
        Room masterRoom = new Room("Master's Bedroom", "The bedroom is pristine, unlike your own.  A jewelry box looks out of place, sitting askew on the armoire.  The upstairs hall is to the north.");
        Room northPath = new Room("North Path", "You stand on a trodden down path.  There are stairs up to the front porch, and through the trees to the south is a clearing.");
        Room clearing = new Room("Clearing", "You enter a grassy clearing in the trees.  There are paths to the north, south, east, and west.");
        Room westPath = new Room("West Path", "You stand on a trodden down path.  Through the trees to the east is a clearing.  The path opens up to a field of rare herbs to the west.  To the southwest is a small patch of flowers.");
        Room herbs = new Room("Fairy Herbs", "There are enough rare herbs to fill your pouch a thousand times over.  To the east is a path.  To the south is a small patch of flowers. ");
        Room flower = new Room("Flower Patch", "Flowers add a bit of color among the green and brown of the forest.  As far as you know, they are of no use in potion-making, but they are pretty.  To the northeast is a path.  To the west is the guardian of the forest");
        Room guardian = new Room("Forest Guardian", "There is a man lounging on a chair made out wood.  To the west is a patch of flowers.");
        Room eastPath = new Room("East Path", "You stand on a trodden down path.  Through the trees to the west is a clearing.  To the east is an odd lizard.");
        Room lizard = new Room("Lizard", "A lizard is basking on a stump.  Its body is wrapped around a shining bulb.  To the west is a path.");
        Room southPath = new Room("South Path", "You think that you stand on a trodden down path.  It is too dark to see.  Through the trees to the north is a clearing.  ");
        Room alley = new Room("Alley", "The narrow alley makes you feel a bit anxious.  To the north is a path.  If you go south, the alley opens up into a stone road.");
        Room frontOfAlley = new Room("In Front of Alley", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the south, east, and west.  The alley leading to the forest is to the north.");
        Room northeastRoad = new Room("Northeast Road", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the east and west.");
        Room northeastCorner = new Room("Northeast Corner", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the south and west.");
        Room northeastMarket = new Room("Northeast Market", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the south and north.");
        Room frontOfBridge = new Room("In Front of Bridge", "The noise of the Merchant District has quieted down, and less people surround you.  A guard is standing watch.  The district continues to the south and north.  To the west, Fairsway Potions looms.  The bridge to the Citizen District is to the east.");
        Room southeastMarket = new Room("Southeast Market", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the south and north.");
        Room southeastCorner = new Room("Southeast Corner", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the east and north.");
        Room southeastRoad = new Room("Southeast Road", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the west and east.");
        Room frontOfOffice = new Room("In Front of Government Office", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the west, north, and east.  Amongst the citizen-owned businesses to the south is the government office.");
        Room southwestRoad = new Room("Southwest Road", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the north and south.");
        Room southwestCorner = new Room("Southwest Corner", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the north and east.");
        Room southwestMarket = new Room("Southwest Market", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the west and east.");
        Room gate = new Room("In Front Of Town Gate", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the east, north, and south. ");
        Room northwestMarket = new Room("Northwest Market", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the north and south.");
        Room northwestCorner = new Room("Northwest Corner", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the west and south.");
        Room northwestRoad = new Room("Northwest Road", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The district continues to the west and east.");
        Room northMarket = new Room("North Market", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The town square opens up to the south, and the street continues to the north.");
        Room townSquare = new Room("Town Square", "You are in an especially lively part of town.  A large fountain spouts water in the center of the square.  A merchant caravan is taking a rest by it, and you see Syl amongst them.  A large building looms in the east, the famous Fairsway Potions.  The district continues to the west, north, and south.");
        Room potions = new Room("Fairsway Potions", "As you enter, you are roughly shoved aside by a crowd heading out the door.  To the east is the town square, and to the west, you can see the town gate.");
        Room southMarket = new Room("South Market", "You are in the midst of Fairsway’s Merchant District.  People from all around the country bustle along and an assortment of businesses display their wares.  The town square opens up to the north, and the street continues to the south.  Fairsway Weapons and Maril’s Apparel are to the west and east, respectively.");
        Room weapons = new Room("Fairsway Weapons", "Glass display cases show off the variety of weapons for sale.  A lone broadsword hangs on the wall to your right.  The owner stands behind the counter and greets you when you walk in.  The exit is to the east.");
        Room apparel = new Room("Maril's Apparel", "Brightly colored walls assault your eyes.  Tables are placed sporadically throughout the store, and on them, various styles of shirts and pants are folded in neat squares.  Elegant dresses are displayed on the walls.  Maril, the owner, is arguing with a customer.  The exit is to the west.");
        Room office = new Room("Government Office", "Compared to the shops, this place is void of people.  Two men whisper to each other harshly in a corner.  There is no line in order before the main desk.  A lady sits behind it, resting her head on her cheek and looking bored.  The exit is to the north.");
        Room bridge = new Room("Bridge", "You stand over a calm river.  The Merchant District is to the east, and the Citizen District is to the west.");
        Room welcome = new Room("Welcome to the Citizen District", "A sign hangs across two short, adjacent poles.  The main road is to the east.  The bridge heading to the Merchant District is to the east.");
        Room mainRoad = new Room("Main Road", "Plain houses dot the street, eerily similar in their appearances. Few personal additions by the owners set them apart.  The library is to the east, Tave’s house is to the north, and the exit to the District is to the west.");
        Room taveHouse = new Room("Tave's House", "There is a banner set up along the path toward the porch.  The main road is to the south.");
        Room library = new Room("Library", "You are overwhelmed by the size and number of bookshelves.  Your cat sits upon one of the tables, licking it paw.  The main road is to the west.");
        
        cellar.setPoints(5);
        northPath.setPoints(5);
        alley.setPoints(5);
        welcome.setPoints(5);
         
        // Adding all the rooms to the world.
        this.addRoom(frontPorch);
        this.addRoom(livingRoom);
        this.addRoom(dHall);
        this.addRoom(kitchen);
        this.addRoom(backPorch);
        this.addRoom(backyard);
        this.addRoom(cellar);
        this.addRoom(landing);
        this.addRoom(yourRoom);
        this.addRoom(uHall);
        this.addRoom(masterRoom);
        this.addRoom(northPath);
        this.addRoom(clearing);
        this.addRoom(westPath);
        this.addRoom(herbs);
        this.addRoom(flower);
        this.addRoom(guardian);
        this.addRoom(eastPath);
        this.addRoom(lizard);
        this.addRoom(southPath);
        this.addRoom(alley);
        this.addRoom(frontOfAlley);
        this.addRoom(northeastRoad);
        this.addRoom(northeastCorner);
        this.addRoom(northeastMarket);
        this.addRoom(frontOfBridge);
        this.addRoom(southeastMarket);
        this.addRoom(southeastCorner);
        this.addRoom(southeastRoad);
        this.addRoom(frontOfOffice);
        this.addRoom(southwestRoad);
        this.addRoom(southwestCorner);
        this.addRoom(southwestMarket);
        this.addRoom(gate);
        this.addRoom(northwestMarket);
        this.addRoom(northwestCorner);
        this.addRoom(northwestRoad);
        this.addRoom(northMarket);
        this.addRoom(townSquare);
        this.addRoom(potions);
        this.addRoom(southMarket);
        this.addRoom(weapons);
        this.addRoom(apparel);
        this.addRoom(office);
        this.addRoom(bridge);
        this.addRoom(welcome);
        this.addRoom(mainRoad);
        this.addRoom(taveHouse);
        this.addRoom(library);

        // Creating all the doors between the rooms.
        this.createDoor(frontPorch, "north", livingRoom);
        this.createDoor(livingRoom, "south", frontPorch);
        
        this.createDoor(livingRoom, "north", dHall);
        this.createDoor(dHall, "south", livingRoom);
        
        this.createDoor(dHall, "east", kitchen);
        this.createDoor(kitchen, "west", dHall);
        
        this.createDoor(kitchen, "north", backPorch);
        this.createDoor(backPorch, "south", kitchen);
        
        this.createDoor(backPorch, "down", backyard);
        this.createDoor(backyard, "up", backPorch);
        
        this.createDoor(backyard, "down", cellar);
        this.createDoor(cellar, "up", backyard);
        
        this.createDoor(dHall, "up", landing);
        this.createDoor(landing, "down", dHall);
        
        this.createDoor(landing, "east", yourRoom);
        this.createDoor(yourRoom, "west", landing);
        
        this.createDoor(landing, "south", uHall);
        this.createDoor(uHall, "north", landing);
        
        this.createDoor(uHall, "south", masterRoom);
        this.createDoor(masterRoom, "north", uHall);
        
        this.createDoor(frontPorch, "down", northPath);
        this.createDoor(northPath, "up", frontPorch);
        
        this.createDoor(northPath, "south", clearing);
        this.createDoor(clearing, "north", northPath);
        
        this.createDoor(clearing, "west", westPath);
        this.createDoor(westPath, "east", clearing);
        
        this.createDoor(westPath, "west", herbs);
        this.createDoor(herbs, "east", westPath);
        
        this.createDoor(herbs, "south", flower);
        this.createDoor(flower, "north", herbs);
        
        this.createDoor(westPath, "southwest", flower);
        this.createDoor(flower, "northeast", westPath);
        
        this.createDoor(flower, "west", guardian);
        this.createDoor(guardian, "east", flower);
        
        this.createDoor(clearing, "east", eastPath);
        this.createDoor(eastPath, "west", clearing);
        
        this.createDoor(eastPath, "east", lizard);
        this.createDoor(lizard, "west", eastPath);
        
        this.createDoor(clearing, "south", southPath);
        this.createDoor(southPath, "north", clearing);
        
        this.createDoor(southPath, "south", alley);
        this.createDoor(alley, "north", southPath);
        
        this.createDoor(alley, "south", frontOfAlley);
        this.createDoor(frontOfAlley, "north", alley);
        
        this.createDoor(frontOfAlley, "east", northeastRoad);
        this.createDoor(northeastRoad, "west", frontOfAlley);
        
        this.createDoor(northeastRoad, "east", northeastCorner);
        this.createDoor(northeastCorner, "west", northeastRoad);
        
        this.createDoor(northeastCorner, "south", northeastMarket);
        this.createDoor(northeastMarket, "north", northeastCorner);
        
        this.createDoor(northeastMarket, "south", frontOfBridge);
        this.createDoor(frontOfBridge, "north", northeastMarket);
        
        this.createDoor(frontOfBridge, "south", southeastMarket);
        this.createDoor(southeastMarket, "north", frontOfBridge);
        
        this.createDoor(southeastMarket, "south", southeastCorner);
        this.createDoor(southeastCorner, "north", southeastMarket);
        
        this.createDoor(southeastCorner, "west", southeastRoad);
        this.createDoor(southeastRoad, "east", southeastCorner);
        
        this.createDoor(southeastRoad, "west", frontOfOffice);
        this.createDoor(frontOfOffice, "east", southeastRoad);
        
        this.createDoor(frontOfOffice, "west", southwestRoad);
        this.createDoor(southwestRoad, "east", frontOfOffice);
        
        this.createDoor(southwestRoad, "west", southwestCorner);
        this.createDoor(southwestCorner, "east", southwestRoad);
        
        this.createDoor(southwestCorner, "north", southwestMarket);
        this.createDoor(southwestMarket, "south", southwestCorner);
        
        this.createDoor(southwestMarket, "north", gate);
        this.createDoor(gate, "south", southwestMarket);
        
        this.createDoor(gate, "north", northwestMarket);
        this.createDoor(northwestMarket, "south", gate);
        
        this.createDoor(northwestMarket, "north", northwestCorner);
        this.createDoor(northwestCorner, "south", northwestMarket);
        
        this.createDoor(northwestCorner, "east", northwestRoad);
        this.createDoor(northwestRoad, "west", northwestCorner);
        
        this.createDoor(northwestRoad, "east", frontOfAlley);
        this.createDoor(frontOfAlley, "west", northwestRoad);
        
        this.createDoor(frontOfAlley, "south", northMarket);
        this.createDoor(northMarket, "north", frontOfAlley);
        
        this.createDoor(northMarket, "south", townSquare);
        this.createDoor(townSquare, "north", northMarket);
        
        this.createDoor(townSquare, "east", potions);
        this.createDoor(potions, "west", townSquare);
        
        this.createDoor(potions, "east", frontOfBridge);
        this.createDoor(frontOfBridge, "west", potions);
        
        this.createDoor(townSquare, "west", gate);
        this.createDoor(gate, "east", townSquare);
        
        this.createDoor(townSquare, "south", southMarket);
        this.createDoor(southMarket, "north", townSquare);
        
        this.createDoor(southMarket, "west", weapons);
        this.createDoor(weapons, "east", southMarket);
        
        this.createDoor(southMarket, "east", apparel);
        this.createDoor(apparel, "west", southMarket);
        
        this.createDoor(southMarket, "south", frontOfOffice);
        this.createDoor(frontOfOffice, "north", southMarket);
        
        this.createDoor(office, "north", frontOfOffice);
        this.createDoor(frontOfOffice, "south", office);
        
        this.createDoor(frontOfBridge, "east", bridge);
        this.createDoor(bridge, "west", frontOfBridge);
        
        this.createDoor(bridge, "east", welcome);
        this.createDoor(welcome, "west", bridge);
        
        this.createDoor(welcome, "east", mainRoad);
        this.createDoor(mainRoad, "west", welcome);
        
        this.createDoor(mainRoad, "north", taveHouse);
        this.createDoor(taveHouse, "south", mainRoad);
        
        this.createDoor(mainRoad, "east", library);
        this.createDoor(library, "west", mainRoad);
    }
    
    /**
     * Creates items in the rooms in which they belong.
     */
    public void createItems() {
        Item garlic = new Item("head of garlic", "Your nose scrunches from the smell. It seems to be made up of at least ten cloves.", 5, 1.5);
        Room kitchen = getRoom("Kitchen");
        kitchen.addItem(garlic);
        
        Item pouch = new Item("herb pouch", "The inside made up of small protective pockets, it is perfect for toting around fragile herbs.", 5, 2);
        Item notepad = new Item("notepad", "Recipes for potions are scribbled inside. The handwriting is so messy that it is unreadable to anyone but you.", 5, 4);
        Item coins = new Item("coin collection", "Since your first trip to town, the shopkeepers of Fairsway have been giving you coins from far-off lands.  The jar contains all of the ones you have received. It is one of your cherished possessions.", 0, 20);
        Room yourRoom = getRoom("Your Bedroom");
        yourRoom.addItem(pouch);
        yourRoom.addItem(notepad);
        yourRoom.addItem(coins);
    }
    
}
