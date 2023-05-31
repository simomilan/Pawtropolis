package command;

import model.GameController;
import model.Item;

public class AddCommand implements GameCommand{

    GameController gameController;
    private Item item;

    public AddCommand(GameController gameData, Item item) {
        this.gameController = gameData;
        this.item = item;
    }


    @Override
    public void execute () {//non è l'add item di quando popolo le stanze, ma di quando io giocatore rtaccolgo l'item
        () -> gameController.removeItemFromRoom(item); //////
        gameController.getPlayer().addItemToBag(item);


    }


}
