package pawtropolis.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.view.utility.CustomLogger;

@Component
public class DirectionView implements GameView {

    private final CustomLogger customLogger;

    @Autowired
    public DirectionView(CustomLogger customLoggerParam) {
        customLogger = customLoggerParam;
    }

    @Override
    public void displayMessage(String message) {
        customLogger.displayMessage(message);
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
