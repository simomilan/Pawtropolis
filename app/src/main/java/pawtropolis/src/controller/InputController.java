package pawtropolis.src.controller;


import pawtropolis.src.view.utility.CustomLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;


public class InputController {

    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger(Logger.getLogger(""));

    private InputController() {
    }

    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            CUSTOM_LOGGER.displayMessage("Error while reading user input");
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