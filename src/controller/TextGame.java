package controller;

import model.*;
import view.ConsoleView;
import view.utility.CustomLogger;

import java.util.logging.Logger;

public class TextGame {
    private final GameController gameController;
    private final ConsoleView consoleView = new ConsoleView();
    private final CommandController commandController;


    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger(Logger.getLogger(""));


    public TextGame() {
        consoleView.displayWelcomeMessage();
        String playerName = InputController.readString();
        gameController = new GameController(new Player(playerName, Player.MAX_LIFE_POINTS, new Bag()));
        commandController = new CommandController(gameController);
    }

    public void start() {
        String chosenName = gameController.getPlayer().getName();
        consoleView.displayStartGame(chosenName);

        while (gameController.isGameRunning()) {
            CUSTOM_LOGGER.displayMessage("\n>");
            String input = InputController.readString();

            commandController.executeCommandFromInput(input);

        }
    }
}




