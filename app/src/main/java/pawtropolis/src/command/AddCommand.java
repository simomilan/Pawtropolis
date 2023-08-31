package pawtropolis.src.command;

import pawtropolis.src.controller.GameController;
import pawtropolis.src.controller.InputController;
import pawtropolis.src.model.Item;
import pawtropolis.src.view.BagView;
import pawtropolis.src.view.ConsoleView;


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
        int necessarySpace = Math.abs(gameController.getPlayer().getAvailableSpaceInBag() - selectedItem.getRequiredSpace());
        if (gameController.getPlayer().isEnoughSpaceInBag(selectedItem)) {
            gameController.getMapController().getCurrentRoom().removeItem(selectedItem);
            gameController.getPlayer().addItemToBag(selectedItem);
            bagView.displayAddItemToBag(selectedItem.getName());

        }else if (gameController.getPlayer().getAvailableSpaceInBag() == 0) {
            bagView.displayFullBag();

        } else if(necessarySpace == 1){
            bagView.displayNotEnoughSpace(necessarySpace, selectedItem);
        } else if(necessarySpace > 1){
            bagView.displayNotEnoughSpaces(necessarySpace, selectedItem);

        }
    }
    public static void executeAddCommand(GameController gameController, String secondParse) {
        ConsoleView consoleView = new ConsoleView();

        try {
            String item = InputController.cleanerInputMultipleWord(secondParse.split(" +")[1]);
                GameCommand addCommand = new AddCommand(gameController, item);
                addCommand.execute();

        } catch (ArrayIndexOutOfBoundsException e) {
            consoleView.displayInvalidNameItemToGet();
        }
    }
}



