package view.utility;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomLogger {
    private static final Logger LOGGER = Logger.getLogger(CustomLogger.class.getName());

//TODO: converitire in costruttore? trasformare in Singleton?

    static {
        Logger logger = Logger.getLogger("");
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers) {
            logger.removeHandler(handler);
        }

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomFormatter());
        LOGGER.addHandler(consoleHandler);
        LOGGER.setLevel(Level.ALL);
    }

    public void displayMessage(String message) {
        LOGGER.info(message);
    }
}