package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;


@Component
public class QuitCommand implements GameCommand {

    private final GameController gameController;
    @Autowired
    public QuitCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        gameController.getViewFactory().getConsoleView().displayQuitCommand();
        gameController.endGame();
    }
}
