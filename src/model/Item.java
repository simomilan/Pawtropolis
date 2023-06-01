package model;

public class Item {

    private String nameItem;
    private String descriptionItem;
    private int spaceBagUsed; //perchè ogni oggetto non occupa un indice nella lista (cioè si) ma ha una grandezza sua e la borsa anche. Esempio un mattone neòla borsa occupa più spazio di una penna


    public Item (String nameItem, String descriptionItem, int slotBagUsed ) {
        this.nameItem = nameItem;
        this.descriptionItem = descriptionItem;
        this.spaceBagUsed = slotBagUsed;
    }

    public String getDescriptionItem () {
        return descriptionItem;
    }

    public void setDescriptionItem (String descriptionItem) {
        this.descriptionItem = descriptionItem;
    }

    public String getNameItem () {
        return nameItem;
    }

    public void setNameItem (String nameItem) {
        this.nameItem = nameItem;
    }

    public int getSpaceBagUsed () {
        return spaceBagUsed;
    }

    public void setSpaceBagUsed (int spaceBagUsed) {
        this.spaceBagUsed = spaceBagUsed;
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

