package command;

import controller.GameController;
import controller.InputController;
import model.Item;
import view.BagView;
import view.ConsoleView;

public class DropCommand implements GameCommand {

    private final GameController gameController;
    private final String itemName;

    public DropCommand(GameController gameController, String itemName) {
        this.gameController = gameController;
        this.itemName = itemName;
    }

    @Override
    public void execute() {
        BagView bagView = new BagView();
        Item selectedItem = gameController.getPlayer().getItemInBag(itemName);
        if (selectedItem == null) {
            bagView.displayItemNotFound(itemName);
            return;
        }
        gameController.getPlayer().removeItemFromBag(selectedItem);
        gameController.getMapController().getCurrentRoom().addItem(selectedItem);
        bagView.displayItemDropped(selectedItem.getName());
    }


    public static void executeDropCommand(GameController gameController, String cleanedMultipleWords) {
        ConsoleView consoleView = new ConsoleView();
        String item = InputController.secondWordReader(cleanedMultipleWords);
        if (item != null) {
            DropCommand dropCommand = new DropCommand(gameController, item);
            dropCommand.execute();
        } else {
            consoleView.displayInvalidNameItemToDrop();
        }
    }
}

