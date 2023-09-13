package pawtropolis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@AllArgsConstructor
public class Item {
    private final String name;
    private final String description;
    private final int requiredSpace;


}
