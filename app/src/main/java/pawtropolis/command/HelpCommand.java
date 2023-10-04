package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;

@Component
public class HelpCommand implements GameCommand {

    private final GameController gameController;

    @Autowired
    public HelpCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        gameController.getConsoleView().displayHelpCommand();

    }
}