package command;

import controller.GameController;
import controller.InputController;
import model.Item;
import view.BagView;
import view.ConsoleView;

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
        //TODO: cambiare riga 28
        if (gameController.getPlayer().getAvailableSpaceInBag() >= selectedItem.getRequiredSpace()) {
            gameController.getMapController().getCurrentRoom().removeItem(selectedItem);
            gameController.getPlayer().addItemToBag(selectedItem);
            bagView.displayAddItemToBag(selectedItem.getName());

        } else {
            bagView.displayFullBag();
        }

    }
    public static void executeAddCommand(GameController gameController, String cleanedMultipleWords) {
        ConsoleView consoleView = new ConsoleView();
        String item = InputController.secondWordReader(cleanedMultipleWords);
        if (item != null) {
            AddCommand addCommand = new AddCommand(gameController, item);
            addCommand.execute();
        } else {
            consoleView.displayInvalidNameItemToGet();
        }
    }
}



