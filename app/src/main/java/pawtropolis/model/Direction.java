package pawtropolis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@ToString
public enum Direction {

    NORTH("north", 1),
    EAST("east", 2),
    SOUTH("south", 3),
    WEST("west",4);

    private final String directionString;
    private final int id;


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


