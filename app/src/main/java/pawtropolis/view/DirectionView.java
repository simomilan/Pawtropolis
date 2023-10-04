package pawtropolis.view;

import org.springframework.stereotype.Component;
import pawtropolis.view.utility.CustomLogger;

import java.util.logging.Logger;
@Component
public class DirectionView implements GameView {


    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger(Logger.getLogger(""));

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
