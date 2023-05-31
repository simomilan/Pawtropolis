package model;

public enum Direction {

    North("north"),
    East("east"),
    South("south"),
    West("west");

    private final String direction; //meglio final mi sa così non può modificato


    Direction (String direction) {
        this.direction = direction;
    }

    public String getDirection () {
        return direction;
    }

   /* public void setDirection (String direction) {   //non dovrebbe servire con l enum il set
        this.direction = direction;
    }*/

    @Override
    public String toString () {
        return "Direction{"+
                "direction='"+direction+'\''+
                '}';
    }


}



