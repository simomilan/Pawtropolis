package pawtropolis.controller;


import pawtropolis.view.ConsoleView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class InputController {

    private InputController() {
    }

    public static String readString() {
        ConsoleView consoleView = new ConsoleView();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            consoleView.displayErrorReadMsg();
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