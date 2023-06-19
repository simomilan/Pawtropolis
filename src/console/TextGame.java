package console;
import java.util.ArrayList;
import java.util.Scanner;
import command.*;
import controller.GameController;
import controller.MapController;
import model.*;
import static controller.MapController.seeMap;

public class TextGame {

    private GameController gameController;
    private Scanner scanner;



    boolean gameRunning = true;

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }


    public TextGame() {

        scanner = new Scanner(System.in);
        System.out.println("Welcome to Pawtropolis!\nEnter your player name: ");
        String playerName = scanner.nextLine();

        gameController = new GameController(new Player(playerName, Player.MAX_LIFE_POINTS, new Bag(Bag.SPACE_BAG)), new MapController());

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
        }
    }

}