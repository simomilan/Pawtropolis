package pawtropolis.command;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.model.Item;


@Component
@Setter
public class AddCommand implements GameCommand {

    private final GameController gameController;
    private String itemName;

    @Autowired
    private AddCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        Item selectedItem = gameController.getMapController().getCurrentRoom().getItemByName(itemName);
        if (selectedItem == null) {
            gameController.getViewFactory().getBagView().displayItemNotFound(itemName);
            return;
        }
        int necessarySpace = Math.abs(gameController.getPlayer().getAvailableSpaceInBag() - selectedItem.getRequiredSpace());
        if (gameController.getPlayer().isEnoughSpaceInBag(selectedItem)) {
            gameController.getMapController().getCurrentRoom().removeItem(selectedItem);
            gameController.getPlayer().addItemToBag(selectedItem);
            gameController.getViewFactory().getBagView().displayAddItemToBag(selectedItem.getName());
        } else if (gameController.getPlayer().getAvailableSpaceInBag() == 0) {
            gameController.getViewFactory().getBagView().displayFullBag();
        } else if (necessarySpace == 1) {
            gameController.getViewFactory().getBagView().displayNotEnoughSpace(necessarySpace, selectedItem);
        } else if (necessarySpace > 1) {
            gameController.getViewFactory().getBagView().displayNotEnoughSpaces(necessarySpace, selectedItem);
        }
    }

}



