package model;

import zoo.Animal;

import java.util.*;

public class GameController {

    private List<Item> items;
    private List<Animal> animals;
    private List<Room> rooms;
    private Player player;
    private Bag bag;


    public GameController(Player player, Bag bag) {   //i set non dovrebbero servirmi...
        this.items = new ArrayList <>();
        this.animals = new ArrayList<>();
        this.rooms = new ArrayList <>();
        this.player = player;
        this.bag = bag;

    }

    public List <Item> getItems(Room room) {
        /*Room currentRoom = getPlayer().getCurrentRoom();
        return currentRoom.getItemsInRoom(currentRoom);*/
      //  return getPlayer().getCurrentRoom().getItemsInRoom();
        return room.getItemsInRoom();
    }

    public List<Animal> getAnimals(Room room) {
        /*Room currentRoom = getPlayer().getCurrentRoom();
        return currentRoom.getAnimalsInRoom(currentRoom);*/
       // return getPlayer().getCurrentRoom().getAnimalsInRoom();
        return room.getAnimalsInRoom();

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void removeRoom(Room room) {
       /* // Itera sulle stanze per trovare quella da rimuovere
        for (Room currentRoom : rooms) {
            if (rooms.equals(room)) {
                // Rimuovi la stanza dalle stanze adiacenti delle altre stanze
                for (Room adjoiningRoom : rooms.getDirectionRoom().values()) {
                    adjoiningRoom.getAdjoiningRooms().remove(, rooms));
                }

                // Rimuovi la stanza dall'elenco delle stanze
                rooms.remove(currentRoom);
                break;
            }
        }*/
        // Rimuovi la stanza dalle stanze adiacenti delle altre stanze
        for (Room currentRoom : rooms) {
            Map<Direction, Room> adjoiningRooms = currentRoom.getAdjoiningRooms();
            adjoiningRooms.values().remove(room);
        }

        // Rimuovi la stanza dall'elenco delle stanze
        rooms.remove(room);

    }

    public void addItemInRoom (Item items, Room room){
       // room.addItem(items);
        Room currentRoom = getPlayer().getCurrentRoom();
        if (currentRoom.equals(room)) {
            currentRoom.addItem(items);
        }
    }



    public void removeItemFromRoom (Item item) {
        items.remove(item);
    }

    public void addAnimalInRoom (Animal animal, Room room){
       // animals.add(animal);
        Room currentRoom = getPlayer().getCurrentRoom();
        if (currentRoom.equals(room)) {
            currentRoom.addAnimal(animal);
        }
    }

    public void go(Direction direction) {

        Room currentRoom =  getPlayer().getCurrentRoom();
        Room nextRoom = currentRoom.getDirectionRoom(direction);
        if (nextRoom != null) {
            getPlayer().setCurrentRoom(nextRoom);
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
