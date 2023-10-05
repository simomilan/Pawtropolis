package pawtropolis.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Getter
@Setter
@ToString
@Component
public class Player {

    public static final int MAX_LIFE_POINTS = 100;
    public static final int MIN_LIFE_POINTS = 0;

    private String name;
    private int lifePoints;
    private final Bag bag;
    @Autowired
    public Player(Bag bag) {
        this.bag = bag;
    }

    public void setLifePoints(int lifePoints) {
        if (lifePoints > MAX_LIFE_POINTS) {
            this.lifePoints = MAX_LIFE_POINTS;
        } else this.lifePoints = Math.max(lifePoints, MIN_LIFE_POINTS);
    }


    public void addItemToBag(Item item) {
        bag.addItem(item);
    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public String showBag() {
        return bag.getBagContentDescription();
    }

    public int getAvailableSpaceInBag() {
        return bag.getAvailableSpace();
    }

    public Item getItemInBag(String itemName) {
        return bag.getItemByName(itemName);
    }

    public boolean isEnoughSpaceInBag(Item item) {
        return bag.isEnoughSpace(item);
    }

}

