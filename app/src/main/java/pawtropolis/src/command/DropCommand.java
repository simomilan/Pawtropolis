package pawtropolis.src.command;

import pawtropolis.src.controller.GameController;
import pawtropolis.src.controller.InputController;
import pawtropolis.src.model.Item;
import pawtropolis.src.view.BagView;
import pawtropolis.src.view.ConsoleView;

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


    public static void executeDropCommand(GameController gameController, String secondPart) {
        ConsoleView consoleView = new ConsoleView();

        try {
            String item = InputController.cleanerInputMultipleWord(secondPart.split(" +")[1]);
            GameCommand dropCommand = new DropCommand(gameController, item);
            dropCommand.execute();

        } catch (ArrayIndexOutOfBoundsException e) {
            consoleView.displayInvalidNameItemToDrop();
        }
    }
}

