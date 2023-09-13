package pawtropolis.view;


import pawtropolis.view.utility.CustomLogger;

import java.util.logging.Logger;

public class RoomView implements GameView {


    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger(Logger.getLogger(""));

    @Override
    public void displayMessage(String message) {
        CUSTOM_LOGGER.displayMessage(message);
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
