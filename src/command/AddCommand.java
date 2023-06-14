package command;

import controller.GameController;
import model.Item;

import java.util.List;
import java.util.Scanner;

public class AddCommand implements GameCommand{

    private GameController gameController;


    public AddCommand(GameController gameController) {
        this.gameController = gameController;
    }


    Scanner scanner = new Scanner(System.in);



    public void execute() {

        List<Item> items = gameController.getMapController().getCurrentRoom().getItemsInRoom();
        System.out.print("\nEnter the object's name to add to the bag: ");

        String itemName = scanner.nextLine();
        itemName = itemName.trim().replaceAll("\\s+", "");

        Item selectedItem = null;
        for (Item item : items) {
            if (item.getNameItem().equalsIgnoreCase(itemName.trim())) {
                selectedItem = item ;
                break;
            }
        }
        if (selectedItem == null) {
            System.out.println("\nItem not found: " + itemName);
            return;
        }
        int necessarySpace = Math.abs(gameController.getPlayer().getBag().getAvailableSpace() - selectedItem.getSpaceBagUsed());

        if (selectedItem != null) {
            if (gameController.getPlayer().getBag().getAvailableSpace() >= selectedItem.getSpaceBagUsed()) {
                gameController.getPlayer().addItemToBag(selectedItem);
                gameController.getMapController().getCurrentRoom().removeItem(selectedItem);
                System.out.println("\nThe item has been added to the bag: " + selectedItem.getNameItem());
                System.out.println(selectedItem.getNameItem() + " has been removed from the room");
            } else {
                if(necessarySpace == 1){
                    System.out.println("\nThere's no enough space in your bag, you need "+ necessarySpace + " free space to pick up "+ selectedItem.getNameItem());
                }else{
                    System.out.println("\nThere's no enough space in your bag, you need "+ necessarySpace + " free spaces to pick up "+ selectedItem.getNameItem());
                }
            }

        }
    }

}



