package model;

public class Player {

    public static final int MAX_LIFE_POINTS = 100;
    public static final int MIN_LIFE_POINTS = 0;

    private String name;

    private int lifePoints;

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
        if (lifePoints > MAX_LIFE_POINTS) {
            this.lifePoints = MAX_LIFE_POINTS;
        } else if (lifePoints < MIN_LIFE_POINTS) {
            this.lifePoints = MIN_LIFE_POINTS;
        } else {
        this.lifePoints = lifePoints;
    }
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
