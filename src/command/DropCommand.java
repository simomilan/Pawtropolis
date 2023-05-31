package command;

import model.GameController;
import model.Item;

public class DropCommand implements GameCommand {

    private GameController gameController;
    private Item item;

    public DropCommand(GameController gameController, Item item) {
        this.gameController = gameController;
        this.item = item;
    }

    @Override
    public void execute() {
        gameController.getPlayer().dropItemFromBag(item);
    }
}
