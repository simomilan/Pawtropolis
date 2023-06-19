
package model;

import exception.InsufficientSpaceException;

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

    //Il player non deve sapere che esistono le stanze, sa solo che ha una bag con degli item dentro, ma non sa come funziona
    // cioè come la bag gestisce gli item
    //il player prende qualcosa(di generico, non sa nemmeno se un item) --> take
    // il player da qualcosa (es giveItemByname), non so se in player fare il metodo take e give generico e implementarli nel gameController
    // del tipo il player prende e da , m cosa??!!, in gamecontroller potrei avere GiveItem....


    /*public void takeItemByName(Item item) throws InsufficientSpaceException {
        if (bag.getAvailableSpace() - item.requiredSpace() >= 0) {
            bag.addItemsInBag(item);
            bag.setAvailableSpace(bag.getAvailableSpace() - item.requiredSpace());
        } else {
            System.out.println("You haven't enough space in your bag, so you can't add it. Please drop something first!");
        }
    }*/
    public Item takeItem(Item item) {
        return bag.addItemInBag(item);
    }

    public void giveItemByName(Item item) {

        List<Item> items = bag.getItems();

        if (items.contains(item)) {
            bag.dropItemsFromBag(item);
            bag.setAvailableSpace(bag.getAvailableSpace() + item.requiredSpace());
            System.out.println("\nThe item has been dropped from the bag: " + item.name());
        }
    }
  /*  public void showBag() {
        bag = getBag();
        List<Item> items = bag.getItems();            // la gestione della borsa lo deve fare o bag o il comando showbag

        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");
        } else {
            System.out.print("\nIn bag: ");
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getName());
                if (i < items.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        int remainingSpace = bag.getAvailableSpace();
        System.out.println("Remaining space in bag: " + remainingSpace);
    }*/

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}

