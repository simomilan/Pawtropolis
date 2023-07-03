package model;

public enum Direction {

    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west");

    private final String directionString;

    Direction(String directionString) {
        this.directionString = directionString;
    }

    public String getDirectionString() {
        return directionString;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "directionString='" + directionString + '\'' +
                '}';
    }

    public static Direction getDirectionFromString(String directionString) {
        for (Direction direction : Direction.values()) {
            if (direction.getDirectionString().equalsIgnoreCase(directionString)) {
                return direction;
            }
        }
        return null;
    }

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
        };
    }

}


