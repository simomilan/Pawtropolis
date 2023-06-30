package command;

import controller.GameController;
import model.Item;
import view.BagView;

public class AddCommand implements GameCommand {

    private final GameController gameController;
    private final String itemName;
    private final BagView bagView;


    public AddCommand(GameController gameController, String itemName, BagView bagView) {
        this.gameController = gameController;
        this.itemName = itemName;
        this.bagView = bagView;
    }

    @Override
    public void execute() {
        Item selectedItem = gameController.getMapController().getCurrentRoom().getItemByName(itemName);

        if (selectedItem == null) {
            bagView.displayItemNotFound(itemName);
            return;
        }
        if (gameController.getPlayer().getAvailableSpaceInBag() >= selectedItem.getRequiredSpace()) {
            gameController.getMapController().getCurrentRoom().removeItem(selectedItem);
            gameController.getPlayer().addItemToBag(selectedItem);
            bagView.displayAddItemToBag(selectedItem.getName());

        }

    }
}



