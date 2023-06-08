package model;

public class Player {

    private String name;

    private int lifePoints;  //da gestire

    private Room currentRoom;

    public Player ( String name, int lifePoints, Room currentRoom) {
        this.name= name;
        this.lifePoints = lifePoints;
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


}
