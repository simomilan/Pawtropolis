package pawtropolis.view;

import pawtropolis.model.Item;
import pawtropolis.view.utility.CustomLogger;

import java.util.logging.Logger;

public class BagView implements GameView {


    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger(Logger.getLogger(""));

    @Override
    public void displayMessage(String message) {
        CUSTOM_LOGGER.displayMessage(message);
    }

    public void displayBag(String items, int availableSpace) {
        displayMessage("\nIn bag: " + items);
        displayMessage("\nRemaining space in bag: " + availableSpace);
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

    public void displayNotEnoughSpace(int necessarySpace, Item selectedItem) {
        displayMessage("\nThere's no enough space in your bag, you need "+ necessarySpace + " free space to pick up "+ selectedItem.getName());
    }
    public void displayNotEnoughSpaces(int necessarySpace, Item selectedItem) {
        displayMessage("\nThere's no enough space in your bag, you need "+ necessarySpace + " free spaces to pick up "+ selectedItem.getName());
    }
}