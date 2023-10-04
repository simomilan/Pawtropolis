package pawtropolis.controller;


import pawtropolis.command.CommandFactory;
import pawtropolis.model.Player;
import pawtropolis.view.ConsoleView;

public class TextGame {
    private final GameController gameController;
    private final ConsoleView consoleView = new ConsoleView();
    private final CommandController commandController;

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
            consoleView.displayMessageAtTheHead();
            String input = InputController.readString();

            commandController.executeCommandFromInput(input);

        }
    }
}




