package view;

public class RoomView implements GameView {

    @Override
    public void displayMessage(String message) {
        GameView.logger.info(message);

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
