package view;

public class DirectionView implements GameView {

    @Override
    public void displayMessage(String message) {
        GameView.logger.info(message);

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
