package command;

import controller.GameController;
import model.Item;

import java.util.List;
import java.util.Scanner;

public class AddCommand implements GameCommand{

    private GameController gameController;
    private String itemName;


    public AddCommand(GameController gameController, String itemName) {
        this.gameController = gameController;
        this.itemName=itemName;
    }






    public void execute()  {

        List<Item> items = gameController.getMapController().getCurrentRoom().getItemsInRoom();


        Item selectedItem = null;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName.trim())) {
                selectedItem = item ;
                break;
            }
        }
        if (selectedItem == null) {
            System.out.println("\nItem not found: " + itemName);
            return;
        }
        int necessarySpace = Math.abs(gameController.getPlayer().getBag().getAvailableSpace() - selectedItem.getRequiredSpace());

        if (selectedItem != null) {
            if (gameController.getPlayer().getBag().getAvailableSpace() >= selectedItem.getRequiredSpace()) {

                gameController.getMapController().getCurrentRoom().removeItem(selectedItem);
                gameController.getPlayer().takeItem(selectedItem);
                System.out.println("\nThe item has been added to the bag: " + selectedItem.getName());
                System.out.println(selectedItem.getName() + " has been removed from the room");
            } else {
                if(necessarySpace == 1){
                    System.out.println("\nThere's no enough space in your bag, you need "+ necessarySpace + " free space to pick up "+ selectedItem.getName());
                }else{
                    System.out.println("\nThere's no enough space in your bag, you need "+ necessarySpace + " free spaces to pick up "+ selectedItem.getName());
                }
            }

        }
    }

}



