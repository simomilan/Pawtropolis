package model;

import command.*;
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

        /*Scanner console = new Scanner(System.in);


        List<Item> items = new ArrayList<>();
        Item collare = new Item("collare", "nanan", 2);
        Item croccantino = new Item("croccantino", "nananaaa", 2);
        Item osso = new Item( "osso", "di pecora", 2);

        //se si aggiunge uno slot used >> di SPACE_BAG non verrà aggiunto alla lista
        Bag bag = new Bag(items, Bag.SPACE_BAG);

        bag.addItemsInBag(collare);
        bag.addItemsInBag(croccantino);

        System.out.println("OGGETTO AGGIUNTO" + bag);

        bag.dropItemsFromBag(collare);
        bag.dropItemsFromBag(croccantino);
        System.out.println("OGGETTi rimanenti " + bag);

        //creo gli animali
        LocalDate e1 = LocalDate.of(2022, 7,19);
        Animal a1= new Eagle("pippo",  "Meat", 1, e1, 40.00, 50.00, 130.00 );
        LocalDate t2 = LocalDate.of(2019,9,10);
        Animal a2 = new Tiger("Gino", "Meat", 6, t2, 301.00, 123.00, 102.00);


        //creo le stanze
        Room room1 = new Room("Cucina");
        Room room2 = new Room("cesso");

        //creazione del giocatore

        Player player1 = new Player("Simo", 100, bag, room1);

        player1.setBag(bag);  //coolego il player co la bag

        System.out.println(player1);


        //aggiungo le stanze adiacenti
        room1.addAdjoiningRoom(Direction.North, room2); //sto in cucina e vado al cesso
        room2.addAdjoiningRoom(Direction.South, room1); //sto al cesso e vado in cucina

        //aggiungo gli item alla stanza
        room1.addItemInRoom(collare);
        room2.addItemInRoom(croccantino);
        room1.addItemInRoom(croccantino);
        room1.addItemInRoom(osso);

        //aggiungo gli animali alla stanza
        room1.addAnimalInRoom(a1);
        room2.addAnimalInRoom(a2);

        //il player nella room1 aggiunge quello che trova
        player1.addItemToBag(croccantino);
        player1.addItemToBag(collare);
        player1.addItemToBag(osso);

        System.out.println("Prova metodo showBag: " +player1.showBagg()); //sistemare il nome del metodo

        //provo a togliere un item( es collare) così poi posso prendere osso
        player1.dropItemFromBag(collare);
        System.out.println(" la borsa dopo aver droppato collare: " +player1.showBagg());
        player1.addItemToBag(osso);
        System.out.println(" la borsa dopo ave droppato collare e aggiunto osso: " +player1.showBagg());


        //giocatore che si muove
        player1.go(Direction.East);
        System.out.println("Stanza corrente: " + player1.getCurrentRoom().getNameRoom());
        System.out.println("Stanza :" + room1.getAdjoiningRoom(Direction.North).getNameRoom());

        //metodo look

        System.out.println(room1.look());
        System.out.println(room2.look()); */

        // Creazione delle stanze
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");

        // Collegamento delle stanze
        room1.addAdjoiningRoom(Direction.North, room2);
        room2.addAdjoiningRoom(Direction.South, room1);
        room2.addAdjoiningRoom(Direction.East, room3);
        room3.addAdjoiningRoom(Direction.West, room2);

        // Creazione degli oggetti
        Item item1 = new Item("Item 1", "osso", 1);
        Item item2 = new Item("Item 2", "croccantino", 3);
        Item item3 = new Item("Item 3", "collare", 1);

        // Creazione degli animali
        LocalDate l1 = LocalDate.of(2020, 1, 1);
        Animal animal1 = new Lion( "Simba", "Meat", 4, l1, 320.00, 120.00, 90.00);
        LocalDate t1 = LocalDate.of(2021, 4, 2);
        Animal animal2 = new Eagle("Gatto", "Meat", 3, t1, 288.00, 116.00, 100.00);

        // Creazione del giocatore
        Bag bag = new Bag(new ArrayList<>(), Bag.SPACE_BAG);
        Player player = new Player("Player 1", 100);
        //gameController.setPlayer(player);

        // Creazione del GameController
        GameController gameController = new GameController(player, bag, room1);
        // Aggiunta degli oggetti e degli animali alle stanze
        gameController.addItemInRoom(item1);
        gameController.addAnimalInRoom(animal1);
        gameController.addItemInRoom(item2);
        gameController.addItemInRoom(item3);
        gameController.addAnimalInRoom(animal2);




        // Aggiunta delle stanze al GameController
        gameController.addRoom(room1);
        gameController.addRoom(room2);
        gameController.addRoom(room3);



      /*  // Creazione del giocatore
        Bag bag = new Bag(new ArrayList<>(), Bag.SPACE_BAG);
        Player player = new Player("Player 1", 100, bag, room1);
        gameController.setPlayer(player);*/

        // Creazione dei comandi
        GameCommand lookCommand = new LookCommand(gameController);
        GameCommand goCommand = new GoCommand(gameController, Direction.North);
        GameCommand addCommand = new AddCommand(gameController, item2);
        GameCommand dropCommand = new DropCommand(gameController, item2);

        // Esecuzione dei comandi
        lookCommand.execute(); // Esegue il comando "look" per visualizzare la stanza corrente
        goCommand.execute(); // Esegue il comando "go" per spostarsi nella stanza ad est
        lookCommand.execute(); // Esegue nuovamente il comando "look" per visualizzare la nuova stanza corrente
        addCommand.execute(); // Esegue il comando "add" per aggiungere l'oggetto alla borsa del giocatore
        lookCommand.execute(); // Esegue nuovamente il comando "look" per visualizzare gli oggetti nella stanza corrente DOVREBBE RESTITUIRMI LA STANZA VUOTA
        dropCommand.execute(); // Esegue il comando "drop" per droppare l'oggetto dalla borsa del giocatore
        lookCommand.execute(); // Esegue nuovamente il comando "look" per visualizzare gli oggetti nella stanza corrente

    }
}

