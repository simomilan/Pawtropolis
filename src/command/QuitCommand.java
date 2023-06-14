package command;

import controller.GameController;

public class QuitCommand {

    private GameController gameController;

    public QuitCommand(GameController gameController) {
        this.gameController = gameController;
    }

    public void execute(){
        System.out.println("See you next time!");
    }
}
