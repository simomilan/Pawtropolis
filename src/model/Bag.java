package model;

import java.util.*;

public class Bag {


    public static final int SPACE_BAG = 4;
    private List<Item> items;
    private int availableSpace;


    public Bag ( int availableSpace) {
        this.items= new ArrayList<>(SPACE_BAG);
        this.availableSpace = SPACE_BAG;
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


    public Item addItemInBag(Item item)  {

        if (item != null && availableSpace - item.requiredSpace() >= 0) {  //bisognerebbe dscindere l'else dal caso in cui l'oggtto si anullo dal caso in cui occupa troppo spazio
            items.add(item);
            availableSpace -= item.requiredSpace();
        }
        return null;
    }

    public int dropItemsFromBag (Item item) {
        items.remove(item);
        availableSpace += item.requiredSpace();

    return availableSpace;

}

    public void showBag() {
                  // la gestione della borsa lo deve fare o bag o il comando showbag, nel senso il controllo se la borsa è vuoto o piena
                                                 //forse deve farlo il metodo execute in ShowBagCommand
        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");
        } else {
            System.out.print("\nIn bag: ");
            items.forEach(item -> System.out.print(item.name() + ", "));
            System.out.println();
        }
        int remainingSpace = getAvailableSpace();
        System.out.println("Remaining space in bag: " + remainingSpace);
    }
}