package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;


@Component
public class ShowBagCommand implements GameCommand {

    private final GameController gameController;
    @Autowired
    public ShowBagCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        String items = gameController.getPlayer().showBag();
        int availableSpace = gameController.getPlayer().getAvailableSpaceInBag();
        if (items.isEmpty()) {
            gameController.getBagView().displayEmptyBag();
        } else {
            gameController.getBagView().displayBag(items, availableSpace);
        }
    }
}
