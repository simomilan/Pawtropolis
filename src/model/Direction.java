package model;

public enum Direction {

    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west");

    private final String directioning; //meglio final mi sa così non può modificato


    Direction (String directioning) {
        this.directioning = directioning;
    }

    public String getDirection () {  //il get vorrei non toglierlo, può sempre servire!!
        return directioning;
    }


    @Override
    public String toString () {
        return "Direction{"+
                "directioning='"+directioning+'\''+
                '}';
    }


}