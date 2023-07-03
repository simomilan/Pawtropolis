package controller;

import model.Direction;
import model.Item;
import model.Room;
import zoo.Animal;
import zoo.Eagle;
import zoo.Lion;
import zoo.Tiger;

import java.time.LocalDate;

public class MapController {

    private Room currentRoom;

    public MapController() {
        this.currentRoom = createMap();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    private static Room createMap() {
        Room room1 = new Room("Entrance");
        Room room2 = new Room("Lion's enclosure");
        Room room3 = new Room("Eagle's cage");
        Room room4 = new Room("Garden");
        Room room5 = new Room("Tiger jungle");
        Room room6 = new Room("Rest room");
        Room room7 = new Room("Bathroom");

        room1.addAdjoiningRoom(Direction.NORTH, room2);
        room1.addAdjoiningRoom(Direction.SOUTH, room3);
        room1.addAdjoiningRoom(Direction.EAST, room6);
        room3.addAdjoiningRoom(Direction.WEST, room4);
        room3.addAdjoiningRoom(Direction.EAST, room5);
        room5.addAdjoiningRoom(Direction.NORTH, room6);
        room6.addAdjoiningRoom(Direction.NORTH, room7);


        Item item1 = new Item("collar", "studded collar", 1);
        Item item2 = new Item("bone", "a human femur", 3);
        Item item3 = new Item("whip", "leather whip", 1);
        Item item4 = new Item("meat", "sheep", 4);
        Item item5 = new Item("dildo", "anal plug", 2);
        Item item6 = new Item("muzzle", "anti-bark", 2);


        LocalDate l1 = LocalDate.of(2020, 1, 1);
        Animal animal1 = new Lion("Simba", "Meat", 4, l1, 320.00, 120.00, 90.00);
        LocalDate t1 = LocalDate.of(2021, 4, 2);
        Animal animal2 = new Eagle("Gatto", "Meat", 3, t1, 288.00, 116.00, 100.00);
        LocalDate l3 = LocalDate.of(2017, 3, 3);
        Animal animal3 = new Lion("Gio", "Meat", 7, l3, 325.00, 122.00, 94.00);
        LocalDate t2 = LocalDate.of(2019, 9, 10);
        Animal animal4 = new Tiger("Gino", "Meat", 6, t2, 301.00, 123.00, 102.00);
        LocalDate e2 = LocalDate.of(2018, 3, 12);
        Animal animal5 = new Eagle("Titti", "Meat", 5, e2, 75.00, 90.00, 191.00);


        room1.addItem(item1);
        room2.addAnimal(animal1);
        room2.addItem(item3);
        room2.addAnimal(animal3);
        room3.addAnimal(animal2);
        room3.addAnimal(animal5);
        room4.addItem(item4);
        room5.addItem(item2);
        room5.addAnimal(animal4);
        room6.addItem(item5);
        room6.addItem(item6);


        return room1;
    }


}

