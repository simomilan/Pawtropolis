package command;

import model.GameController;
import model.Item;
import model.Room;

public class AddCommand implements GameCommand{

    GameController gameController;
    private Item item;

    public AddCommand(GameController gameController, Item item) {
        this.gameController = gameController;
        this.item = item;
    }


    @Override
    public void execute() {
        Room currentRoom = gameController.getPlayer().getCurrentRoom();
        gameController.addItemToBag(item);
        gameController.removeItemFromRoom(item, currentRoom);
    }

    }



