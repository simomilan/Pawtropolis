package command;

import controller.GameController;
import view.BagView;

public class ShowBagCommand implements GameCommand {

    private final GameController gameController;

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
