package command;


import controller.GameController;
import model.Item;

import java.util.List;

public class ShowBagCommand implements GameCommand{

    private GameController gameController;;

    public ShowBagCommand (GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute () {

        List <Item> items = gameController.getPlayer().getBag().getItems();
        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");

        } else {
            System.out.print("\nIn bag: ");
            gameController.getPlayer().getBag().showBag();

            }

        System.out.println("\nRemaining space in bag: " + gameController.getPlayer().getBag().getAvailableSpace());
    }

   }

