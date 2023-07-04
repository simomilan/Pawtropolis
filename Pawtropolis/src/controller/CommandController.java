package controller;

import command.*;
import view.ConsoleView;


public class CommandController {

    private final GameController gameController;


    public CommandController(GameController gameController) {
        this.gameController = gameController;
    }

    ConsoleView consoleView = new ConsoleView();

    public void processInput(String input) {
        String cleanedInputSingleWord = InputController.cleanerInputSingleWord(input);
        String cleanedMultipleWords = InputController.cleanerInputMultipleWord(input);

        if (cleanedInputSingleWord.equalsIgnoreCase("help")) {
            executeHelpCommand();
        } else if (cleanedInputSingleWord.equalsIgnoreCase("look")) {
            executeLookCommand();
        } else if (cleanedMultipleWords.startsWith("go")) {
            executeGoCommand(cleanedMultipleWords);
        } else if (cleanedMultipleWords.startsWith("get")) {
            executeAddCommand(cleanedMultipleWords);
        } else if (cleanedMultipleWords.startsWith("drop")) {
            executeDropCommand(cleanedMultipleWords);
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

    private void executeGoCommand(String cleanedMultipleWords) {
        String direction = InputController.secondWordReader(cleanedMultipleWords);
        if (direction != null) {
            GameCommand goCommand = new GoCommand(gameController, direction);
            goCommand.execute();
        } else {
            consoleView.displayInvalidDirection();
        }
    }

    private void executeAddCommand(String cleanedMultipleWords) {
        String item = InputController.secondWordReader(cleanedMultipleWords);
        if (item != null) {
            GameCommand addCommand = new AddCommand(gameController, item);
            addCommand.execute();
        } else {
            consoleView.displayInvalidNameItemToGet();
        }
    }

    private void executeDropCommand(String cleanedMultipleWords) {
        String item = InputController.secondWordReader(cleanedMultipleWords);
        if (item != null) {
            GameCommand dropCommand = new DropCommand(gameController, item);
            dropCommand.execute();
        } else {
            consoleView.displayInvalidNameItemToDrop();
        }
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