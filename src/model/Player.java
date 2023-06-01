package model;

import java.util.List;
import java.util.Map;

public class Player {

    private String name;

    private int lifePoints;  //da gestire

    //private Bag bag;             // la mettiamoin game controller
    private Room currentRoom;

    public Player ( String name, int lifePoints,/* Bag bag,*/ Room currentRoom) {
        this.name= name;
        this.lifePoints = lifePoints;
        //this.bag = bag;
        this.currentRoom = currentRoom;
    }
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }


    public int getLifePoints () {
        return lifePoints;
    }

    public void setLifePoints (int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /*public Bag getBag () {
        return bag;
    }

    public void setBag (Bag bag) {
        this.bag = bag;
    }*/

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public String toString () {
        return "Player{"+
                "name='"+name+
                ", lifePoints="+lifePoints+
               /* ", bag="+bag+*/
                ", currentRoom"+ currentRoom+
                '}';
    }



   /* public void go(Direction direction) {
        Room nextRoom = currentRoom.getAdjoiningRoom(direction);
        if (nextRoom != null) {
            setCurrentRoom(nextRoom);
            System.out.println("You moved to the " + direction + ".");
            System.out.println("Current room: " + nextRoom.getNameRoom());
        } else {
            System.out.println("There is no room in that direction.");
        }
    }

  /*  public void addItemToBag(Item item){
        int availableSpace = bag.getAvailableSpace();   //conytrollo se la boesa è piena
       if(bag.getAvailableSpace() -item.getSpaceBagUsed() >= 0){
           bag.addItemsInBag(item);
           availableSpace -= item.getSpaceBagUsed();
           bag.setAvailableSpace(availableSpace);
           System.out.println("The item has been added to the bag: " + item.getNameItem());

       } else {
           System.out.println("You haven't enough space in your bag so u can't add it. Please first drop something!");
       }
    }

    public void dropItemFromBag(Item item) {

        List<Item> items = bag.getItems();
        if (items.contains(item)) {
            items.remove(item);
            int availableSpace = bag.getAvailableSpace() + item.getSpaceBagUsed();
            bag.setAvailableSpace(availableSpace);
            System.out.println("The item has been dropped from the bag: " + item.getNameItem());
        } else {
            System.out.println("Item not found in the bag: " + item.getNameItem());
        }
    }

    public Bag showBagg(){
        bag.showBag();
      return  bag;
    }
*/

}
