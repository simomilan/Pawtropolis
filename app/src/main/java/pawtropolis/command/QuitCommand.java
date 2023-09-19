package pawtropolis.command;

import pawtropolis.controller.GameController;
import pawtropolis.view.ConsoleView;


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
}
