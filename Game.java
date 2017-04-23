import java.util.Iterator;
import java.util.HashSet;
/**
 * This class is the main class of the "Campus of Kings" application.
 * "Campus of Kings" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * This game class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Maria Jump
 * @author Courtney Rikoskie
 * @version 2015.02.01
 */

public class Game {
    /** The world where the game takes place. */
    private World world;
    /** The score that the player currently has. */
    private int score;
    /** The number of turns that the player has taken. */
    private int turns;
    /** The player character. */
    private Player player;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
        world = new World();
        // set the starting room
        player = new Player(world.getRoom("Front Porch"));
        score = 0;
        turns = 0;
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main game loop. Here we repeatedly read commands and
        // execute them until the game is over.
        boolean wantToQuit = false;
        while (!wantToQuit) {
            Command command = Reader.getCommand();
            wantToQuit = processCommand(command);
            turns += 1;
            // other stuff that needs to happen every turn can be added here.
        }
        printGoodbye();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods for processing the commands

    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command
     *            The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            Writer.println("I don't know what you mean...");
        } 
        else {
            CommandEnum commandWord = command.getCommandWord();
            
            switch(commandWord) {
                case HELP:
                    printHelp();
                    break;
                case GO:
                    goRoom(command);
                    break;
                case QUIT:
                    wantToQuit = quit(command);
                    break;
                case LOOK:
                    look();
                    break;
                case STATUS:
                    status();
                    break;
                case BACK:
                    back();
                    break;
                case DROP:
                    drop(command);
                    break;
                case INVENTORY:
                    inventory();
                    break;
                case EXAMINE:
                    examine(command);
                    break;
                case TAKE:
                    take(command);
                    break;
                case UNLOCK:
                    unlock(command);
                    break;
                case LOCK:
                    lock(command);
                    break;
                case PACK:
                    pack(command);
                    break;
                case UNPACK:
                    unpack(command);
                    break;
                case MAKE:
                    make(command);
                    break;
                case EMPTY:
                    empty(command);
                    break;
                case POUR:
                    pour(command);
                    break;
                case READ:
                    read(command);
                    break;
                default:
                    Writer.println(commandWord + " is not implemented yet!");
                    break;
            }
        }
        return wantToQuit;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods for implementing all of the commands.
    // It helps if you organize these in alphabetical order.

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     * 
     * @param command
     *            The command to be processed.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Go where?");
        } 
        else {
            String direction = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            // Try to leave current.
            Door doorway = null;
            doorway = currentRoom.getExit(direction);

            if (doorway == null) {
                Writer.println("There is no door!");
            } 
            else if (doorway.isLocked()) {
                Writer.println("You try your best to open the hatch, but it's locked and won't budge.");
            }
            else {
                Room newRoom = doorway.getDestination();
                player.setCurrentRoom(newRoom);
                
                int roomPoints = newRoom.getPoints();
                score += roomPoints;
                
                printLocationInformation();
            }
        }
    }

    /**
     * Print out the closing message for the player.
     */
    private void printGoodbye() {
        Writer.println("You have earned " + score + " in " + (turns - 1) + " turns.");
        Writer.println("I hope you weren't too bored here on the Campus of Kings!");
        Writer.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        Writer.println("You are lost. You are alone. You wander");
        Writer.println("around at the university.");
        Writer.println();
        
        String commands = CommandWords.getCommandString();
        Writer.println(commands);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        Writer.println();
        Writer.println("Welcome to the Campus of Kings!");
        Writer.println("Campus of Kings is a new, incredibly boring adventure game.");
        Writer.println("Type 'help' if you need help.");
        Writer.println();
        printLocationInformation();
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @param command
     *            The command to be processed.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        boolean wantToQuit = true;
        if (command.hasSecondWord()) {
            Writer.println("Quit what?");
            wantToQuit = false;
        }
        return wantToQuit;
    }

    /**
     * Prints out the current location and exits.
     */
    private void printLocationInformation() { 
        Room currentRoom = player.getCurrentRoom();
        
        Writer.println(currentRoom.toString());
    }
    
    /**
     * Prints out the location information.
     */
    private void look() {
        printLocationInformation();
    }
    
    /**
     * Prints out the player's status.
     */
    private void status() {
        Writer.println("You have earned " + score + " points in " + turns + " turns.");
        Writer.println();
        Writer.println(player.getCurrentRoom().toString());
    }
    
    /**
     * Takes the player back to the previous room, if it exists.
     */
    private void back() {
        Room previous = player.getPreviousRoom();
        
        if (previous != null) {
            player.setCurrentRoom(previous);
            Writer.println(player.getCurrentRoom().toString());
        }
        else {
            Writer.println("You cannot go back.");
        }
    }
    
    /**
     * Drops an item from the player character's inventory.
     * 
     * Command command The command to be processed.
     */
    private void drop(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to drop?");
        }
        else {
            String itemName = command.getRestOfLine();
            
            if (player.isInInventory(itemName)) {
                Item item = player.getItem(itemName);
                player.removeItem(itemName);
                player.getCurrentRoom().addItem(item);
                Writer.println("Dropped.");
            }
            else {
                Writer.println("You are not carrying this item.");
            }
        }
    }
    
    /**
     * Prints out the player character's inventory.
     */
    private void inventory() {
        Writer.println(player.toString());        
    }
    
    /**
     * Examines a specified item.
     * 
     * @param command The command to be processed.
     */
    private void examine(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to examine?");
        }
        else {
            String itemName = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            if (player.isInInventory(itemName)) {
                Item item = player.getItem(itemName);
                Writer.println(item.toString());
            }
            else if (currentRoom.isInRoom(itemName)) {
                Item item = currentRoom.getItem(itemName);
                Writer.println(item.toString());
            }
            else {
                Writer.println("You search the room and your pockets, but there is no such item to be found.");
            }
        }
    }
    
    /**
     * Takes a specified item.
     * 
     * @param command The command to be processed.
     */
    private void take(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to take?");
        }
        else {
            String itemName = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            if (currentRoom.isInRoom(itemName)) {
                Item item = currentRoom.getItem(itemName);
                boolean added = player.addToInventory(item);
                
                if (added) {
                    currentRoom.removeItem(itemName);
                    Writer.println("Taken.");
                }
                else {
                    if (item.getWeight() > Player.MAX_WEIGHT) {
                        Writer.println("This item is too heavy for you to pick up.");
                    }
                    else {
                        Writer.println("You try to pick it up, but you're already carrying so much.");
                    }
                }
            }
            else {
                Writer.println("You search the room, but there is no such item to be found.");
            }
        }
    }
    
    /**
     * Unlocks a specified door.
     * 
     * @param command The command to be processed.
     */
    private void unlock(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to unlock?");
        }
        else {
            String direction = command.getRestOfLine();
            Room room = player.getCurrentRoom();
            Door door = room.getExit(direction);
            
            if (door == null) {
                Writer.println("There is no door in that direction.");
            }
            else {
                if (door.isLocked()) {
                    Writer.println("With which key?");
                    String response = Reader.getResponse();
                    Item key = door.getKey();
                    String keyName = key.getName();
                    
                    if (player.isInInventory(response)) {
                        if (response.equals(keyName)) {
                            door.setLocked(false);
                            Writer.println("You unlocked the door.");
                        }
                        else {
                            Writer.println("The key doesn't fit the lock.");
                        }
                    }
                    else {
                        Writer.println("You don't have that key.");
                    }
                }
                else {
                    Writer.println("The door is already unlocked."); 
                }
            }
        }
    }
    
    /**
     * Locks a specified door.
     * 
     * @param command The command to be processed.
     */
    private void lock(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to lock?");
        }
        else {
            String direction = command.getRestOfLine();
            Room room = player.getCurrentRoom();
            Door door = room.getExit(direction);
            
            if (door == null) {
                Writer.println("There is no door in that direction.");
            }
            else {
                if (door.isLocked()) {
                    Writer.println("The door is already locked.");
                }
                else {
                    Item key = door.getKey();
                    
                    if (key == null) {
                        Writer.println("The door cannot be locked.");
                    }
                    else {
                        Writer.println("With which key?");
                        String keyName = key.getName();
                        String response = Reader.getResponse();
                        
                        if (player.isInInventory(response)) {
                            if (response.equals(keyName)) {
                                door.setLocked(true);
                                Writer.println("You locked the door.");
                            }
                            else {
                                Writer.println("That is not the right key.");
                            }
                        }
                        else {
                            Writer.println("You don't have that key.");
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Packs the specified item into a container.
     * 
     * @param command The command to be processed.
     */
    private void pack(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to pack?");
        }
        else {
            String itemName = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            if (!(currentRoom.isInRoom(itemName) || player.isInInventory(itemName))) {
                Writer.println("You can't pack an item you don't have.");
            }
            else {
                Item item = null;
                
                if (currentRoom.isInRoom(itemName)) {
                    item = currentRoom.getItem(itemName);
                }
                if (player.isInInventory(itemName)) {
                    item = player.getItem(itemName);
                }
                
                if (item.getWeight() > Player.MAX_WEIGHT) {
                    Writer.println("This item is too heavy for you to move.");
                }
                else {
                    Writer.println("Into which container?");
                    
                    String response = Reader.getResponse();
                    
                    if (!(currentRoom.isInRoom(response) || player.isInInventory(response))) {
                        Writer.println("You don't see that container anywhere.");
                    }
                    else {
                        Item container = null;
                        
                        if (currentRoom.isInRoom(response)) {
                            container = currentRoom.getItem(response);
                        }
                        if (player.isInInventory(response)) {
                            container = player.getItem(response);
                        }
                        
                        if (!(container instanceof Container) || container instanceof PotionContainer) {
                            Writer.println("You can't pack things in that.");
                        }
                        else if (container instanceof HerbContainer) {
                            HerbContainer aContainer = (HerbContainer)container;
                            
                            if (!(item instanceof Ingredient)) {
                                Writer.println("You probably shouldn't try to put that in there.");
                            }
                            else {
                                Ingredient ingredient = (Ingredient)item;
                                
                                if (player.isInInventory(itemName)) {
                                    if (ingredient.getWeight() + player.getTotalWeight() > Player.MAX_WEIGHT) {
                                        Writer.println("You try to pick it up, but you're already carrying so much.");
                                    }
                                    else {
                                        player.removeItem(itemName);
                                        Writer.println(aContainer.addHerb(ingredient));
                                    }
                                }
                                else {
                                    currentRoom.removeItem(itemName);
                                    Writer.println(aContainer.addHerb(ingredient));
                                }
                            }
                        }
                        else {
                            Container aContainer = (Container)container;
                            
                            if (player.isInInventory(itemName)) {
                                if (item.getWeight() + player.getTotalWeight() > Player.MAX_WEIGHT) {
                                    Writer.println("You try to pick it up, but you're already carrying so much.");
                                }
                                else {
                                    player.removeItem(itemName);
                                    aContainer.addItem(item);
                                    Writer.println("Packed.");
                                }
                            }
                            else {
                                currentRoom.removeItem(itemName);
                                aContainer.addItem(item);
                                Writer.println("Packed.");
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Unpacks the specified item from a container.
     * 
     * @param command The command to be processed.
     */
    private void unpack(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to unpack?");
        }
        else {
            String containerName = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            if (!(currentRoom.isInRoom(containerName) || player.isInInventory(containerName))) {
                Writer.println("You search the room and your pockets, but there is no such item to be found.");
            }
            else {
                Item container = null;
                
                if (currentRoom.isInRoom(containerName)) {
                    container = currentRoom.getItem(containerName);
                }
                if (player.isInInventory(containerName)) {
                    container = player.getItem(containerName);
                }
                
                if (!(container instanceof Container) || container instanceof PotionContainer) {
                    Writer.println("You can't unpack that.");
                }
                else {
                    Writer.println("What item would you like to unpack from the " + containerName + "?");
                    String response = Reader.getResponse();
                    Container aContainer = (Container)container;
                    
                    if (!aContainer.isInContainer(response)) {
                        Writer.println("You can't find that item in the " + containerName + ".");
                    }
                    else {
                        Item item = aContainer.getItem(response);
                        
                        if (currentRoom.isInRoom(containerName)) {
                            if (item.getWeight() + player.getTotalWeight() > Player.MAX_WEIGHT) {
                                Writer.println("You try to pick it up, but you're alreadt carrying so much.");
                            }
                            else {
                                aContainer.removeItem(response);
                                player.addToInventory(item);
                                Writer.println("Unpacked.");
                            }
                        }
                        else {
                            aContainer.removeItem(response);
                            player.addToInventory(item);
                            Writer.println("Unpacked.");
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Makes the specified item.
     * 
     * @param command The command to be processed.
     */
    private void make(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to make?");
        }
        else {
            String itemName = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            
                if (!currentRoom.getName().equals("Cellar")) {
                    Writer.println("You look around, but there is nothing here you can use to make potions.");
                }
                else {
                        
                }
        }
    }
    
    /**
     * Empties certain containers.
     * 
     * @param command The command to be processed.
     */
    private void empty(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to empty?");
        }
        else {
            String itemName = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            if (!(player.isInInventory(itemName) || currentRoom.isInRoom(itemName))) {
                Writer.println("You search the room and your pockets, but there is no such item to be found.");
            }
            else {
                Item item = null;
                
                if (player.isInInventory(itemName)) {
                    item = player.getItem(itemName);
                }
                else {
                    item = currentRoom.getItem(itemName);
                }
                
                if (!(item instanceof PotionContainer)) {
                    Writer.println("Why would you want to empty that?");
                }
                else {
                    PotionContainer container = (PotionContainer)item;
                    
                    if (container.isEmpty()) {
                        Writer.println("It's already empty.");
                    }
                    else {
                        Writer.println(container.empty());
                    }
                }
            }
        }
    }
    
    /**
     * Pours an item from one container into another.
     * 
     * @param command The command to be processed.
     */
    private void pour(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What item from a container would you like to pour?");
        }
        else {
            String itemName = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            if (!(currentRoom.isInRoomContainer(itemName) || player.isInInventoryContainer(itemName))) {
                Writer.println("That isn't in any of the nearby containers.");
            }
            else {
                Item item = null;
                Container container = null;
                
                if (currentRoom.isInRoomContainer(itemName)) {
                    container = currentRoom.getContainer(itemName);
                    item = container.getItem(itemName);
                }
                if (player.isInInventoryContainer(itemName)) {
                    container = player.getContainer(itemName);
                    item = container.getItem(itemName);
                }
                
                if (!(item instanceof Potion)) {
                    Writer.println("Why would you want to pour that?");
                }
                else {
                    Potion potion = (Potion)item;
                    
                    Writer.println("What would you like to pour it into?");
                    
                    String response = Reader.getResponse();
                    
                    if (!(player.isInInventory(response) || currentRoom.isInRoom(response))) {
                        Writer.println("You search the room and your pockets, but there is no such item to be found.");
                    }
                    else {
                        Item secondItem = null;
                
                        if (currentRoom.isInRoom(response)) {
                            secondItem = currentRoom.getItem(response);
                        }
                        if (player.isInInventory(response)) {
                            secondItem = player.getItem(response);
                        }
                        
                        if(!(secondItem instanceof PotionContainer)) {
                            Writer.println("Why would you want to pour into that?");
                        }
                        else {
                            PotionContainer potionContainer = (PotionContainer)secondItem;
                            
                            if (!potionContainer.isEmpty()) {
                                Writer.println("There's already something inside of that.");
                            }
                            else {
                                PotionContainer previous = potion.getContainer();
                                if (previous != null) {
                                    previous.empty();
                                }
                                Writer.println(potionContainer.addPotion(potion));
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Reads a book.
     * 
     * @param command The command to be processed.
     */
    private void read(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("What would you like to read?");
        }
        else {
            String itemName = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            if (!(currentRoom.isInRoom(itemName) || player.isInInventory(itemName))) {
                Writer.println("You search the room and your pockets, but there is no such item to be found.");
            }
            else {
                Item item = null;
                
                if (currentRoom.isInRoom(itemName)) {
                    item = currentRoom.getItem(itemName);
                }
                if (player.isInInventory(itemName)) {
                    item = player.getItem(itemName);
                }
                
                if (!(item instanceof Book)) {
                    Writer.println("Um, you can't read that.");
                }
                else {
                    Book book = (Book)item;
                    
                    Writer.println(book.read());
                    Writer.println("What would you like to read about?");
                    
                    String response = Reader.getResponse();
                    
                    Writer.println(book.goTo(response));
                }
            }
        }
    }
}
