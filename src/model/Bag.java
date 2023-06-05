package model;
import model.Item;

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

    public void setItems (List<Item> items) {   //per usare la soluzione di sonarlint a questo punto tanto vale creare le sogtoclassi del tipi List<T exentds Item>
        this.items = items;
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
    }//


    public int addItemsInBag(Item item) {
        if (item != null && availableSpace - item.getSpaceBagUsed() >= 0) {
            items.add(item);
            availableSpace -= item.getSpaceBagUsed();
        } else {
            System.out.println("The item occupied too much space!" + '\n' + "Please drop something to make space or you can't take it.");
        }
        return availableSpace;
    }



    public int dropItemsFromBag(Item item) {  //? valutare se usare un iterator

            if (items.contains(item)) {
                items.remove(item);
                availableSpace += item.getSpaceBagUsed();
                System.out.println("The item has been dropped from the bag: " + item.getNameItem());
            } else {
                System.out.println("Item not found in the bag: " + item.getNameItem());
            }
            return availableSpace;
        }

    }








