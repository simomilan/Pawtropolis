package model;

import command.*;
import console.TextGame;
import model.Bag;
import model.Direction;
import model.Item;
import zoo.Animal;
import zoo.Eagle;
import zoo.Lion;
import zoo.Tiger;

import java.time.LocalDate;
import java.util.*;


public class Main {


    public static void main(String[] args) {


     /*   // Creazione degli oggetti
        Item item1 = new Item("Item 1", "osso", 1);
        Item item2 = new Item("Item 2", "croccantino", 3);
        Item item3 = new Item("Item 3", "collare", 1);

        // Creazione degli animali
        LocalDate l1 = LocalDate.of(2020, 1, 1);
        Animal animal1 = new Lion( "Simba", "Meat", 4, l1, 320.00, 120.00, 90.00);
        LocalDate t1 = LocalDate.of(2021, 4, 2);
        Animal animal2 = new Eagle("Gatto", "Meat", 3, t1, 288.00, 116.00, 100.00);

        // Creazione delle stanze
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");



        // Creazione del giocatore
        Bag bag = new Bag(new ArrayList<>(), Bag.SPACE_BAG);
        Player player = new Player("Player 1", 100, null);

        // Creazione del GameController
        GameController gameController = new GameController(player, bag);

       // gameController.setPlayer(player);

        // imposto il player nella stanza iniziale
        gameController.getPlayer().setCurrentRoom(room1);



        // Collegamento delle stanze
        room1.addAdjoiningRoom(Direction.North, room2);
        room1.addAdjoiningRoom(Direction.South, room3);
        room2.addAdjoiningRoom(Direction.South, room1);
        room3.addAdjoiningRoom(Direction.North, room1);






        // Aggiunta degli oggetti e degli animali alle stanze
        gameController.addItemInRoom(item1, room1);
        gameController.addAnimalInRoom(animal1, room1);
        gameController.addItemInRoom(item2, room2);
        gameController.addItemInRoom(item3, room2);
        gameController.addAnimalInRoom(animal2, room2);




        // Aggiunta delle stanze al GameController
        gameController.getRooms().add(room1);
        gameController.getRooms().add(room2);
        gameController.getRooms().add(room3);



        // Creazione dei comandi
        GameCommand lookCommand = new LookCommand(gameController);
        GameCommand goCommand = new GoCommand(gameController, Direction.North);
        GameCommand addCommand = new AddCommand(gameController, item2);
        GameCommand dropCommand = new DropCommand(gameController, item2);
        GameCommand showBagCommand = new ShowBagCommand(gameController);*/

       /* // Esecuzione dei comandi
        lookCommand.execute(); // Esegue il comando "look" per visualizzare la stanza corrente
        goCommand.execute(); // Esegue il comando "go" per spostarsi nella stanza ad est
        lookCommand.execute(); // Esegue nuovamente il comando "look" per visualizzare la nuova stanza corrente
        addCommand.execute(); // Esegue il comando "add" per aggiungere l'oggetto alla borsa del giocatore
        lookCommand.execute(); // Esegue nuovamente il comando "look" per visualizzare gli oggetti nella stanza corrente DOVREBBE RESTITUIRMI LA STANZA VUOTA
        dropCommand.execute(); // Esegue il comando "drop" per droppare l'oggetto dalla borsa del giocatore
        lookCommand.execute(); // Esegue nuovamente il comando "look" per visualizzare gli oggetti nella stanza corrente
        showBagCommand.execute();*/


                TextGame game = new TextGame();
                game.start();
            }
        }


