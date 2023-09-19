package pawtropolis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@AllArgsConstructor
//@SuperBuilder
public class Item {
    private final String name;
    private final String description;
    private final int requiredSpace;


}
