package model;

public class Player {

    public static final int MAX_LIFE_POINTS = 100;
    public static final int MIN_LIFE_POINTS = 0;

    private final String name;
    private int lifePoints;
    private final Bag bag;

    public Player(String name, int lifePoints, Bag bag) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = bag;
    }

    public String getName() {
        return name;
    }


    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        if (lifePoints > MAX_LIFE_POINTS) {
            this.lifePoints = MAX_LIFE_POINTS;
        } else this.lifePoints = Math.max(lifePoints, MIN_LIFE_POINTS);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name +
                ", lifePoints=" + lifePoints +
                '}';
    }

    public void addItemToBag(Item item) {
        bag.addItem(item);
    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public String showBag() {
        return bag.showBag();
    }

    public int getAvailableSpaceInBag() {
        return bag.getAvailableSpace();
    }

    public Item getItemInBag(String itemName) {
        return bag.itemByName(itemName);
    }
}

