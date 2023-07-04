package view;

import view.utility.CustomLogger;

public class DirectionView implements GameView {

    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger();

    @Override
    public void displayMessage(String message) {
        CUSTOM_LOGGER.displayMessage(message);
    }

    public void displayNotFoundDirection() {
        displayMessage("\nInvalid direction. Choose a valid direction: north, south, east, west");
    }

    public void displayNotFoundRoom() {
        displayMessage("\nThere is no room in that direction");
    }

    public void displayNameCurrentRoom(String name) {
        displayMessage("\nYou have entered: " + name);
    }
}
