package model;

import java.util.*;

public class Bag {


    public static final int SPACE_BAG = 4; //cambia sto nome
    private List <Item> items;
    private int availableSpace;


    public Bag (int availableSpace) {
        this.items = new ArrayList <>(SPACE_BAG);
        this.availableSpace = SPACE_BAG;
    }

    public List <Item> getItems () {
        return items;
    }

    public int getAvailableSpace () {
        return availableSpace;
    }

    public void setAvailableSpace (int availableSpace) {
        this.availableSpace = availableSpace;
    }


    @Override
    public String toString () {
        return "Bag{"+
                "listItem="+items+
                ",availableSpace="+availableSpace+
                '}';
    }


    public Item addItemInBag (Item item) { //addItem

        if (item != null && availableSpace-item.getRequiredSpace() >= 0) {
            items.add(item);
            availableSpace -= item.getRequiredSpace();
        }
        return null;
    }

    public int dropItemsFromBag (Item item) { //removeItem
        items.remove(item);
        availableSpace += item.getRequiredSpace();
        return availableSpace;

    }

    public List <Item> showBag () {
        // la gestione della borsa lo deve fare o bag o il comando showbag, nel senso il controllo se la borsa è vuoto o piena
        //forse deve farlo il metodo execute in ShowBagCommand

        for (int i = 0; i < items.size(); i++) {         //costruisce la stringa con la conoscenza dei propri item, la darà poi al player
            System.out.print(items.get(i).getName());
            if (i < items.size()-1) {
                System.out.print(", ");
            }

        }

        return items;
    }

}