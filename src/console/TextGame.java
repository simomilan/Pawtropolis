package console;

import java.util.Scanner;
import command.*;
import controller.GameController;
import controller.InputController;
import controller.MapController;
import model.*;


public class TextGame {

    private GameController gameController;
  //  private Scanner scanner;
  //  private InputController inputController;


    boolean gameRunning = true;

  //  public void setGameRunning(boolean gameRunning) {
    //    this.gameRunning = gameRunning;
 //   }


    public TextGame() {

      /*  scanner = new Scanner(System.in);
        System.out.println("Welcome to Pawtropolis!\nEnter your player name: ");
        String playerName = scanner.nextLine();

        gameController = new GameController(new Player(playerName, Player.MAX_LIFE_POINTS, new Bag(Bag.SPACE_BAG)), new MapController());
        inputController = new InputController();
    }

    public void start() {
        System.out.println("\nHello " + gameController.getPlayer().getName()+ "! " + "Please enter 'help' if you like to view the available commands");

       while (gameRunning) {
            System.out.print("\n> ");
            String input = scanner.nextLine();

            if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("help")) {
                HelpCommand helpCommand = new HelpCommand();
                helpCommand.execute();
            } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("look")) {
                LookCommand lookCommand = new LookCommand(gameController);
                lookCommand.execute();
            } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("go")) {
                GameCommand goCommand = new GoCommand(gameController);
                goCommand.execute();
            } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("get")) {
                AddCommand addCommand = new AddCommand(gameController);
                addCommand.execute();
            } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("drop")) {
                GameCommand dropCommand = new DropCommand(gameController);
                dropCommand.execute();
            } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("showBag")) {
                GameCommand showBagCommand = new ShowBagCommand(gameController);
                showBagCommand.execute();
            } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("quit")) {
                QuitCommand quitCommand = new QuitCommand();
                quitCommand.execute();
                setGameRunning(false);
            } else {
                System.out.println("Invalid command. Enter 'help' to view the available commands.");
            }
        }*/
        System.out.println("Welcome to Pawtropolis!");
        System.out.print("Enter your player name: ");
        String playerName = InputController.readString();
        gameController = new GameController(new Player(playerName, Player.MAX_LIFE_POINTS, new Bag(Bag.SPACE_BAG)), new MapController());
    }

    public void start() {
        System.out.println("\nHello " + gameController.getPlayer().getName() + "! Please enter 'help' if you would like to view the available commands");

        while (gameRunning) {
            System.out.print("\n> ");
            String input = InputController.readString();
            String sanitizedInput = InputController.cleanerInput(input);

            if (InputController.equalsIgnoreCase(sanitizedInput, "help")) {
                HelpCommand helpCommand = new HelpCommand();
                helpCommand.execute();
            } else if (InputController.equalsIgnoreCase(sanitizedInput, "look")) {
                LookCommand lookCommand = new LookCommand(gameController);
                lookCommand.execute();
            } else if  (sanitizedInput.startsWith("go")) {
                String[] commandParts = sanitizedInput.split("\\s+", 2);
                if (commandParts.length != 2) {
                    System.out.println("Invalid command. Please use the format: go [direction]");
                    continue;
                }
                String direction = commandParts[1];
                GameCommand goCommand = new GoCommand(gameController, direction);
                goCommand.execute();
            } else if (sanitizedInput.startsWith("get")) {
                String[] commandParts = sanitizedInput.split("\\s+", 2);
                if (commandParts.length != 2) {
                    System.out.println("Invalid command. Please use the format: get [item name]");
                    continue;
                }
                String itemName = commandParts[1];
                GameCommand addCommand = new AddCommand(gameController, itemName);
                addCommand.execute();
            } else if (sanitizedInput.startsWith("drop")) {
                String[] commandParts = sanitizedInput.split("\\s+", 2);
                if (commandParts.length != 2) {
                    System.out.println("Invalid command. Please use the format: get [item name]");
                    continue;
                }
                String itemName = commandParts[1];
                DropCommand dropCommand = new DropCommand(gameController, itemName);
                dropCommand.execute();
            } else if (InputController.equalsIgnoreCase(sanitizedInput, "showBag")) {
                ShowBagCommand showBagCommand = new ShowBagCommand(gameController);
                showBagCommand.execute();
            } else if (InputController.equalsIgnoreCase(sanitizedInput, "quit")) {
                QuitCommand quitCommand = new QuitCommand();
                quitCommand.execute();
                setGameRunning(false);
            } else {
                System.out.println("Invalid command. Enter 'help' to view the available commands.");
            }
        }
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public static void main(String[] args) {
        TextGame game = new TextGame();
        game.start();
    }
}
