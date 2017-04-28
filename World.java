import java.util.HashMap;
import java.util.HashSet;
/**
 * This class represents the entire world that makes up the "Cat"
 * application. "Cat" is a text-based adventure game.
 * 
 * This world class creates the world where the game takes place.
 * 
 * @author Maria Jump
 * @version 2015.02.01
 */
public class World {
    /** The rooms in the world. */
    private HashMap<String, Room> rooms;
    /** The buildable items. */
    private HashMap<String, Potion> potions;
    /** The non-player character's items. */
    private HashSet<Item> npcItems;
    /** The items that the player character can trade. */
    private HashSet<Item> tradeItems;
    /** The non-player characters in the world. */
    private HashMap<String, Character> characters;
    
    /**
     * Constructor for the world.
     */
    public World() {
        rooms = new HashMap<String, Room>();
        potions = new HashMap<String, Potion>();
        npcItems = new HashSet<Item>();
        tradeItems = new HashSet<Item>();
        characters = new HashMap<String, Character>();
        createRooms();
        createItems();
        createCharacters();
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
        Room potionsShop = new Room("Fairsway Potions", "As you enter, you are roughly shoved aside by a crowd heading out the door.  To the east is the town square, and to the west, you can see the town gate.");
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
        this.addRoom(potionsShop);
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
        
        this.createDoor(townSquare, "east", potionsShop);
        this.createDoor(potionsShop, "west", townSquare);
        
        this.createDoor(potionsShop, "east", frontOfBridge);
        this.createDoor(frontOfBridge, "west", potionsShop);
        
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
        
        // element is 1
        southPath.addDescription("With the illuminated bulb, it is much easier to see.");
        backyard.addDescription("Some of the herbs are starting to look bare.");
        taveHouse.addDescription("");
    }
    
    /**
     * Creates items in the rooms in which they belong.
     */
    public void createItems() {
        Item garlic = new Item("head of garlic", "Your nose scrunches from the smell. It seems to be made up of at least ten cloves.", 5, 1.5);
        Room kitchen = getRoom("Kitchen");
        kitchen.addItem(garlic);
        
        Ingredient clove = new Ingredient("garlic clove", "It's a clove of garlic.", 0, 0.125, 12);
        
        HerbContainer pouch = new HerbContainer("herb pouch", "The inside being made up of small protective pockets, it is perfect for toting around fragile herbs.", 5, 2);
        Book notes = new Book("notes", "Recipes for potions are scribbled upon a pile of small loose papers. The handwriting is so messy that it is unreadable to anyone but you.", 5, 4, "There are notes about:\n");
        Item coins = new Item("coin collection", "One of your cherished possessions, it is a jar filled with currency from far-off lands.  The coins are well-cared-for and shine brightly.", 0, 20);
        Room yourRoom = getRoom("Your Bedroom");
        yourRoom.addItem(pouch);
        yourRoom.addItem(notes);
        yourRoom.addItem(coins);
        tradeItems.add(coins);
        
        Container jewelryBox = new Container("jewelry box", "Though it is made of wood and has a simple design, it must have been expensive.  Its emblem, a small bird embossed with delicate silver on its lid, marks its maker as one of the renowned jewelers within the country.", 0, 48);
        Item cellarKey = new Item("cellar key", "The steel key sits heavily in the palm of your hand.  It looks a bit rusted and makes your fingers smell gross.", 15, 5);
        Room masterRoom = getRoom("Master's Bedroom");
        masterRoom.addItem(jewelryBox);
        jewelryBox.addItem(cellarKey);
        
        Container shed = new Container("shed", "A wooden shed stands at the end of the backyard.  It is weathered and beaten, looking like it could collapse any second.", 0, 129);
        Item rune = new Item("barrier rune", "An ancient symbol is written upon the paper in ink.  It looks a bit like the silhouette of a frog.", 0, 0);
        Item hiddenRune = new Item("hidden barrier rune", "An ancient symbol is written upon the paper in ink.  It looks a bit like the silhouette of a frog.", 15, 0);
        Room backyard = getRoom("Backyard");
        backyard.addItem(shed);
        shed.addItem(rune);
        
        Room clearing = getRoom("Clearing");
        clearing.addItem(hiddenRune);
        
        Book wardBook = new Book("book on warding and barriers", "Recently, you've seen Master flipping through this book with a serious frown.  There is nothing on the dull red cover besides the author's last name.", 5, 36, "Table of Contents\n\n Your master has circled some of the items in the table.  They are:\n");
        PotionContainer cauldron = new PotionContainer("empty cauldron", "There is a black cauldron, recently bought, sitting on one of the leftmost tables.  Unlike the others in the room, it does not have a brewing potion inside it.", 0, 129); 
        PotionContainer vial = new PotionContainer("vial", "It's a small glass vial, able to hold even the most corrosive of potions.", 0, 3);
        Room cellar = getRoom("Cellar");
        cellar.addItem(wardBook);
        cellar.addItem(cauldron);
        cellar.addItem(vial);
        
        Door yardToCellar = backyard.getExit("down");
        yardToCellar.setLocked(true);
        yardToCellar.setKey(cellarKey);
        
        Door cellarToYard = cellar.getExit("up");
        cellarToYard.setKey(cellarKey);
        
        Item gold = new Item("gold", "The small bag is heavy for its size.  The gold inside jingles whenever you move.", 15, 13);
        npcItems.add(gold);
        tradeItems.add(gold);
        
        Item bulb = new Item("illuminated bulb", "It's the bulb of a sun blossom.  As they are native to only the southern part of the country, the lizard must have found one that had fallen off a travelling merchant cart.", 10, 2.5);
        npcItems.add(bulb);
        
        Item cloth = new Item("soft cloth", "Made from the silk of volcanic worms, this cloth is revered as one of the softest that has ever graced the country.  It's rumored that the Duke of Nightwood sold his first child just to be able to touch the shimmering blue fabric.", 10, 16);
        npcItems.add(cloth);
        tradeItems.add(cloth);
        
        Item broadsword = new Item("broadsword", "After the last time, you don't trust yourself to pick up the broadsword without some assistance.  The weight, combined with the fact that it is longer than you are tall, makes it quite unwieldy.", 0, 129);
        Room weapons = getRoom("Fairsway Weapons");
        weapons.addItem(broadsword);
        tradeItems.add(broadsword);
        
        Item card = new Item("citizenship card", "Providing your name, age, and picture, this card is proof that you are a citizen of Fairsway.  Despite costing you so much gold, it is made up of some kind of flimsy material.  Hopefully, someone has cast some spells on it to prevent its destruction.", 15, 1);
        npcItems.add(card);
        
        Item cat = new Item("your cat", "It stares back at you smugly.  You scowl and look away.", 50, 125);
        Room library = getRoom("Library");
        library.addItem(cat);
        
        Potion revealer = new Potion("revealing potion", "It is entirely clear, the only proof of its existence the reflecting light.", 10, 7);
        Potion shrinking = new Potion("shrinking potion", "Bubbles float to the surface of the pick liquid.", 10, 7);
        Potion duplication = new Potion("duplication potion", "A dark green smoke rises from the potion of the same color.", 10, 7);
        Potion remover = new Potion("scent remover", "The potion is an unappetizing-looking brown.", 10, 7);
        Potion unknown = new Potion("unknown potion", "The ominous black of it makes a part of you want to keep it far away from the Guardian.", 0, 7);  
        tradeItems.add(unknown);
        
        Ingredient eppeth = new Ingredient("eppeth", "Its delicate white leaves tickle your hands.", 0, 0.2, 10);
        Ingredient riverCress = new Ingredient("river cress", "Because they need a lot of water, you find these plants the hardest to care for.", 0, 0.2, 10);
        Ingredient blisterFlower = new Ingredient("blister flower", "In spring, these plants bloom with brilliant red and orange flowers.", 0, 0.2, 10);
        Ingredient wratagrass = new Ingredient("wratagrass", "This tall grass is the staple of many potions, useful in its stabilizing capabilities.", 0, 0.2, 10);
        Ingredient hifefron = new Ingredient("hifefron", "Hifefron cacti are not suited for this climate, so Master has put a warming spell around them to keep them alive.", 0, 0.2, 10);
        Ingredient taglisbi = new Ingredient("taglisbi", "The large blue flowers of this bush smell pleasant.  You know how to make very few potions with them as an ingredient, but Master uses them a lot.", 0, 0.2, 10);
        Ingredient inneoShoot = new Ingredient("inneo shoot", "This plant consists of hundreds of fire-red shoots growing in a cluster.  Despite only having one of these in your yard, it takes up about two yous of space.", 0, 0.2, 10);
        Ingredient ashClove = new Ingredient("ash clove", "It is the perfect time to harvest these gray buds from their tree.", 0, 0.2, 10);
        Ingredient orreamin = new Ingredient("orreamin", "Infused with fairy magic, the buds of the low-growing plant glow under the shade of the trees.", 0, 0.2, 1);
        backyard.addItem(eppeth);
        backyard.addItem(riverCress);
        backyard.addItem(blisterFlower);
        backyard.addItem(wratagrass);
        backyard.addItem(hifefron);
        backyard.addItem(taglisbi);
        backyard.addItem(inneoShoot);
        backyard.addItem(ashClove);
        npcItems.add(orreamin);
        
        revealer.addIngredient(inneoShoot);
        revealer.addIngredient(hifefron);
        
        shrinking.addIngredient(riverCress);
        shrinking.addIngredient(hifefron);
        shrinking.addIngredient(wratagrass);
        
        duplication.addIngredient(inneoShoot);
        duplication.addIngredient(ashClove);
        duplication.addIngredient(blisterFlower);
        duplication.addIngredient(wratagrass);
        
        remover.addIngredient(wratagrass);
        remover.addIngredient(clove);
        remover.addIngredient(riverCress);
        
        unknown.addIngredient(taglisbi);
        unknown.addIngredient(orreamin);
        unknown.addIngredient(ashClove);
        unknown.addIngredient(eppeth);
        unknown.addIngredient(wratagrass);
        
        Room fairy = getRoom("Fairy Herbs");
        fairy.addItem(orreamin);
        
        notes.addPage("shrinking potion", shrinking.toString());
        notes.addPage("duplication potion", duplication.toString());
        notes.addPage("scent remover", remover.toString());
        notes.addPage("revealing potion", revealer.toString());
        wardBook.addPage("detection barrier", "");
        wardBook.addPage("travel ward", "");
        wardBook.addPage("invisibilty", "");
        
        potions.put("revealing potion", revealer);
        potions.put("shrinking potion", shrinking);
        potions.put("duplication potion", duplication);
        potions.put("scent remover", remover);
        potions.put("unknown potion", unknown);
        
        // element is 1
        garlic.addDescription(garlic.getDescription() + "  It's much smaller than it used to be.");
        pouch.addDescription("");
        notes.addDescription("You have to squint to read the small papers.");
        coins.addDescription("These coins probably aren't worth much anymore.");
        rune.addDescription(rune.getDescription() + "  It's much smaller than it used to be.");
        hiddenRune.addDescription(hiddenRune.getDescription() + "  It's much smaller than it used to be.");
        gold.addDescription("While you did tehnically squander away a whole lot of gold for no reason other than curiosity, there's still a good amount left.");
        bulb.addDescription(bulb.getDescription() + "  It's much smaller than it used to be.");
        cloth.addDescription(cloth.getDescription() + "  It's much smaller than it used to be.  You hope the fairies won't be mad.");
        card.addDescription(card.getDescription() + "  Despite it being shrunken, it is still valid.");
        broadsword.addDescription("The sword is much smaller than it used to be, and it's easy for you to lift.");
        eppeth.addDescription("");
        riverCress.addDescription("");
        blisterFlower.addDescription("");
        wratagrass.addDescription("");
        hifefron.addDescription("");
        taglisbi.addDescription("");
        inneoShoot.addDescription("");
        ashClove.addDescription("");
        orreamin.addDescription("");
        cauldron.addDescription("");
        vial.addDescription("");
        jewelryBox.addDescription("");
        cellarKey.addDescription("");
        shed.addDescription("");
        cat.addDescription("");
        wardBook.addDescription("");
        
        // element is 2
        garlic.addDescription("Your nose thanks you.");
        pouch.addDescription(pouch.getDescription() + "  It doesn't smell like much of anything.");
        notes.addDescription(notes.getDescription() + "  It doesn't smell like much of anything.");
        coins.addDescription(coins.getDescription() + "  It doesn't smell like much of anything.");
        rune.addDescription(rune.getDescription() + "  It doesn't smell like much of anything.");
        hiddenRune.addDescription(hiddenRune.getDescription() + "  It doesn't smell like much of anything.");
        gold.addDescription(gold.getDescription() + "  It doesn't smell like much of anything.");
        bulb.addDescription(bulb.getDescription() + "  It doesn't smell like much of anything.");
        cloth.addDescription(cloth.getDescription() + "  It doesn't smell like much of anything.");
        card.addDescription(card.getDescription() + "  It doesn't smell like much of anything.");
        broadsword.addDescription(broadsword.getDescription() + "  It doesn't smell like much of anything.");
        eppeth.addDescription(eppeth.getDescription() + "  It doesn't smell like much of anything.");
        riverCress.addDescription(riverCress.getDescription() + "  It doesn't smell like much of anything.");
        blisterFlower.addDescription(blisterFlower.getDescription() + "  It doesn't smell like much of anything.");
        wratagrass.addDescription(wratagrass.getDescription() + "  It doesn't smell like much of anything.");
        hifefron.addDescription(hifefron.getDescription() + "  It doesn't smell like much of anything.");
        taglisbi.addDescription("You mourn the loss of such a pleasant scent.");
        inneoShoot.addDescription(inneoShoot.getDescription() + "  It doesn't smell like much of anything.");
        ashClove.addDescription(ashClove.getDescription() + "  It doesn't smell like much of anything.");
        orreamin.addDescription(orreamin.getDescription() + "  It doesn't smell like much of anything.");
        cauldron.addDescription(cauldron.getDescription() + "  It doesn't smell like much of anything.");
        vial.addDescription(vial.getDescription() + "  It doesn't smell like much of anything.");
        jewelryBox.addDescription(jewelryBox.getDescription() + "  It doesn't smell like much of anything.");
        cellarKey.addDescription("Your fingers thank you.");
        shed.addDescription(shed.getDescription() + "  It doesn't smell like much of anything.");
        cat.addDescription(cat.getDescription() + "  It doesn't smell like much of anything.");
        wardBook.addDescription(wardBook.getDescription() + "  It doesn't smell like much of anything.");
    }
    
    /**
     * Gets the potion associated with the specified item name.
     * 
     * @param theName The name of the specified item.
     * @return The potion associated with the specified item name.
     */
    public Potion getPotion(String theName) {
        return potions.get(theName);
    }
    
    /**
     * Creates the non-player characters.
     */
    public void createCharacters() {
        Conversation taveCon = new Conversation("Tave", "Stay sharp, kid");
        Conversation fairyCon = new Conversation("Fairy", "Goodbye, insolent child");
        Conversation guardianCon = new Conversation("Forest Guardian", "Please do come by again soon");
        Conversation lizardCon = new Conversation("Lizard", "Leave me, small human");
        Conversation guardsmanCon = new Conversation("Guardsman", "Leave me to my work");
        Conversation officialCon = new Conversation("Official Camret", "Thank you for your visit to the Fairsway Government Office");
        Conversation sylCon = new Conversation("Syl", "Bye-bye, little lady");
        
        Character tave = new Character("tave", taveCon);
        Character fairy = new Character("fairy", fairyCon);
        Character guardian = new Character("forest Guardian", guardianCon);
        Character lizard = new Character("lizard", lizardCon);
        Character guardsman = new Character("guardsman", guardsmanCon);
        Character official = new Character("official camret", officialCon);
        Character syl = new Character("syl", sylCon);
         
        characters.put("Tave", tave);
        characters.put("Fairy", fairy);
        characters.put("Forest Guardian", guardian);
        characters.put("Lizard", lizard);
        characters.put("Guardsman", guardsman);
        characters.put("Official Camret", official);
        characters.put("Syl", syl);
        
        Room lizardRoom = getRoom("Lizard");
        lizardRoom.addCharacter(lizard);        
        Room weaponsRoom = getRoom("Fairsway Weapons");
        weaponsRoom.addCharacter(tave);
        Room fairyRoom = getRoom("Fairy Herbs");
        fairyRoom.addCharacter(fairy);
        Room guardianRoom = getRoom("Forest Guardian");
        guardianRoom.addCharacter(guardian);
        Room guardsmanRoom = getRoom("In Front of Bridge");
        guardsmanRoom.addCharacter(guardsman);
        Room officialRoom = getRoom("Government Office");
        officialRoom.addCharacter(official);
        Room sylRoom = getRoom("Town Square");
        sylRoom.addCharacter(syl);
        
        for (Item current : npcItems) {
            String itemName = current.getName();
            
            if (itemName.equals("illuminated bulb")) {
                lizard.setInventory(current);
            }
            else if (itemName.equals("soft cloth")) {
                syl.setInventory(current);
            }
            else if (itemName.equals("gold")) {
                guardian.setInventory(current);
            }
            else if (itemName.equals("citizenship card")) {
                official.setInventory(current);
            }
            else {
                fairy.setInventory(current);
            }
        }
        
        for (Item current : tradeItems) {
            String itemName = current.getName();
            
            if (itemName.equals("coin collection")) {
                lizard.addTradeItem(current);
            }
            else if (itemName.equals("broadsword")) {
                syl.addTradeItem(current);
            }
            else if (itemName.equals("unknown potion")) {
                guardian.addTradeItem(current);
            }
            else if (itemName.equals("gold")) {
                official.addTradeItem(current);
            }
            else {
                fairy.addTradeItem(current);
            }
        }
        
        fairy.setTradeMessage("So you're not entirely useless.");
        guardian.setTradeMessage("You're such a nice child, Faye.");
        lizard.setTradeMessage("I suppose this is good enough to be my hoard.");
        official.setTradeMessage("Congratulations, you were accepted! Here you go.");
        syl.setTradeMessage("I don't know how you were able to convince Tave, but I'm not going to question it. You want the cloth, right? This is more than worth it.");
        
        tave.setResponses(taveCon);
        fairy.setResponses(fairyCon);
        guardian.setResponses(guardianCon);
        lizard.setResponses(lizardCon);
        guardsman.setResponses(guardsmanCon);
        official.setResponses(officialCon);
        syl.setResponses(sylCon);
        
        fairyCon.addReply("hi", "What are you doing here? \n\n\tA: That's none of your business.\n\tB: I'm looking for a cat.\n\tC: Just admiring, you know, things. \n");
        fairyCon.addReply("hia", "Goodbye, insolent child.");
        fairyCon.addReply("hib", "Was it gray with white feet? \n\n\tA: Yes!\n\tB: No... \n");
        fairyCon.addReply("hic", "You flatterer.  Though, yes, I am quite beautiful. \n\n\tA: I was actually talking about the plants.\n\tB: Nothing can compare.\n\tC: Are you? I'm not good at judging fairy beauty since I'm, uh, human.\n\tD: No, you're not.\n");
        fairyCon.addReply("hiba", "Oh, I've never seen a cat of that coloring.  How wonderful. \n\n\tA: Never?  Are you sure? \n\tB: Um, that's too bad?\n\tC: Liar. \n");
        fairyCon.addReply("hibaa", "What are you implying?  Goodbye, insolent child.");
        fairyCon.addReply("hibab", "Yes, a shame.\n\n\tA: I'm just going to leave.\n\tB: If I ever see one in the woods, I'll bring it to you.\n");
        fairyCon.addReply("hibaba", "And you are also incredibly rude.  Goodbye, insolent child.");
        fairyCon.addReply("hibabb", "You are quite naive.  I almost feel pity, but I don't.\n\n\tA: I regret trying to be nice.\n\tB: Don't worry.  I know you need all that pity for yourself.\n");
        fairyCon.addReply("hibabba", "I regret indulging you and this worthless conversation.  Goodbye, insolent child.");
        fairyCon.addReply("hibabbb", "You think you're clever, do you?  Goodbye, insolent child.");
        fairyCon.addReply("hibac", "Who are you to assume that I am lying?  Goodbye, insolent child.");
        fairyCon.addReply("hibb", "That's too bad.  I just saw one like that pass by a few moments ago. \n\n\tA: Uh, good for you?\n\tB: Would you happen to know what direction it went in?\n");
        fairyCon.addReply("hibba", "No reaction?  I could have sworn your cat looked like that.  Well, nevermind.  Goodbye, insolent child.");
        fairyCon.addReply("hibbb", "Maybe I do.  The real question is what would you do for that information?\n\n\tA: Absolutely nothing. You're horrid.\n\tB: What do you want me to do?\n");
        fairyCon.addReply("hibbba", "You, who would prefer to let your cat wander the forest alone than do a small errand, seems much more horrid to me.  Goodbye, insolent child.");
        fairyCon.addReply("hibbbb", "Get me the softest cloth known to all creatures.  Can you do that?  Of course, you, especially you, can't.  You're cat will just have to suffer alone.  Goodbye, insolent child.");
        fairyCon.addReply("hica", "Oh, yes, well.  The orreamin have bloomed wonderfully this year.\n\n\tA: Can I have some?\n\tB: They're kind of tiny, though.\n");
        fairyCon.addReply("hicaa", "Of course not!  We have used our very own magic to grow these plants.  There's like our children, and we do not part with them easily.\n\n\tA: Don't you give some to Master?\n\tB:So that's a 'no'?\n");
        fairyCon.addReply("hicaaa", "This and that are entirely different.  She pays for them, while you don't seem to have such plans.  Goodbye, insolent child.");
        fairyCon.addReply("hicaab", "You do, at the very least, have a small amount of sense.  Goodbye, insolent child.");
        fairyCon.addReply("hicab", "Do you enjoy when someone comes into your home and insults your belongings? Goodbye, insolent child.");
        fairyCon.addReply("hicb", "You seem to be in need of some self-reflection.  Goodbye, insolent child.");
        fairyCon.addReply("hicc", "Well, we all have our faults.  You, particularly, have many.\n\n\tA: I don't view my humanity as a fault. \n\tB: Has anyone ever told you that you're unpleasant?\n");
        fairyCon.addReply("hicca", "Yes, most humans do not, which is yet another fault.  It's something you should go work on.  Goodbye, you insolent child.");
        fairyCon.addReply("hiccb", "I've been very kind, engaging in such an insipid conversation just to entertain you, and this is how you treat me?  Goodbye, insolent child.");
        fairyCon.addReply("hicd", "I have never been more disrespected in my life!  Goodbye, insolent child.");
        
        guardianCon.addReply("hi", "Oh, Faye, hello.\n\n\tA: You make me uncomfortable.\tB: Hello, uh, sir.\n\tC: You know my cat, right? Is he is the forest?");
        guardianCon.addReply("hia", "You'll do me a favor, won't you?\n\n\tA: Uh, sure?\n\tB: No?\n\tC: Are we ignoring the uncomfortable thing?\n");
        guardianCon.addReply("hiaa", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hiaaa", "Please do come by again soon.");
        guardianCon.addReply("hiaab", "Please do come by again soon.");
        guardianCon.addReply("hiab", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hiaba", "Please do come by again soon.");
        guardianCon.addReply("hiabb", "Please do come by again soon.");
        guardianCon.addReply("hiac", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hiaba", "Please do come by again soon.");
        guardianCon.addReply("hiabb", "Please do come by again soon.");
        guardianCon.addReply("hib", "You'll do me a favor, won't you?\n\n\tA: Uh, sure?\n\tB: No?\n\tC: Goodbye, sir.\n");
        guardianCon.addReply("hiba", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hibaa", "Please do come by again soon.");
        guardianCon.addReply("hibab", "Please do come by again soon.");
        guardianCon.addReply("hibb", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hibba", "Please do come by again soon.");
        guardianCon.addReply("hibbb", "Please do come by again soon.");
        guardianCon.addReply("hibc", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hibba", "Please do come by again soon.");
        guardianCon.addReply("hibbb", "Please do come by again soon.");
        guardianCon.addReply("hic", "You'll do me a favor, won't you?\n\n\tA: Uh, sure?\n\tB: No?\n\tC: I, um, asked you a question?\n");
        guardianCon.addReply("hica", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hicaa", "Please do come by again soon.");
        guardianCon.addReply("hicab", "Please do come by again soon.");
        guardianCon.addReply("hicb", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hicba", "Please do come by again soon.");
        guardianCon.addReply("hicbb", "Please do come by again soon.");
        guardianCon.addReply("hicc", "Good. Make me a potion using taglisbi, orreamin, ashClove, eppeth, and wratagrass.\n\n\tA: Can you repeat that?\n\tB: What--why?\n");
        guardianCon.addReply("hicba", "Please do come by again soon.");
        guardianCon.addReply("hicbb", "Please do come by again soon.");
        
        taveCon.addReply("hi", "Hey, Faye. Where's the older miss?\n\n\tA: Talking to Syl.\n\tB: Don't know.\n\tC: Have you seen a cat around?\n");
        taveCon.addReply("hic", "Smooth deflection there. But yeah, well, there are a whole bunch of strays around, but I don't think that's what you were going for.\n\n\tA: I'm looking for my cat.\n\tB: Strays?\n");
        taveCon.addReply("hica", "I didn't know you had one, unless we're talking about the older miss's.\n\n\tA: Master just recently got it for me. I have to learn how to be responsible, she say.\n\tB: No, she's still at the cottage somewhere.\n");
        taveCon.addReply("hicaa", "Responsible, eh? Maybe you shouldn't be out alone then. Stay sharp, kid.");
        taveCon.addReply("hicab", "With your master?\n\n\tA: ...\n\tB:Yeah, sure.\n\tC: No, Master's in town.\n");
        taveCon.addReply("hicaba", "You're a really bad liar, aren't you? Stay sharp, kid.");
        taveCon.addReply("hicabb", "You do realize that you just admitted to not having anyone with you, right? Stay sharp, kid.");
        taveCon.addReply("hicabc", "Let's say I believe that. Where exactly is she?\n\n\tA: ...Fairsway Potions.\n\tB: Maril's?\n\tC: The Southeast Market.\n");
        taveCon.addReply("hicabca", "A likely place, but try not to take so long to answer next time. Stay sharp, kid.");
        taveCon.addReply("hicabcb", "Not entirely implausible. Just need to work on the delivery. Stay sharp, kid.");
        taveCon.addReply("hicabcc", "Kid, why would she be there?\n\n\tA: Buying fruit! And, you know, stuff.\n\tB: Meeting a friend.\n");
        taveCon.addReply("hicabcca", "Are we talking about the same person? Faye, you know she doesn't trust other people to touch her food. Stay sharp, kid.");
        taveCon.addReply("hicabccb", "I have known the older miss for over twenty years, and she still doesn't consider us friends. I admit that I'm jealous. Stay sharp, kid.");
        taveCon.addReply("hicb", "Yeah, they prowl around in the alleyways. They're not friendly, so don't try to pet them. Stay sharp, kid.");
        taveCon.addReply("hib", "I worry about you sometimes, Faye. Go home, and stay sharp, kid.");
        taveCon.addReply("hia", "Oh, that guy.\n\n\tA: You don't sound too happy.\n\tB: You two know each other?\n");
        taveCon.addReply("hiaa", "I'm fine, Faye. Ignore me.\n\n\tA: Do I need to have a talk with him?\n\tB: Okay.\n");
        taveCon.addReply("hiaaa", "Cute, but no. Stay sharp, kid.");
        taveCon.addReply("hiaab", "Stay sharp, kid.");
        taveCon.addReply("hiab", "He's wants me to sell him my masterpiece.\n\n\tA: Are you?\n\tB: So sell it.\n");
        taveCon.addReply("hiaba", "No, I don't want to give away this sword to someone who just wants to make a profit in the capital. Only a true adventurer should own it. Stay sharp, kid.");
        taveCon.addReply("hiabb", "It's not that simple, Faye. Stay sharp, kid.");
        
        lizardCon.addReply("hi", "Who goes there?\n\n\tA: You're a talking lizard.\n\tB: Um, Faye.\n\tC: Can I have that sun blossom bulb?\n\tD: Why are you talking like that?\n");
        lizardCon.addReply("hia", "I am a mighty dragon, not a simple lizard. If you are going to be rude, then leave me, small human.");
        lizardCon.addReply("hib", "Hello, human Faye. I can understand your hesitance. This must be the first time you've seen such a magnificent dragon.\n\n\tA: Yeah, that's it.\n\tB: You're not a dragon.\n");
        lizardCon.addReply("hiba", "I don't wish for your face to get stuck like that. It looks painful. Leave me, small human.");
        lizardCon.addReply("hibb", "A common mistake. I am of the fire-wing family.\n\n\tA: Where are your wings then?\n\tB: Never heard of it.\n");
        lizardCon.addReply("hibba", "I lost them in a tragic accident when I was just a small hatchling. Oh, I'm tearing up. Leave me, small human.");
        lizardCon.addReply("hibbb", "So if you've never heard of something, then it doesn't exist? Is that how it is? Leave me, small human.");
        lizardCon.addReply("hic", "This is my hoard, not whatever a 'sun blossom bulb' is.\n\n\tA: Right, of course, but what if I bring you an even better hoard? Can I have it then?\n\tB: You're hoard is a 'sun blossom bulb'.\n");
        lizardCon.addReply("hica", "If my follower brings me an offering worthy of my great stature, then I suppose I will be gracious and grant her wish. Though, I am not easily pleased, I warn. Now, leave me, small human.");
        lizardCon.addReply("hicb", "I am kind, so I will not burn you to a crisp with my fiery breath. Leave me, small human.");
        lizardCon.addReply("hid", "Like what?\n\n\tA: You sound like you're recovering from a week-long cold.\n\tB: All scary and, uh, deep.\n");
        lizardCon.addReply("hida", "Do you talk to your parents with such disrespect? Leave me, small human.");
        lizardCon.addReply("hidb", "Ah, my natural voice is quite ferocious. I don't wish to frighten you. Leave me, small human.");
        
        guardsmanCon.addReply("hi", "Faye.\n\n\tA: Happy to see me?\n\tB: Who spat on your lapel?\n\tC: Your glasses are smudged.");
        guardsmanCon.addReply("hia", "You know very well how I feel right now. And no, you can't cross the bridge.\n\n\tA: I didn't ask!\n\tB: For the record, that is still completely unfair.\n");
        guardsmanCon.addReply("hiaa", "Are you saying you don't wish to enter the Citizen District?\n\n\tA: Yes!\n\tB: No, I do.\n\tC: I refuse to answer.\n");
        guardsmanCon.addReply("hiaaa", "Good. Now, leave me to my work.");
        guardsmanCon.addReply("hiaab", "Well, you can't. My job is to keep the non-citizens out. Do you have the proper papers? No? Then, leave me to my work.");
        guardsmanCon.addReply("hiaac", "That's fine. Now, stop blocking the path and leave me to my work.");
        guardsmanCon.addReply("hiab", "No matter how long you have lived in the nearby forest, you are still not a proper citizen, Faye. How many times must we have this talk? Now, leave me to my work.");
        guardsmanCon.addReply("hib", "I thought I had washed the stain out. Do your job properly, and you just get treated with disrespect. Thank you for bringing it to my attention. Now, leave me to my work.");
        guardsmanCon.addReply("hic", "How childish. I know for a fact that they are not.\n\n\tA: Let me guess. You're going to tell me why you know?\n\tB: But they are.\n");
        guardsmanCon.addReply("hica", "These glasses have been enchanted by Demle, one of the finest wizards in the country. Not only are they smudge-resistant, but they can see through any disguise.\n\n\tA: Good for you.\n\tB: Wow, that's amazing.\n");
        guardsmanCon.addReply("hicaa", "Your sarcasm is noted. Now, leave me to my work.");
        guardsmanCon.addReply("hicab", "Isn't it?! Oh, excuse me, I got a little too excited there. Very unprofessional. Now, leave me to my work.");
        guardsmanCon.addReply("hicb", "...Leave me to my work.");
        
        officialCon.addReply("hi", "Do I know you from somewhere?\n\n\tA: That seems unprofessional to ask.\n\tB: Maybe you've seen me around town.\n");
        officialCon.addReply("hia", "Ah, please excuse me. May I help you, young lady?\n\n\tA: How do I become a 'proper citizen' of Fairsway?\n\tB: No, I don't want your help.\n");
        officialCon.addReply("hiaa", "Well, you just need official documentation, which you can get right here.\n\n\tA: Where do I sign?\n\tB: Master says most things in life cost money.\n");
        officialCon.addReply("hiaaa", "Oh, no, you don't sign anything. I need to caste a spell on you, and then, Fairsway will judge you.\n\n\tA: Spell?\n\tB: Uh, judge? Sounds omin--ominous.\n");
        officialCon.addReply("hiaaaa", "It's nothing dangerous, I promise. But, the thing is, you still need to pay for it. Do you have money?\n\n\tA: Yes!\n\tB: No.\n");
        officialCon.addReply("hiaaaaa", "Well, just give it to me, and we'll get started! Oh, and I forgot: Thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hiaaaab", "I'm sorry. I can't help you without payment. But, um, thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hiaab", "Ah, sorry. It's not really a judgement per se. The town was enchanted hundreds of years ago to be somewhat sentient. It looks to see if it views you as one of its children.\n\n\tA: I don't want to do that.\n\tOkay, cast the spell.\n");
        officialCon.addReply("hiaaba", "I understand. Thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hiaabb", "Well, ah, you kind of need to pay for the spell. Do you have money?\n\n\tA: Yes!\n\tB: No.\n");
        officialCon.addReply("hiaabba", "Then, just give it to me, and we'll get started! Oh, and I forgot: Thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hiaabbb", "I'm sorry. I can't help you without payment. But, um, thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hiaab", "Master...? Well, I mean, it does cost a small fee. Do you have money?\n\n\tA: Yes!\n\tB: No.\n");
        officialCon.addReply("hiaaba", "Then, just give it to me, and we'll get started! Oh, and I forgot: Thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hiaabb", "I'm sorry. I can't help you without payment. But, um, thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hiab", "Oh, well, thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hib", "That hat! You're Faye, aren't you?\n\n\tA: Yes. How did you know?\n\tB: No, who's Faye?\n");
        officialCon.addReply("hiba", "There are rumors floating around town about you. People say you're a fairy.\n\n\tA: Gross.\n\tB: They're right.\n");
        officialCon.addReply("hibaa", "Well, what do you need?\n\n\tA: Proof that I'm a citizen of Fairsway.\n\tB: Nothing in particular.\n");
        officialCon.addReply("hibaaa", "You'll need to pay for something like that. Do you have money?\n\n\tA: Yes!\n\tB: No.\n");
        officialCon.addReply("hiaaaaa", "Then, just give it to me, and we'll get started! Oh, and I forgot: Thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hiaaaab", "I'm sorry. I can't help you without payment. But, um, thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hibaab", "Um, thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hibab", "Oh... Thank you for visiting Fairsway Government Office!");
        officialCon.addReply("hibb", "I'm actually a bit disappointed. They're just a child people in town have been talking about.\n\n\tA: What do they say?\n\tB: Who gossips about a child?\n");
        officialCon.addReply("hibbb", "You know, people. People who lead very fulfilled lives. Thank you for visiting Fairsway Government Office!");
        officialCon.addReply("hibba", "Well, she lives in the forest for one. With how dangerous that is, people say the reason she's still alive is because she's a fairy.\n\n\tA: Gross.\n\tB: They're right, I am.\n");
        officialCon.addReply("hibbaa", "Why gross...? Anyway, what do you need?\n\n\tA: Proof that I'm a citizen of Fairsway.\n\tB: Nothing in particular.\n");
        officialCon.addReply("hibbaaa", "You'll need to pay for something like that. Do you have money?\n\n\tA: Yes!\n\tB: No.\n");
        officialCon.addReply("hibbaaaa", "Then, just give it to me, and we'll get started! Oh, and I forgot: Thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hibbaaab", "I'm sorry. I can't help you without payment. But, um, thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hibbaab", "Um, thank you for visiting Fairsway Government Office.");
        officialCon.addReply("hibbab", "Oh... Thank you for visiting Fairsway Government Office!");
        
        sylCon.addReply("hi", "There's a sight for sore eyes. What you doing in the Square, little miss?\n\n\tA: I came to see my favorite merchant.\n\tB: I wanted to look at your wares.");
        sylCon.addReply("hib", "Sadly, I think they're a bit too pricy for you.\n\n\tA: What's a little bit of money between friends?\n\tB: I doubt they're that expensive.\n");
        sylCon.addReply("hiba", "Bye-bye, little lady.");
        sylCon.addReply("hibb", "Maybe not everything, but I did get my hands on quite the beauty.\n\n\tA: What is it?\n\tB: Can't say I care.\n");
        sylCon.addReply("hibba", "Verian cloth, made of the softest known material.\n\n\tA: That doesn't very interesting.\n\tB: Can I touch it?\n");
        sylCon.addReply("hibbaa", "Then, I guess I'll go tell some other kid about it. Bye-bye, little lady.");
        sylCon.addReply("hibbb", "Sorry, but it's under lock and key. Even I only got to feel it for a split second. You'd have to ask the buyer.\n\n\tA: Who's buying it?\n\tB: How stingy.\n");
        sylCon.addReply("hibbba", "No one yet. We're going to be heading off to the captial soon. And speaking of, I've got things to pack up. Bye-bye, little lady.");
        sylCon.addReply("hibbbb", "Not my rules. Now, sorry to cut this shory, but I've gotta get moving. Bye-bye, little lady.");
        sylCon.addReply("hibbb", "Wow, shot right through the heart. It seems I need to be more cautious around you. Bye-bye, little lady.");
        sylCon.addReply("hia", "Your favorite? That's quite the honor.\n\n\tA: When I ask you things, you don't yell at me.\n\tB: Don't get to overconfident. Falden is catching up to you.\n");
        sylCon.addReply("hiaa", "There's just getting cranky in their old age. You're no trouble. But, you know, I should be packing up, so bye-bye, little lady.");
        sylCon.addReply("hiab", "Falden, huh? I've got some sabotage to do. Bye-bye, little lady.");       
    }
    
    /**
     * Gets the specified character.
     * 
     * @param theName The name of the specified character.
     * @return The specified character.
     */
    public Character getCharacter(String theName) {
        return characters.get(theName);
    }
}