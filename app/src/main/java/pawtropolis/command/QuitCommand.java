package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.view.ConsoleView;

@Component
public class QuitCommand implements GameCommand {

    GameController gameController;
@Autowired
    public QuitCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayQuitCommand();
        gameController.endGame();
    }
}
