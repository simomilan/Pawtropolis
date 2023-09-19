package pawtropolis.command;

import pawtropolis.controller.GameController;
import pawtropolis.controller.InputController;
import pawtropolis.model.Item;
import pawtropolis.view.BagView;
import pawtropolis.view.ConsoleView;

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

}

