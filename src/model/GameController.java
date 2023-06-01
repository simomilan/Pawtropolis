package model;

import zoo.Animal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameController {

    private List<Item> items;
    private List<Animal> animals;
    private Room currentRoom;
    private Player player;
    private Bag bag;



    public GameController(Player player, Bag bag, Room currentRoom) {   //i set non dovrebbero servirmi...
        items = new ArrayList <>();
        animals = new ArrayList<>();
        this.currentRoom = currentRoom;
        this.player = player;
        this.bag = bag;
    }

    public List <Item> getItems() {
        return items;
    }

    public List<Animal> getAnimals() {
        return animals;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Bag getBag () {
        return bag;
    }

    public void setBag (Bag bag) {
        this.bag = bag;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
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
    }*/

    public void addRoom() {
        currentRoom.getCurrentRoom();
    }

    public void removeRoom(Room room) {
        // Itera sulle stanze per trovare quella da rimuovere
        for (Room currentRoom : rooms) {
            if (currentRoom.equals(room)) {
                // Rimuovi la stanza dalle stanze adiacenti delle altre stanze
                for (Room adjoiningRoom : currentRoom.getAdjoiningRooms().values()) {
                    adjoiningRoom.getAdjoiningRooms().remove(getDirectionForAdjoiningRoom(adjoiningRoom, currentRoom));
                }

                // Rimuovi la stanza dall'elenco delle stanze
                rooms.remove(currentRoom);
                break;
            }
        }
    }

    public void addItemInRoom (Item item){
        items.add(item);
    }

    public void removeItemFromRoom (Item item) {
        items.remove(item);
    }

    public void addAnimalInRoom (Animal animal){
        animals.add(animal);
    }

    public void go(Direction direction) {
        Room nextRoom = currentRoom.getAdjoiningRoom(direction);
        if (nextRoom != null) {
            setCurrentRoom(nextRoom);
            System.out.println("You moved to the " + direction + ".");
            System.out.println("Current room: " + nextRoom.getNameRoom());
        } else {
            System.out.println("There is no room in that direction.");
        }
    }

    public void addItemToBag(Item item){
        int availableSpace = bag.getAvailableSpace();   //conytrollo se la boesa è piena
        if(bag.getAvailableSpace() -item.getSpaceBagUsed() >= 0){
            bag.addItemsInBag(item);
            availableSpace -= item.getSpaceBagUsed();
            bag.setAvailableSpace(availableSpace);
            System.out.println("The item has been added to the bag: " + item.getNameItem());

        } else {
            System.out.println("You haven't enough space in your bag so u can't add it. Please first drop something!");
        }
    }

    public void dropItemFromBag(Item item) {

        List<Item> items = bag.getItems();
        if (items.contains(item)) {
            items.remove(item);
            int availableSpace = bag.getAvailableSpace() + item.getSpaceBagUsed();
            bag.setAvailableSpace(availableSpace);
            System.out.println("The item has been dropped from the bag: " + item.getNameItem());
        } else {
            System.out.println("Item not found in the bag: " + item.getNameItem());
        }
    }

    public List<Item>  showBag(){   //condizione se è empty,
        if (items.isEmpty()) {
            System.out.println("Your bag is empty");
        } else {
            System.out.println("The Items in yours bag are : " + items); //fare in modo che in console esca la frase pulita pulita
        }
        return items;

    }

        }
