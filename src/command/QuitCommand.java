package command;

import controller.GameController;
import view.ConsoleView;

public class QuitCommand implements GameCommand {

    GameController gameController;

    public QuitCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayQuitCommand();
    }

    public static void executeQuitCommand(GameController gameController) {
        QuitCommand quitCommand = new QuitCommand(gameController);
        quitCommand.execute();
        gameController.endGame();

    }

}
