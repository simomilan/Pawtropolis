package pawtropolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.*;

@Component
public class CommandController {

    private final CommandFactory commandFactory;

    @Autowired
    private CommandController(CommandFactory commandParam) {
        commandFactory = commandParam;
    }

    public void executeCommandFromInput(String input) {
        String cleanedInput = InputController.cleanInput(input);

        if (cleanedInput.equalsIgnoreCase("help")) {
            commandFactory.createHelpCommand();
        } else if (cleanedInput.equalsIgnoreCase("look")) {
            commandFactory.createLookCommand();
        } else if (cleanedInput.startsWith("go")) {
            commandFactory.createGoCommand(input);
        } else if (cleanedInput.startsWith("get")) {
            commandFactory.createAddCommand(input);
        } else if (cleanedInput.startsWith("drop")) {
            commandFactory.createDropCommand(input);
        } else if (cleanedInput.equalsIgnoreCase("showBag")) {
            commandFactory.createShowBagCommand();
        } else if (cleanedInput.equalsIgnoreCase("quit")) {
            commandFactory.createQuitCommand();
        } else {
            commandFactory.getGameController().getViewFactory().getConsoleView().displayInvalidCommand();
        }
    }

}
