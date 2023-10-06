package pawtropolis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.model.Player;

@Component
public class TextGame {

    private final GameController gameController;
    private final CommandController commandController;

    @Autowired
    public TextGame(GameController gameControllerParam, CommandController commandControllerParam) {
        gameController = gameControllerParam;
        commandController = commandControllerParam;
        start();
    }

    public void start() {
        gameController.getViewFactory().getConsoleView().displayWelcomeMessage();
        String playerName = InputController.readString();
        gameController.getPlayer().setName(playerName);
        gameController.getPlayer().setLifePoints(Player.MAX_LIFE_POINTS);
        String chosenName = gameController.getPlayer().getName();
        gameController.getViewFactory().getConsoleView().displayStartGame(chosenName);

        while (gameController.isGameRunning()) {
            gameController.getViewFactory().getConsoleView().displayMessageAtTheHead();
            String input = InputController.readString();
            commandController.executeCommandFromInput(input);
        }
    }
}




