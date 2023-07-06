package controller;

import command.*;
import view.ConsoleView;


public class CommandController {

    private final GameController gameController;


    public CommandController(GameController gameController) {
        this.gameController = gameController;
    }

    ConsoleView consoleView = new ConsoleView();
//TODO: Scorporare nei Command
    public void executeCommandFromInput(String input) {
        String cleanedInputSingleWord = InputController.cleanerInputSingleWord(input);
        String cleanedMultipleWords = InputController.cleanerInputMultipleWord(input);

        if (cleanedInputSingleWord.equalsIgnoreCase("help")) {
            executeHelpCommand();
        } else if (cleanedInputSingleWord.equalsIgnoreCase("look")) {
            executeLookCommand();
        } else if (cleanedMultipleWords.startsWith("go")) {
            GoCommand.executeGoCommand(gameController, cleanedMultipleWords);
        } else if (cleanedMultipleWords.startsWith("get")) {
            AddCommand.executeAddCommand(gameController,cleanedMultipleWords);
        } else if (cleanedMultipleWords.startsWith("drop")) {
            DropCommand.executeDropCommand(gameController,cleanedMultipleWords);
        } else if (cleanedInputSingleWord.equalsIgnoreCase("showBag")) {
            executeShowBagCommand();
        } else if (cleanedInputSingleWord.equalsIgnoreCase("quit")) {
            executeQuitCommand();
        } else {
            consoleView.displayInvalidCommand();
        }
    }

    private void executeHelpCommand() {
        HelpCommand helpCommand = new HelpCommand();
        helpCommand.execute();
    }

    private void executeLookCommand() {
        LookCommand lookCommand = new LookCommand(gameController);
        lookCommand.execute();
    }





    private void executeShowBagCommand() {
        ShowBagCommand showBagCommand = new ShowBagCommand(gameController);
        showBagCommand.execute();
    }

    private void executeQuitCommand() {
        QuitCommand quitCommand = new QuitCommand();
        quitCommand.execute();
    }

}