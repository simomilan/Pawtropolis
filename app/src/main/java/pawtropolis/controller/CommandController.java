package pawtropolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.*;
import pawtropolis.view.ConsoleView;
//TODO è un componente o un controller
@Component
public class CommandController {

    private final CommandFactory commandFactory;
    @Autowired
    public CommandController(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }
    
    ConsoleView consoleView = new ConsoleView();

    public void executeCommandFromInput(String input) {
        String cleanedInputSingleWord = InputController.cleanerInputSingleWord(input);
        String cleanedMultipleWords = InputController.cleanerInputMultipleWord(input);

        if (cleanedInputSingleWord.equalsIgnoreCase("help")) {
            commandFactory.createHelpCommand();
        } else if (cleanedInputSingleWord.equalsIgnoreCase("look")) {
            commandFactory.createLookCommand();
        } else if (cleanedMultipleWords.startsWith("go")) {
            commandFactory.createGoCommand(input);
        } else if (cleanedMultipleWords.startsWith("get")) {
            commandFactory.createAddCommand(input);
        } else if (cleanedMultipleWords.startsWith("drop")) {
            commandFactory.createDropCommand(input);
        } else if (cleanedInputSingleWord.equalsIgnoreCase("showBag")) {
            commandFactory.createShowBagCommand();
        } else if (cleanedInputSingleWord.equalsIgnoreCase("quit")) {
            commandFactory.createQuitCommand();
        } else {
            consoleView.displayInvalidCommand();
        }
    }

}
