package pawtropolis.command;

import lombok.Setter;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.model.Item;
import pawtropolis.view.BagView;
@Component
@Setter
public class DropCommand implements GameCommand {

    private final GameController gameController;
    private  String itemName;

    public DropCommand(GameController gameController) {
        this.gameController = gameController;
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

