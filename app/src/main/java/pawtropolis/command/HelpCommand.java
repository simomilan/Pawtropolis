package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;

@Component
public class HelpCommand implements GameCommand {

    private final GameController gameController;

    @Autowired
    private HelpCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        gameController.getViewFactory().getConsoleView().displayHelpCommand();

    }
}