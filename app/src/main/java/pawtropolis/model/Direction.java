package pawtropolis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@ToString
public enum Direction {

    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west");

    private final String directionString;


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


