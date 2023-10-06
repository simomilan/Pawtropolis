package pawtropolis.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pawtropolis.model.Direction;
import pawtropolis.model.Item;
import pawtropolis.model.Room;
import pawtropolis.zoo.*;


import java.time.LocalDate;

@Getter
@Setter
@Component
public class MapController {

    private Room currentRoom;

    public MapController() {
        this.currentRoom = createMap();
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
        Item item5 = new Item("flashlight", "can be helpfully", 2);
        Item item6 = new Item("muzzle", "anti-bark", 1);


        Animal animal1 = new Lion("Simba", "Meat", 4, LocalDate.of(2020, 1, 1), 320.00, 120.00, 90.00);
        Animal animal2 = new Eagle("Gatto", "Meat", 3, LocalDate.of(2021, 4, 2), 288.00, 116.00, 100.00);
        Animal animal3 = new Lion("Gio", "Meat", 7, LocalDate.of(2017, 3, 3), 325.00, 122.00, 94.00);
        Animal animal4 = new Tiger("Gino", "Meat", 6, LocalDate.of(2019, 9, 10), 301.00, 123.00, 102.00);
        Animal animal5 = new Eagle("Titti", "Meat", 5, LocalDate.of(2018, 3, 12), 75.00, 90.00, 191.00);

        Animal animal6 = Lion.lionBuilder()
                .nickname("cazzo")
                .favoriteFood("fregna")
                .age(10)
                .entryDate(LocalDate.of(2020, 1, 1))
                .weight(400)
                .height(110)
                .tailLength(105)
                .build();

        Animal animal7 = Eagle.eagleBuilder()
                .nickname("Alato")
                .favoriteFood("Insetti")
                .age(5)
                .entryDate(LocalDate.now())
                .weight(2.5)
                .height(30.0)
                .wingspan(50.0)
                .build();


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
        room1.addAnimal(animal6);
        room1.addAnimal(animal7);


        return room1;
    }


}

