package pawtropolis.zoo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Getter
@Setter
@ToString
//@SuperBuilder
public class Eagle extends Winged{
    public Eagle(String nickname, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingspan) {
        super(nickname, favoriteFood, age, entryDate, weight, height, wingspan);
    }
}