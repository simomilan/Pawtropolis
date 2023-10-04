package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;


@Component
public class QuitCommand implements GameCommand {

    GameController gameController;
    @Autowired
    public QuitCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        gameController.getConsoleView().displayQuitCommand();
        gameController.endGame();
    }
}
