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
        HashSet<Item> inventory = player.getInventory();
        
        if (inventory.size() == 0) {
            Writer.println("You are not carrying anything.");
        }
        else {
            Writer.println("Items:");
        }
        
        for (Item current : inventory) {
            String itemName = current.getName();
            
            Writer.println("     " + itemName);
        }
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
                String itemDescription = item.getDescription();
                Writer.println(itemName + ": " + "\n" + itemDescription);
            }
            else if (currentRoom.isInRoom(itemName)) {
                Item item = currentRoom.getItem(itemName);
                String itemDescription = item.getDescription();
                Writer.println(itemName + ": " + "\n" + itemDescription);
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
            }
            else {
                Writer.println("You search the room, but there is no such item to be found.");
            }
        }
    }
}
