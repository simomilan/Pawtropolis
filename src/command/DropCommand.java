package command;

import controller.GameController;
import model.Item;
public class DropCommand implements GameCommand {

    private final GameController gameController;
    private final String itemName;

    public DropCommand(GameController gameController, String itemName) {
        this.gameController = gameController;
        this.itemName = itemName;
    }

    @Override
    public void execute() {
        Item selectedItem = gameController.getPlayer().getItemInBag(itemName);
        if (selectedItem == null) {
            System.out.println("\nItem not found in your bag: " + itemName);
            return;
        }
        gameController.getPlayer().removeItemFromBag(selectedItem);
        gameController.getMapController().getCurrentRoom().addItem(selectedItem);

        System.out.println("\nThe item has been dropped from the bag: " + selectedItem.getName());
        System.out.println(selectedItem.getName() + " has been added in the room " + gameController.getMapController().getCurrentRoom().getName());
        System.out.println("Now the available space in your bag is: " + gameController.getPlayer().getAvailableSpaceInBag() + "\n");
    }
}

