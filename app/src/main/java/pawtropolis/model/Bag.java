package pawtropolis.model;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
//@SuperBuilder
public class Bag {

    public static final int BAG_SPACE = 4;
    private final List<Item> items;
    private int availableSpace;

    public Bag() {
        this.items = new ArrayList<>(BAG_SPACE);
        this.availableSpace = BAG_SPACE;
    }


    public boolean isEnoughSpace(Item item) {
        return availableSpace - item.getRequiredSpace() >= 0;
    }


    public void addItem(Item item) {
        if (item != null && getAvailableSpace() - item.getRequiredSpace() >= 0) {
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
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public String getBagContentDescription() {
        return items.stream()
                .map(Item::getName)
                .collect(Collectors.joining(", "));
    }
}



