package pawtropolis.src.view.utility;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomLogger {

    private final Logger logger;

    public CustomLogger( Logger logger){
        this.logger = Logger.getLogger(CustomLogger.class.getName());

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomFormatter());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
    }

    public void displayMessage(String message) {
        logger.info(message);
    }
}