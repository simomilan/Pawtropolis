package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {


    private InputController() {
    }

    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            System.err.println("Error while reading user input");
            return "";
        }
    }

    public static String cleanerInputSingleWord(String input) {
        return input.trim().replaceAll(" +", "");
    }

    public static String cleanerInputMultipleWord(String input) {
        return input.trim().toLowerCase();
    }

    public static String secondWordReader(String input) {
        int spaceIndex = input.indexOf(' ');
        if (spaceIndex == -1) {
            return null;
        }
        String secondWord = input.substring(spaceIndex + 1).trim();
        return secondWord.isEmpty() ? null : secondWord;
    }


}