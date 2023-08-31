package pawtropolis.src.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Item {
    private final String name;
    private final String description;
    private final int requiredSpace;


}
