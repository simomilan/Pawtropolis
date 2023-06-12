package console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import command.*;
import model.*;
import zoo.*;

import static model.Player.MAX_LIFE_POINTS;

public class TextGame {

    private GameController gameController;
    private Scanner scanner;


    Item item1 = new Item("collar", "studded collar", 1);
    Item item2 = new Item("bone", "a human femur", 3);
    Item item3 = new Item("whip", "leather whip", 1);
    Item item4 = new Item("meat", "sheep", 4);
    Item item5 = new Item( "dildo", "anal plug", 2);
    Item item6 = new Item("muzzle", "anti-bark", 2);


    LocalDate l1 = LocalDate.of(2020, 1, 1);
    Animal animal1 = new Lion("Simba", "Meat", 4, l1, 320.00, 120.00, 90.00);
    LocalDate t1 = LocalDate.of(2021, 4, 2);
    Animal animal2 = new Eagle("Gatto", "Meat", 3, t1, 288.00, 116.00, 100.00);
    LocalDate l3 = LocalDate.of(2017, 3, 3);
    Animal animal3 = new Lion("Gio", "Meat", 7, l3, 325.00, 122.00, 94.00);
    LocalDate t2 = LocalDate.of(2019,9,10);
    Animal animal4 = new Tiger("Gino", "Meat", 6, t2, 301.00, 123.00, 102.00);
    LocalDate e2 = LocalDate.of(2018, 3,12);
    Animal animal5 = new Eagle("Titti", "Meat", 5, e2, 75.00, 90.00, 191.00);

    Room room1 = new Room("Entrance");
    Room room2 = new Room("Lion's enclosure");
    Room room3 = new Room("Eagle's cage");
    Room room4 = new Room("Garden");
    Room room5 = new Room("Tiger jungle");
    Room room6 = new Room("Rest room");
    Room room7 = new Room("Bathroom");

    public TextGame() {

        scanner = new Scanner(System.in);
        System.out.println("Welcome to Pawtropolis!\nEnter your player name: ");
        String playerNAme = scanner.nextLine();
        gameController = new GameController(new Player(playerNAme, MAX_LIFE_POINTS, room1), new Bag(new ArrayList<>(), Bag.SPACE_BAG));

        //gestire l'inserimento del nome del player dall'utente

        gameController.addItemInRoom(item1, room1 );
        gameController.addAnimalInRoom(animal1, room2);
        gameController.addItemInRoom(item3, room2);
        gameController.addAnimalInRoom(animal3, room2);
        gameController.addAnimalInRoom(animal2, room3);
        gameController.addAnimalInRoom(animal5, room3);
        gameController.addItemInRoom(item4, room4);
        gameController.addItemInRoom(item6, room4);
        gameController.addItemInRoom(item2, room5);
        gameController.addAnimalInRoom(animal4, room5);
        gameController.addItemInRoom(item5, room6);

        room1.addAdjoiningRoom(Direction.NORTH, room2);
        room1.addAdjoiningRoom(Direction.SOUTH, room3);
        room1.addAdjoiningRoom(Direction.EAST, room6);
        room2.addAdjoiningRoom(Direction.SOUTH, room1);
        room3.addAdjoiningRoom(Direction.NORTH, room1);
        room3.addAdjoiningRoom(Direction.WEST, room4);
        room3.addAdjoiningRoom(Direction.EAST, room5);
        room4.addAdjoiningRoom(Direction.EAST,room3);
        room5.addAdjoiningRoom(Direction.WEST,room3);
        room5.addAdjoiningRoom(Direction.NORTH, room6);
        room6.addAdjoiningRoom(Direction.WEST,room1);
        room6.addAdjoiningRoom(Direction.SOUTH,room5);
        room6.addAdjoiningRoom(Direction.NORTH, room7);
        room7.addAdjoiningRoom(Direction.SOUTH, room6);


        gameController.getRooms().add(room1);
        gameController.getRooms().add(room2);
        gameController.getRooms().add(room3);
        gameController.getRooms().add(room4);
        gameController.getRooms().add(room5);
        gameController.getRooms().add(room6);
        gameController.getRooms().add(room7);



    }




    boolean gameRunning = true;

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public void start() {
        System.out.println("\nHello " + gameController.getPlayer().getName()+ "! " + "Please enter 'help' to view the available commands");

        while (gameRunning) {
            System.out.print("\n> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("help")) {
                printHelp();
            } else if (input.equalsIgnoreCase("look")) {
                look();
            } else if (input.equalsIgnoreCase("go")) {
                go();
            } else if (input.equalsIgnoreCase("get")) {
                add();
            } else if (input.equalsIgnoreCase("drop")) {
                drop();
            } else if (input.equalsIgnoreCase("showBag")) {
                showBag();
            } else if (input.equalsIgnoreCase("quit")) {
                System.out.println("See you next time!");
                setGameRunning(false);
            } else {
                System.out.println("Invalid command. Enter 'help' to view the available commands.");
            }
        }
    }

    private void printHelp() {
        System.out.println("Available command:");
        System.out.println("- help: displays the list of command");
        System.out.println("- look: examine the current room");
        System.out.println("- go: choose a direction to change room (north, south, east, west)");
        System.out.println("- get: pick up the select item and add it to the bag ");
        System.out.println("- drop: take the item out of the bag and leave it in the room");
        System.out.println("- showBag: displays the items in your bag ");
        System.out.println("- quit: quit the game");
    }

    private void look() {
        GameCommand lookCommand = new LookCommand(gameController);
        lookCommand.execute();
    }

    private void go() {


        System.out.print("Enter a direction : (north, south, east, west): ");
        String input = scanner.nextLine();

        Direction direction;
        if (input.equalsIgnoreCase("north")) {
            direction = Direction.NORTH;
        } else if (input.equalsIgnoreCase("south")) {
            direction = Direction.SOUTH;
        } else if (input.equalsIgnoreCase("east")) {
            direction = Direction.EAST;
        } else if (input.equalsIgnoreCase("west")) {
            direction = Direction.WEST;
        } else {
            System.out.println("Invalid direction.");
            return;
        }

        GameCommand goCommand = new GoCommand(gameController, direction);
        goCommand.execute();
    }

    private void add() {
       List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

            GameCommand addCommand = new AddCommand(gameController, itemList);
            addCommand.execute();


    }

    private void drop() {
        List<Item> items = gameController.getBag().getItems();

            GameCommand dropCommand = new DropCommand(gameController, items);
            dropCommand.execute();
        }


    private void showBag() {
        GameCommand showBagCommand = new ShowBagCommand(gameController);
        showBagCommand.execute();
    }

}