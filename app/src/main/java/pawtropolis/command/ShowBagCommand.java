package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.view.BagView;

@Component
public class ShowBagCommand implements GameCommand {

    private final GameController gameController;
@Autowired
    public ShowBagCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        BagView bagView = new BagView();
        String items = gameController.getPlayer().showBag();
        int availableSpace = gameController.getPlayer().getAvailableSpaceInBag();
        if (items.isEmpty()) {
            bagView.displayEmptyBag();
        } else {
            bagView.displayBag(items, availableSpace);
        }
    }
}
