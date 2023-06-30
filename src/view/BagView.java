package view;


public class BagView {
//SHOWcommang
    public void displayBag(String items, int availableSpace) {
        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");
        } else {
            System.out.println("\nIn bag: " + items);
        }
        System.out.println("\nREMining space in bag: " + availableSpace);
    }

    //ADDcommand
    public void displayAddItemToBag(String itemName) {
        System.out.println("\nThe item has been added to the bag: " + itemName);
        System.out.println( itemName + "has been removed from the room");
    }


    public void displayItemNotFound(String itemName) {
        System.out.println("\nItem not found: " + itemName);
    }

}