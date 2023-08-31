package pawtropolis.src.command;

import pawtropolis.src.controller.GameController;
import pawtropolis.src.view.BagView;


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

    public static void executeShowBagCommand(GameController gameController) {
        ShowBagCommand showBagCommand = new ShowBagCommand(gameController);
        showBagCommand.execute();
    }
}
