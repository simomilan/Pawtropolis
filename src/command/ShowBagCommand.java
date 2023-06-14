package command;


import controller.GameController;

public class ShowBagCommand implements GameCommand{

    private GameController gameController;;

    public ShowBagCommand (GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute () {
        gameController.getPlayer().showBag();
    }
}