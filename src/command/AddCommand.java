package command;

import model.GameController;
import model.Item;
import model.Room;
import java.util.List;
import java.util.Scanner;

public class AddCommand implements GameCommand{

    GameController gameController;
    private  List<Item> itemList;


    public AddCommand(GameController gameController,  List<Item> itemList) {
        this.gameController = gameController;
        this.itemList =  itemList;
    }


    Scanner scanner = new Scanner(System.in);


    public void execute() {

        List<Item> items = gameController.getItems(gameController.getPlayer().getCurrentRoom());
        System.out.print("\nEnter the object's name to add to the bag: ");
        String itemName = scanner.nextLine();

        Item selectedItem = null;
        for (Item item : items) {
            if (item.getNameItem().equalsIgnoreCase(itemName.trim())) {
                selectedItem = item;
                break;
            }
        }

        if (selectedItem != null) {
            if (gameController.getBag().getAvailableSpace() >= selectedItem.getSpaceBagUsed()) {
                gameController.addItemToBag(selectedItem);
                gameController.removeItemFromRoom(selectedItem, gameController.getPlayer().getCurrentRoom());
                System.out.println("\nThe item has been added to the bag: " + selectedItem.getNameItem());
            } else {
                System.out.println("\nThere's no enough space in your bag " /*+ selectedItem.getNameItem()*/);
            }
        } else {
            System.out.println("\nItem not found: " + itemName);
        }

        }
    }






