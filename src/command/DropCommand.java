package command;

import model.GameController;
import model.Item;
import model.Room;

public class DropCommand implements GameCommand {

    private GameController gameController;
    private Item item;


    public DropCommand(GameController gameController, Item item) {
        this.gameController = gameController;
        this.item = item;

    }

    @Override
    public void execute() {
        Room currentRoom = gameController.getPlayer().getCurrentRoom();
        gameController.dropItemFromBag(item);
        gameController.addItemInRoom(item, currentRoom);
    }
    }

