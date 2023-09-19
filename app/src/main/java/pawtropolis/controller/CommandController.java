package pawtropolis.controller;

import pawtropolis.command.*;
import pawtropolis.view.ConsoleView;


public class CommandController {

    private final CommandFactory commandFactory;
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
