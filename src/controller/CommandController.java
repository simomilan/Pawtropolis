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
            HelpCommand helpCommand = new HelpCommand();
            helpCommand.execute();
        } else if (cleanedInputSingleWord.equalsIgnoreCase("look")) {
            LookCommand lookCommand = new LookCommand(gameController);
            lookCommand.execute();
        } else if (cleanedMultipleWords.startsWith("go")) {
            String direction = InputController.secondWordReader(cleanedMultipleWords);
            if (direction != null) {
                GameCommand goCommand = new GoCommand(gameController, direction);
                goCommand.execute();
            } else {
                consoleView.displayInvalidDirection();
            }
        } else if (cleanedMultipleWords.startsWith("get")) {
            String item = InputController.secondWordReader(cleanedMultipleWords);
            if (item != null) {
                GameCommand addCommand = new AddCommand(gameController, item);
                addCommand.execute();
            } else {
                consoleView.displayInvalidNameItemToGet();
            }
        } else if (cleanedMultipleWords.startsWith("drop")) {
            String item = InputController.secondWordReader(cleanedMultipleWords);
            if (item != null) {
                GameCommand dropCommand = new DropCommand(gameController, item);
                dropCommand.execute();
            } else {
                consoleView.displayInvalidNameItemToDrop();
            }
        } else if (cleanedInputSingleWord.equalsIgnoreCase("showBag")) {
            ShowBagCommand showBagCommand = new ShowBagCommand(gameController);
            showBagCommand.execute();
        } else if (cleanedInputSingleWord.equalsIgnoreCase("quit")) {
            QuitCommand quitCommand = new QuitCommand();
            quitCommand.execute();
        } else {
            consoleView.displayInvalidCommand();
        }

    }

}