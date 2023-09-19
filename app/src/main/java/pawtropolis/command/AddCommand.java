package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.model.Item;
import pawtropolis.view.BagView;


@Component
public class AddCommand implements GameCommand {

    private final GameController gameController;
    private final String itemName;

@Autowired
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

}



