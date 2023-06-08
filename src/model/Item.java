package model;

public class Item {

    private String nameItem;
    private String descriptionItem;
    private int spaceBagUsed;


    public Item (String nameItem, String descriptionItem, int spaceBagUsed ) {
        this.nameItem = nameItem;
        this.descriptionItem = descriptionItem;
        this.spaceBagUsed = spaceBagUsed;
    }

    public String getNameItem () {
        return nameItem;
    }

    public int getSpaceBagUsed () {
        return spaceBagUsed;
    }

    @Override
    public String toString () {
        return "Item{"+
                "nameItem='"+nameItem+'\''+
                ", descriptionItem='"+descriptionItem+'\''+
                ", spaceBagUsed="+spaceBagUsed+
                '}';
    }


}

