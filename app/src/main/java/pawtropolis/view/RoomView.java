package pawtropolis.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.view.utility.CustomLogger;

@Component
public class RoomView implements GameView {

    private final CustomLogger customLogger;

    @Autowired
    private RoomView(CustomLogger customLoggerParam) {
        customLogger = customLoggerParam;
    }

    @Override
    public void displayMessage(String message) {
        customLogger.displayMessage(message);
    }


    public void displayItemInRoom(String items) {
        displayMessage("\nItems in room: " + items);
    }

    public void displayAbsenceItemInRoom() {
        displayMessage("\nThere is no Items in the room.");
    }

    public void displayAbsenceAnimalInRoom() {
        displayMessage("\nThere is no Animals in the room.");
    }


    public void displayAnimalInRoom(String animals) {
        displayMessage("\nAnimals in room: " + animals);
    }

    public void displayNameRoom(String roomName) {
        displayMessage("\nYou are: " + roomName);
    }
}
