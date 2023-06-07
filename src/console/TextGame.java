package console;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import command.*;
import model.*;
import zoo.*;

public class TextGame {

        private GameController gameController;
        private Scanner scanner;

    // Creazione degli oggetti
    Item item1 = new Item("Item 1", "osso", 1);
    Item item2 = new Item("Item 2", "croccantino", 3);
    Item item3 = new Item("Item 3", "collare", 1);

    List<Item> itemList = new ArrayList<>();
            itemList.add(item1);
            itemList.add(item2);
            itemList.add(item3);


    // Creazione degli animali
    LocalDate l1 = LocalDate.of(2020, 1, 1);
    Animal animal1 = new Lion( "Simba", "Meat", 4, l1, 320.00, 120.00, 90.00);
    LocalDate t1 = LocalDate.of(2021, 4, 2);
    Animal animal2 = new Eagle("Gatto", "Meat", 3, t1, 288.00, 116.00, 100.00);

    // Creazione delle stanze
    Room room1 = new Room("Room 1");
    Room room2 = new Room("Room 2");
    Room room3 = new Room("Room 3");


    public TextGame() {
            gameController = new GameController(new Player("player1", 100, room1), new Bag(new ArrayList <>(), Bag.SPACE_BAG));
            scanner = new Scanner(System.in);

            //gestire l'inserimento del nome del player dall'utente

        // Aggiunta degli oggetti e degli animali alle stanze
        gameController.addItemInRoom(item1, room1);
        gameController.addAnimalInRoom(animal1, room1);
        gameController.addItemInRoom(item2, room2);
        gameController.addItemInRoom(item3, room2);
        gameController.addAnimalInRoom(animal2, room2);
        }



    public void start() {
            System.out.println("Benvenuto nel gioco! Inserisci 'help' per visualizzare i comandi disponibili.");

        boolean gameRunning = true;


        while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("help")) {
                    printHelp();
                } else if (input.equalsIgnoreCase("look")) {
                    look();
                } else if (input.equalsIgnoreCase("go")) {
                    go();
                } else if (input.equalsIgnoreCase("add")) {
                    add();
                } else if (input.equalsIgnoreCase("drop")) {
                    drop();
                } else if (input.equalsIgnoreCase("bag")) {
                    showBag();
                } else if (input.equalsIgnoreCase("quit")) {
                    System.out.println("Grazie per aver giocato! Arrivederci.");
                    gameRunning = false;
                } else {
                    System.out.println("Comando non valido. Inserisci 'help' per visualizzare i comandi disponibili.");
                }
            }
        }

        private void printHelp() {
            System.out.println("Comandi disponibili:");
            System.out.println("- help: visualizza l'elenco dei comandi");
            System.out.println("- look: esamina la stanza corrente");
            System.out.println("- go: spostati in una direzione (nord, sud, est, ovest)");
            System.out.println("- add: aggiungi un oggetto al sacchetto");
            System.out.println("- drop: droppa un oggetto dal sacchetto");
            System.out.println("- bag: visualizza il contenuto del sacchetto");
            System.out.println("- quit: esci dal gioco");
        }

        private void look() {


            GameCommand lookCommand = new LookCommand(gameController);
            lookCommand.execute();
        }

        private void go() {

            room1.addAdjoiningRoom(Direction.North, room2);
            room1.addAdjoiningRoom(Direction.South, room3);
            room2.addAdjoiningRoom(Direction.South, room1);
            room3.addAdjoiningRoom(Direction.North, room1);

            // Aggiunta delle stanze al GameController
            gameController.getRooms().add(room1);
            gameController.getRooms().add(room2);
            gameController.getRooms().add(room3);

            System.out.print("Inserisci una direzione (nord, sud, est, ovest): ");
            String input = scanner.nextLine();

            Direction direction;
            if (input.equalsIgnoreCase("nord")) {
                direction = Direction.North;
            } else if (input.equalsIgnoreCase("sud")) {
                direction = Direction.South;
            } else if (input.equalsIgnoreCase("est")) {
                direction = Direction.East;
            } else if (input.equalsIgnoreCase("ovest")) {
                direction = Direction.West;
            } else {
                System.out.println("Direzione non valida.");
                return;
            }

            GameCommand goCommand = new GoCommand(gameController, direction);
            goCommand.execute();
        }

        private void add() {
            List<Item> item = new ArrayList<>();
            itemList.add(item1);
            itemList.add(item2);
            itemList.add(item3);

            GameCommand addCommand = new AddCommand(gameController, (Item) item);
            addCommand.execute();

        }


        private void drop() {
            List<Item> item = new ArrayList<>();
            itemList.add(item1);
            itemList.add(item2);
            itemList.add(item3);
            System.out.print("Inserisci il nome dell'oggetto da droppare: ");
            String itemName = scanner.nextLine();  //il problema è che non è una stringa ma un Item

            GameCommand dropCommand = new DropCommand(gameController, (Item) item);
            dropCommand.execute();
        }

    private void showBag() {
        GameCommand showBagCommand = new ShowBagCommand(gameController);
        showBagCommand.execute();
    }


}