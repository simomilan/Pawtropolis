package command;

import controller.GameController;
import model.Item;
import java.util.List;
import java.util.Scanner;

public class DropCommand implements GameCommand {

    private GameController gameController;



    public DropCommand(GameController gameController) {
        this.gameController = gameController;


    }

    public void execute() {
        List <Item> items = gameController.getPlayer().getBag().getItems();
        Scanner scanner = new Scanner(System.in);

        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");
            return;
        }

        System.out.print("\nEnter the name of the item to drop: ");
        String itemName = scanner.nextLine();
        itemName = itemName.trim().replaceAll("\\s+", "");

        Item selectedItem = null;
        for (Item item : items) {
            if (item.getNameItem().trim().equalsIgnoreCase(itemName)) {
                selectedItem = item;
                break;
            }
        }
        if (selectedItem != null) {
            gameController.getPlayer().dropItemFromBag(selectedItem, gameController.getMapController().getCurrentRoom());
        } else {
            System.out.println("\nItem not found in your bag: " + itemName);
        }
    }
}

