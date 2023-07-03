package model;

public class Item {
    private final String name;
    private final String description;
    private final int requiredSpace;

    public Item(String name, String description, int requiredSpace) {
        this.name = name;
        this.description = description;
        this.requiredSpace = requiredSpace;
    }

    public String getName() {
        return name;
    }

    public int getRequiredSpace() {
        return requiredSpace;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nameItem='" + name + '\'' +
                ", descriptionItem='" + description + '\'' +
                ", spaceBagUsed=" + requiredSpace +
                '}';
    }


}
