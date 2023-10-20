package pawtropolis.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;

@Getter
@AllArgsConstructor

public enum Species {

    TIGER("tiger"),
    LION("lion"),
    EAGLE("eagle");

    private String species;





}


