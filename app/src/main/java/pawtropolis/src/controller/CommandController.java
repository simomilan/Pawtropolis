package pawtropolis.src.controller;

import pawtropolis.src.command.*;
import pawtropolis.src.view.ConsoleView;


public class CommandController {

    private final GameController gameController;


    public CommandController(GameController gameController) {
        this.gameController = gameController;
    }


    ConsoleView consoleView = new ConsoleView();

    public void executeCommandFromInput(String input) {
        String cleanedInputSingleWord = InputController.cleanerInputSingleWord(input);
        String cleanedMultipleWords = InputController.cleanerInputMultipleWord(input);

        if (cleanedInputSingleWord.equalsIgnoreCase("help")) {
            HelpCommand.executeHelpCommand();
        } else if (cleanedInputSingleWord.equalsIgnoreCase("look")) {
            LookCommand.executeLookCommand(gameController);
        } else if (cleanedMultipleWords.startsWith("go")) {
            GoCommand.executeGoCommand(gameController, cleanedMultipleWords);
        } else if (cleanedMultipleWords.startsWith("get")) {
            AddCommand.executeAddCommand(gameController, cleanedMultipleWords);
        } else if (cleanedMultipleWords.startsWith("drop")) {
            DropCommand.executeDropCommand(gameController, cleanedMultipleWords);
        } else if (cleanedInputSingleWord.equalsIgnoreCase("showBag")) {
            ShowBagCommand.executeShowBagCommand(gameController);
        } else if (cleanedInputSingleWord.equalsIgnoreCase("quit")) {
            QuitCommand.executeQuitCommand(gameController);
        } else {
            consoleView.displayInvalidCommand();
        }
    }

}

///