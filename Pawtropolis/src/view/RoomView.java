package view;

import view.utility.CustomLogger;

public class RoomView implements GameView {

    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger();

    @Override
    public void displayMessage(String message) {
        CUSTOM_LOGGER.displayMessage(message);
    }


    public void displayItemInRoom(String items) {
        displayMessage("Items in room: " + items);
    }

    public void displayAbsenceItemInRoom() {
        displayMessage("There is no Items in the room.");
    }

    public void displayAbsenceAnimalInRoom() {
        displayMessage("There is no Animals in the room.");
    }


    public void displayAnimalInRoom(String animals) {
        displayMessage("Animals in room: " + animals);
    }

    public void displayNameRoom(String roomName) {
        displayMessage("\nYou are: " + roomName);
    }
}
