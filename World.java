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
    /** The buildable items. */
    private HashMap<String, Potion> potions;

    /**
     * Constructor for the world.
     */
    public World() {
        rooms = new HashMap<String, Room>();
        potions = new HashMap<String, Potion>();
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
        
        Ingredient clove = new Ingredient("garlic clove", "It's a clove of garlic.", 0, 0.125);
        
        HerbContainer pouch = new HerbContainer("herb pouch", "The inside being made up of small protective pockets, it is perfect for toting around fragile herbs.", 5, 2);
        Book notes = new Book("notes", "Recipes for potions are scribbled upon a pile of small loose papers. The handwriting is so messy that it is unreadable to anyone but you.", 5, 4, "There are notes about:\n");
        Item coins = new Item("coin collection", "One of your cherished possessions, it is a jar filled with currency from far-off lands.  The coins are well-cared-for and shine brightly.", 0, 20);
        Room yourRoom = getRoom("Your Bedroom");
        yourRoom.addItem(pouch);
        yourRoom.addItem(notes);
        yourRoom.addItem(coins);
        
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
        
        Book wardBook = new Book("book on warding and barriers", "Recently, you've seen Master flipping through this book with a serious frown.  There is nothing on the dull red cover besides the author's last name.", 5, 36, "Table of Contents\n\n Your master has circled some of the items in the table.  They are:\n");
        PotionContainer cauldron = new PotionContainer("empty cauldron", "There is a black cauldron, recently bought, sitting on one of the leftmost tables.  Unlike the others in the room, it does not have a brewing potion inside it.", 0, 0); 
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
        Room guardian = getRoom("Forest Guardian");
        
        Item bulb = new Item("illuminated bulb", "It's the bulb of a sun blossom.  As they are native to only the southern part of the country, the lizard must have found one that had fallen off a travelling merchant cart.", 10, 2.5);
        Room lizard = getRoom("Lizard");
        lizard.addItem(bulb);
        
        Item cloth = new Item("soft cloth", "Made from the silk of volcanic worms, this cloth is revered as one of the softest that has ever graced the country.  It's rumored that the Duke of Nightwood sold his first child just to be able to touch the shimmering blue fabric.", 10, 16);
        Room townSquare = getRoom("Town Square");
        
        Item broadsword = new Item("broadsword", "After the last time, you don't trust yourself to pick up the broadsword without some assistance.  The weight, combined with the fact that it is longer than you are tall, makes it quite unwieldy.", 0, 129);
        Item duplicate = new Item("duplicate broadsword", "It is a perfect physical copy of the original but lacks the enchantments that made such an amazing weapon.", 0, 129);
        Room weapons = getRoom("Fairsway Weapons");
        weapons.addItem(broadsword);
        
        Item card = new Item("citizenship card", "Providing your name, age, and picture, this card is proof that you are a citizen of Fairsway.  Despite costing you so much gold, it is made up of some kind of flimsy material.  Hopefully, someone has cast some spells on it to prevent its destruction.", 15, 1);
        Room office = getRoom("Government Office");
        
        Item cat = new Item("your cat", "It stares back at you smugly.  You scowl and look away.", 50, 125);
        Room library = getRoom("Library");
        library.addItem(cat);
        
        Potion shrinking = new Potion("shrinking potion", "Bubbles float to the surface of the pick liquid.", 10, 7);
        Potion duplication = new Potion("duplication potion", "A dark green smoke rises from the potion of the same color.", 10, 7);
        Potion remover = new Potion("scent remover", "The potion is an unappetizing-looking brown.", 10, 7);
        Potion unknown = new Potion("unknown potion", "The ominous black of it makes a part of you want to keep it far away from the Guardian.", 0, 7);  
        
        Ingredient eppeth = new Ingredient("eppeth", "Its delicate white leaves tickle your hands.", 0, 0.2);
        Ingredient riverCress = new Ingredient("river cress", "Because they need a lot of water, you find these plants the hardest to care for.", 0, 0.2);
        Ingredient blisterFlower = new Ingredient("blister flower", "In spring, these plants bloom with brilliant red and orange flowers.", 0, 0.2);
        Ingredient wratagrass = new Ingredient("wratagrass", "This tall grass is the staple of many potions, useful in its stabilizing capabilities.", 0, 0.2);
        Ingredient hifefron = new Ingredient("hifefron", "Hifefron cacti are not suited for this climate, so Master has put a warming spell around them to keep them alive.", 0, 0.2);
        Ingredient taglisbi = new Ingredient("taglisbi", "The large blue flowers of this bush smell pleasant.  You know how to make very few potions with them as an ingredient, but Master uses them a lot.", 0, 0.2);
        Ingredient inneoShoot = new Ingredient("inneo shoot", "This plant consists of hundreds of fire-red shoots growing in a cluster.  Despite only having one of these in your yard, it takes up about two yous of space.", 0, 0.2);
        Ingredient ashClove = new Ingredient("ash clove", "It is the perfect time to harvest these gray buds from their tree.", 0, 0.2);
        Ingredient orreamin = new Ingredient("orreamin", "Infused with fairy magic, the buds of the low-growing plant glow under the shade of the trees.", 0, 0.2);
        backyard.addItem(eppeth);
        backyard.addItem(riverCress);
        backyard.addItem(blisterFlower);
        backyard.addItem(wratagrass);
        backyard.addItem(hifefron);
        backyard.addItem(taglisbi);
        backyard.addItem(inneoShoot);
        backyard.addItem(ashClove);
        
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
        wardBook.addPage("detection barrier", "");
        wardBook.addPage("travel ward", "");
        wardBook.addPage("invisibilty", "");
        
        potions.put("shrinking potion", shrinking);
        potions.put("duplication potion", duplication);
        potions.put("scent remover", remover);
        potions.put("unknown potion", unknown);
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
}
