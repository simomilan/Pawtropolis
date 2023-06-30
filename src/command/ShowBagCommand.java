package command;
import controller.GameController;
import view.BagView;

public class ShowBagCommand implements GameCommand {

    private final GameController gameController;
    private final BagView bagView;

    public ShowBagCommand(GameController gameController, BagView bagView) {
        this.gameController = gameController;
        this.bagView = bagView;
    }

    @Override
    public void execute() {
        String items = gameController.getPlayer().showBag();
        int availableSpace = gameController.getPlayer().getAvailableSpaceInBag();
        bagView.displayBag(items, availableSpace);
    }

}
