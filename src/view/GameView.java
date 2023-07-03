package view;

import java.util.logging.Logger;

public interface GameView {

    Logger logger = Logger.getLogger(GameView.class.getName());

    void displayMessage(String message);
}