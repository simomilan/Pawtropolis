package pawtropolis.persistence;

import lombok.*;

import java.util.Arrays;

@Getter
@AllArgsConstructor

public enum Species {

    TIGER("tiger", 1),
    LION("lion", 2),
    EAGLE("eagle", 3);

    private final String name;

    private final int id;

    public static Species fromString(String name) {
        return Arrays.stream(Species.values())
                .filter(type -> type.getName().equals(name.toLowerCase())).findFirst()
                .orElse(null);
    }
}


