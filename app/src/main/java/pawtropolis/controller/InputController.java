package pawtropolis.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputController {
    private static final Logger logger = LoggerFactory.getLogger(InputController.class);

    private InputController() {
    }

    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            logger.error("\nError while reading user input");
            return "";
        }
    }
    public static String cleanInput(String input) {
        return input.trim().toLowerCase();
    }

}