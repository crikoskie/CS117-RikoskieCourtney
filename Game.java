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
        player = new Player(world.getRoom("outside"));
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
        } else {

            String commandWord = command.getCommandWord();
            if (commandWord.equals("help")) {
                printHelp();
            } else if (commandWord.equals("go")) {
                goRoom(command);
            } else if (commandWord.equals("quit")) {
                wantToQuit = quit(command);
            } else {
                Writer.println(commandWord + " is not implemented yet!");
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
        } else {
            String direction = command.getRestOfLine();
            Room currentRoom = player.getCurrentRoom();
            
            // Try to leave current.
            Door doorway = null;
            if (direction.equals("north")) {
                doorway = currentRoom.getNorthExit();
            }
            if (direction.equals("east")) {
                doorway = currentRoom.getEastExit();
            }
            if (direction.equals("south")) {
                doorway = currentRoom.getSouthExit();
            }
            if (direction.equals("west")) {
                doorway = currentRoom.getWestExit();
            }

            if (doorway == null) {
                Writer.println("There is no door!");
            } 
            else {
                Room newRoom = doorway.getDestination();
                player.setCurrentRoom(newRoom);
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
        Writer.println("Your command words are:");
        Writer.println("   go quit help");
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
}
