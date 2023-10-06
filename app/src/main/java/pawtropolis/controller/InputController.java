package pawtropolis.controller;

import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class InputController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(InputController.class);

    private InputController() {
    }

    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            logger.warning("\nError while reading user input");
            return "";
        }
    }

    public static String cleanerInputSingleWord(String input) {
        return input.trim().replaceAll(" +", "");
    }

    public static String cleanerInputMultipleWord(String input) {
        return input.trim().toLowerCase();
    }

}