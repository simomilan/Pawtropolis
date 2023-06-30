package model;

public enum Direction {

    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west");

    private final  String directionString; //meglio final mi sa così non può modificato, directionString


    Direction (String directionString) {
        this.directionString = directionString;
    }

    public String getDirectionString () {  //il get vorrei non toglierlo, può sempre servire!!
        return directionString;
    }


    @Override
    public String toString () {
        return "Direction{"+
                "directionString='"+directionString+'\''+
                '}';
    }
    // metodo per restituire l'enum da una stringa
    public static Direction getDirectionFromString (String directionString) {
        for (Direction direction : Direction.values()) {
            if (direction.getDirectionString().equalsIgnoreCase(directionString)) {
                return direction;
            }
        }
        return null; // La stringa non corrisponde a nessuna direzione
    }
}

