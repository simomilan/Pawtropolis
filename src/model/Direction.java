package model;

import java.util.Arrays;

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
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getDirectionString().equalsIgnoreCase(directionString))
                .findFirst()
                .orElse(null);
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


