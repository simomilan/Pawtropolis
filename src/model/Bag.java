package model;

import java.util.*;

public class Bag {


    public static final int SPACE_BAG = 4; //static per accesso al main (vedi riga 25 di Main), Final per eviatare che la grandezza dello spoazio della bag commuti.
    private List<Item> items;
    private int availableSpace;


    public Bag (List<Item> items, int availableSpace) {
        this.items = items != null ? items : new ArrayList<>(); // così non incorrere in un'eccezione NullPointerException se il parametro items è null
        this.availableSpace = availableSpace;
    }

    public List<Item> getItems () {
        return  items;
    }

    public int getAvailableSpace () {
        return availableSpace;
    }

    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }


    @Override
    public String toString () {
        return "Bag{"+
                "listItem="+items+
                ",availableSpace="+availableSpace+
                '}';
    }


    public int addItemsInBag(Item item) {
        if (item != null && availableSpace - item.getSpaceBagUsed() >= 0) {  //bisognerebbe dscindere l'else dal caso in cui l'oggtto si anullo dal caso in cui occupa troppo spazio
            items.add(item);
            availableSpace -= item.getSpaceBagUsed();
        } else {
            System.out.println("The item occupied too much space!" + '\n' + "Please drop something to make space or you can't take it.");
        }
        return availableSpace;
    }

}
