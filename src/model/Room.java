package model;

import zoo.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;  //mappare e metterci dentro le cose e poi se è randomizzarla
import java.util.Map;
public class Room {  //manca il toString

    private String nameRoom;
    private List <Item> itemsInRoom;
    private List<Animal> animalsInRoom;
    private Map <Direction, Room> adjoiningRooms;



    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public List<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public void setItemsInRoom(List<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }


    public Map<Direction, Room> getAdjoiningRooms() {
        return adjoiningRooms;
    }

    public void setAdjoiningRooms (Map <Direction, Room> adjoiningRooms) {
        this.adjoiningRooms = adjoiningRooms;
    }

    public List <Animal> getAnimalsInRoom () {
        return animalsInRoom;
    }

    public void setAnimalsInRoom (List <Animal> animalsInRoom) {
        this.animalsInRoom = animalsInRoom;
    }

    public Room(String nameRoom /*, List<Item> itemsInRoom, List<Animal> animalsInRoom, List<Room> adjoiningRooms, Room currentRoom*/)  {
        this.nameRoom = nameRoom;
        this.itemsInRoom = new ArrayList<>();
        this.animalsInRoom = new ArrayList<>();
        this.adjoiningRooms = new HashMap <>();

    }

    @Override
    public String toString() {
        return "Room{" +
                "nameRoom='" + nameRoom + '\'' +
               /* ", items=" + items +
                ", animalsInRoom=" + animalsInRoom +*/
                ", adjoiningRooms=" + adjoiningRooms +
                '}';
    }

    public void addAdjoiningRoom( Direction direction, Room room) {  //aggiunge la stanza alla lista
        adjoiningRooms.put(direction, room);
    }

    public Room getAdjoiningRoom (Direction direction) {
        return adjoiningRooms.get(direction);
    }



    public void addItemInRoom (Item item){
        itemsInRoom.add(item);
    }

    public void removeItemFromRoom (Item item) {
        itemsInRoom.remove(item);
    }

    public void addAnimalInRoom (Animal animal){
        animalsInRoom.add(animal);
    }


   /* public String look() {  //fyunziona ma non ci piace!
        System.out.println("Current room: " + getNameRoom());
        if (items.isEmpty()){
            System.out.println("No items in the room");
        } else {
            System.out.println("In the room there's the following items: " + getItemsInRoom());
        }
        if (animalsInRoom.isEmpty()){
            System.out.println("No animals in the room");
        } else {
                System.out.println("In the room there's the following animals: " + getAnimalsInRoom());
            }

        return toString();
    }*/

}
