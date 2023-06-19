package model;

import zoo.Animal;

import java.util.*;

public class Room {

    private String nameRoom;
    private List <Item> itemsInRoom;
    private List<Animal> animalsInRoom;
    private Map <Direction, Room> adjoiningRooms;



    public String getNameRoom() {
        return nameRoom;
    }


    public List <Item> getItemsInRoom () {
        return itemsInRoom;
    }


    public List <Animal> getAnimalsInRoom () {
        return animalsInRoom;
    }

    public Room(String nameRoom)  {
        this.nameRoom = nameRoom;
        this.itemsInRoom = new ArrayList<>();
        this.animalsInRoom = new ArrayList<>();
        this.adjoiningRooms = new EnumMap <>(Direction.class);

    }

    @Override
    public String toString() {
        return "Room{" +
                "nameRoom='" + nameRoom + '\'' +
                ", adjoiningRooms=" + adjoiningRooms +
                '}';
    }

    public void addAdjoiningRoom( Direction direction, Room room) {  //aggiunge la stanza alla lista
        adjoiningRooms.put(direction, room);
    }

    public Room getDirectionRoom (Direction direction) {
        return adjoiningRooms.get(direction);
    }



    public void addItem (Item item){
        itemsInRoom.add(item);
    }

    public void addAnimal (Animal animal){
        animalsInRoom.add(animal);
    }

    public void removeAnimal (Animal animal) {
        itemsInRoom.remove(animal);
    }


    public void removeItem (Item item) {
        itemsInRoom.remove(item);
    }


}
