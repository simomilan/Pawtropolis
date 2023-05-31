package model;

import zoo.Animal;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    /*private List<Item> items;
    private List<Animal> animals;
    private List<Room> rooms; */
    private Player player;
   /* private Room room; //AGGIUNT

    public Room getRoom () { ////////////
        return getPlayer().getCurrentRoom();
    }

    public void setRoom (Room room) {///////////////
        this.room = room;
    }*/

    public GameController() {   //i set non dovrebbero servirmi...
       /* items = new ArrayList <>();
        animals = new ArrayList<>();
        rooms = new ArrayList<>();*/
        player = null;
    }

    /*public List <Item> getItems() {
        return items;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Room> getRooms() {
        return rooms;
    }*/

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

   /* public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

   /* public void addItemInRoom (Item item){
        items.add(item);
    }

    public void removeItemFromRoom (Item item) {
        items.remove(item);
    }

    public void addAnimalInRoom (Animal animal){
        animals.add(animal);
    }*/

}
