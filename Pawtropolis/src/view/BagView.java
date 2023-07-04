package view;

import view.utility.CustomLogger;

public class BagView implements GameView {

    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger();

    @Override
    public void displayMessage(String message) {
        CUSTOM_LOGGER.displayMessage(message);
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