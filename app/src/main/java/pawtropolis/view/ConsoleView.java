package pawtropolis.view;


import pawtropolis.view.utility.CustomLogger;

import java.util.logging.Logger;

public class ConsoleView implements GameView {


    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger(Logger.getLogger(""));

    @Override
    public void displayMessage(String message) {
        CUSTOM_LOGGER.displayMessage(message);
    }

    public void displayQuitCommand() {
        displayMessage("\n See you next time!");
    }

    public void displayHelpCommand() {
        displayMessage("\nAvailable command:");
        displayMessage("\n- help: displays the list of command");
        displayMessage("\n- look: examine the current room");
        displayMessage("\n- go: choose a direction to change room (north, south, east, west). Example: go north");
        displayMessage("\n- get: pick up the select item and add it to the bag. Example: get + collar ");
        displayMessage("\n- drop: take the item out of the bag and leave it in the room. Example: drop collar");
        displayMessage("\n- showBag: displays the items in your bag ");
        displayMessage("\n- quit: quit the game");
    }

    public void displayWelcomeMessage() {
        displayMessage("Welcome to Pawtropolis!");
        displayMessage("\nEnter your player name: ");
    }

    public void displayStartGame(String name) {
        displayMessage("\nHello " + name + "! Please enter 'help' if you would like to view the available commands");
    }

    public void displayInvalidDirection() {
        displayMessage("\nInvalid command. Please use the format: go [direction]");
    }

    public void displayInvalidNameItemToGet() {
        displayMessage("\nPlease use the format: get [item name]");
    }

    public void displayInvalidNameItemToDrop() {
        displayMessage("\nInvalid command. Please use the format: drop [item name]");
    }

    public void displayInvalidCommand() {
        displayMessage("\nInvalid command. Enter 'help' to view the available commands.");
    }

}
