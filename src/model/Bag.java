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

    public Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    //TODO: for-each o Stream? StringJoin per sb.append(", ");?
    public String getBagContentDescription() {
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



