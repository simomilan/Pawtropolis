package view;

public class BagView implements GameView {


    @Override
    public void displayMessage(String message) {
        GameView.logger.info(message);
    }

    public void displayBag(String items, int availableSpace) {
        displayMessage("\nIn bag: " + items);
        displayMessage("Remaining space in bag: " + availableSpace);
    }

    public void displayEmptyBag() {
        displayMessage("\nYour bag is empty");
    }

    public void displayAddItemToBag(String itemName) {
        displayMessage("\nThe item has been added to the bag: " + itemName);
    }

    public void displayItemNotFound(String itemName) {
        displayMessage("\nItem not found: " + itemName);
    }

    public void displayFullBag() {
        displayMessage("\nYour bag is full!");
    }

    public void displayItemDropped(String itemName) {
        displayMessage("\nThe item has been dropped from the bag: " + itemName);
    }
}