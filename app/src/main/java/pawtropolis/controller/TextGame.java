package pawtropolis.controller;


import pawtropolis.model.Player;
import pawtropolis.model.Bag;
import pawtropolis.view.ConsoleView;
import pawtropolis.view.utility.CustomLogger;


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
        commandController = new CommandController(new CommandFactory(gameController));
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




