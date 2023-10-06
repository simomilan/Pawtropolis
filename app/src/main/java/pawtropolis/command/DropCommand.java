package pawtropolis.command;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.model.Item;

@Component
@Setter
public class DropCommand implements GameCommand {

    private final GameController gameController;
    private String itemName;

    @Autowired
    public DropCommand(GameController gameController1) {
        gameController = gameController1;
    }

    @Override
    public void execute() {
        Item selectedItem = gameController.getPlayer().getItemInBag(itemName);
        if (selectedItem == null) {
            gameController.getViewFactory().getBagView().displayItemNotFound(itemName);
            return;
        }
        gameController.getPlayer().removeItemFromBag(selectedItem);
        gameController.getMapController().getCurrentRoom().addItem(selectedItem);
        gameController.getViewFactory().getBagView().displayItemDropped(selectedItem.getName());
    }

}

