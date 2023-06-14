
package model;

import zoo.Animal;

import java.util.List;

public class Player {

    public static final int MAX_LIFE_POINTS = 100;
    public static final int MIN_LIFE_POINTS = 0;

    private String name;
    private int lifePoints;
    private Bag bag;

    public Player(String name, int lifePoints, Bag bag) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = bag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        if (lifePoints > MAX_LIFE_POINTS) {
            this.lifePoints = MAX_LIFE_POINTS;
        } else if (lifePoints < MIN_LIFE_POINTS) {
            this.lifePoints = MIN_LIFE_POINTS;
        } else {
            this.lifePoints = lifePoints;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name +
                ", lifePoints=" + lifePoints +
                '}';
    }

    /////GESTIONE BAG DAL PLAYER


    public void addItemToBag(Item item) {
        int availableSpace = bag.getAvailableSpace();
        if (bag.getAvailableSpace() - item.getSpaceBagUsed() >= 0) {
            bag.addItemsInBag(item);
            availableSpace -= item.getSpaceBagUsed();
            bag.setAvailableSpace(availableSpace);
        } else {
            System.out.println("You haven't enough space in your bag, so you can't add it. Please drop something first!");
        }
    }

    public void dropItemFromBag(Item item, Room currentRoom) {
        bag = getBag();
        List<Item> items = bag.getItems();

        if (items.contains(item)) {
            items.remove(item);
            int availableSpace = bag.getAvailableSpace() + item.getSpaceBagUsed();
            bag.setAvailableSpace(availableSpace);
            System.out.println("\nThe item has been dropped from the bag: " + item.getNameItem());

            // Aggiungi l'oggetto alla stanza corrente
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
        int remainingSpace = bag.getAvailableSpace();
        System.out.println("Remaining space in bag: " + remainingSpace);
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}

