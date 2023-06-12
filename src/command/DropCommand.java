package command;

import model.GameController;
import model.Item;
import java.util.List;
import java.util.Scanner;

public class DropCommand implements GameCommand {

    private GameController gameController;
    private List<Item> items;


    public DropCommand(GameController gameController,List<Item> items) {
        this.gameController = gameController;
        this.items = items;

    }

    @Override

    public void execute() {

        List<Item> items = gameController.getBag().getItems();
        Scanner scanner = new Scanner(System.in);

        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");
            scanner.nextLine();
            return;
        }

        System.out.print("\nEnter the name of the item to drop: ");
        String itemName = scanner.nextLine();

        Item selectedItem = null;
        for (Item item : items) {
            if (item.getNameItem().equalsIgnoreCase(itemName)) {
                selectedItem = item;
                break;
            }
        }

        if (selectedItem != null) {
            gameController.removeItemFromRoom(selectedItem, gameController.getPlayer().getCurrentRoom());
            gameController.dropItemFromBag(selectedItem);
        } else {
            System.out.println("\nItem not found in your bag: " + itemName);
        }
    }
}



