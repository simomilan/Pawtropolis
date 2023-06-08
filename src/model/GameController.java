package model;

import zoo.Animal;

import java.util.*;

public class GameController {

    private List<Room> rooms;
    private Player player;
    private Bag bag;



    public GameController(Player player, Bag bag) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        this.rooms = new ArrayList <>();
        this.player = player;
        this.bag = bag;

    }


    public List <Item> getItems(Room room) {
        return room.getItemsInRoom();
    }

    public List<Animal> getAnimals(Room room) {
        return room.getAnimalsInRoom();

    }


    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
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


    public void removeRoom(Room room) {
        // Rimuovi la stanza dalle stanze adiacenti delle altre stanze
        for (Room currentRoom : rooms) {
            Map<Direction, Room> adjoiningRooms = currentRoom.getAdjoiningRooms();
            adjoiningRooms.values().remove(room);
        }
        // Rimuovi la stanza dall'elenco delle stanze
        rooms.remove(room);

    }

    public void removeItemFromRoom(Item item, Room room) {
        bag = getBag();
        if (bag.getItems().contains(item)) {
            room.removeItem(item);
        }
    }

    public void addItemInRoom(Item item, Room room) {
        room.addItem(item);  // Aggiungi direttamente l'oggetto alla stanza specificata
    }


    public void addAnimalInRoom(Animal animal, Room room) {
        room.addAnimal(animal);  // Aggiungi direttamente l'oggetto alla stanza specificata
    }


    public void addItemToBag(Item item){
        int availableSpace = bag.getAvailableSpace();
        if(bag.getAvailableSpace() -item.getSpaceBagUsed() >= 0){
            bag.addItemsInBag(item);
            availableSpace -= item.getSpaceBagUsed();
            bag.setAvailableSpace(availableSpace);

        } else {
            System.out.println("You haven't enough space in your bag so u can't add it. Please first drop something!");
        }
    }

    public void dropItemFromBag(Item item) {
        bag = getBag();
        List<Item> items = bag.getItems();

        if (items.contains(item)) {
            items.remove(item);
            int availableSpace = bag.getAvailableSpace() + item.getSpaceBagUsed();
            bag.setAvailableSpace(availableSpace);
            System.out.println("The item has been dropped from the bag: " + item.getNameItem());

            // Aggiungi l'oggetto alla stanza corrente
            Room currentRoom = player.getCurrentRoom();
            currentRoom.addItem(item);
            System.out.println("The item has been added to the current room: " + item.getNameItem());
        } else {
            System.out.println("Item not found in the bag: " + item.getNameItem());
        }
    }


    public void showBag() {
        bag = getBag();
        List<Item> items = bag.getItems();

        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");
        } else {
            System.out.print("\nIn bag: ");
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getNameItem());
                if (i < items.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

}
