package controller;

import model.*;
import view.ConsoleView;

public class TextGame {
    private final GameController gameController;
    private boolean gameRunning = true;
    private final ConsoleView consoleView = new ConsoleView();
    private final CommandController commandController;


    public TextGame() {
        consoleView.displayWelcomeMessage();
        String playerName = InputController.readString();
        gameController = new GameController(new Player(playerName, Player.MAX_LIFE_POINTS, new Bag()));
        commandController = new CommandController(gameController);
    }

    public void start() {
        String chosenName = gameController.getPlayer().getName();
        consoleView.displayStartGame(chosenName);

        while (gameRunning) {
            System.out.print("\n> ");
            String input = InputController.readString();
            commandController.processInput(input);
            if (input.equals("quit")) {
                setGameRunning(false);
            }

        }

    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

}