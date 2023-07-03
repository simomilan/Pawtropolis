package command;

import controller.GameController;
import model.Item;
import view.BagView;

public class AddCommand implements GameCommand {

    private final GameController gameController;
    private final String itemName;


    public AddCommand(GameController gameController, String itemName) {
        this.gameController = gameController;
        this.itemName = itemName;
    }

    @Override
    public void execute() {
        BagView bagView = new BagView();
        Item selectedItem = gameController.getMapController().getCurrentRoom().getItemByName(itemName);

        if (selectedItem == null) {
            bagView.displayItemNotFound(itemName);
            return;
        }
        if (gameController.getPlayer().getAvailableSpaceInBag() >= selectedItem.getRequiredSpace()) {
            gameController.getMapController().getCurrentRoom().removeItem(selectedItem);
            gameController.getPlayer().addItemToBag(selectedItem);
            bagView.displayAddItemToBag(selectedItem.getName());

        } else {
            bagView.displayFullBag();
        }

    }
}



