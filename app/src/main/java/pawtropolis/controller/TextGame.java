package pawtropolis.controller;


import pawtropolis.command.CommandFactory;
import pawtropolis.model.Player;
import pawtropolis.view.ConsoleView;
import pawtropolis.view.utility.CustomLogger;


import java.util.logging.Logger;


public class TextGame {
    private final GameController gameController;
    private final ConsoleView consoleView = new ConsoleView();
    private final CommandController commandController;



    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger(Logger.getLogger(""));   //TODO ANChe qui si puo fare l'iniezione


    public TextGame(Player player) {
        consoleView.displayWelcomeMessage();
        String playerName = InputController.readString();
        player.setName(playerName);
        player.setLifePoints(Player.MAX_LIFE_POINTS);
        gameController = new GameController(player);
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




