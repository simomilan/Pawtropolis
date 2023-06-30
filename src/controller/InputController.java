package controller;

import command.AddCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {

    private InputController(){
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

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    public static String cleanerInputSingleWord(String input) {
        return input.trim().replaceAll(" +", "");
    }
    public static String cleanerInputMultipleWord(String input) {
        return input.trim().toLowerCase();
    }


}