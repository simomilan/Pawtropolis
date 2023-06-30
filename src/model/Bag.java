package model;

import java.util.*;

public class Bag {

    public static final int BAG_SPACE = 4;
    private final List<Item> items;
    private int availableSpace;

    public Bag() {
        this.items = new ArrayList<>(BAG_SPACE);
        this.availableSpace = BAG_SPACE;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    /////NON VA BENE DA TOGLIERE POICHè PER MODIFICARE LISTA PUOI AGGIUNGERE CON METODO ADDIREM, REMOVEITEM, USARE METODO ITEMBYNAME
   /* public List<Item> getItems() {
        return items;
    }*/
///////////////////
    @Override
    public String toString() {
        return "Bag{" +
                "listItem=" + items +
                ",availableSpace=" + availableSpace +
                '}';
    }

    public void addItem(Item item) {
        if (item != null && availableSpace - item.getRequiredSpace() >= 0) {
            items.add(item);
            availableSpace -= item.getRequiredSpace();
        }
    }

    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            availableSpace += item.getRequiredSpace();
        }
    }

    public Item itemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        } return null;
    }

    public String showBag() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).getName());
            if (i < items.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}



