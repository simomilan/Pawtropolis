package pawtropolis.zoo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class Tiger extends Tailed {

    public Tiger(String nickname, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(nickname, favoriteFood, age, entryDate, weight, height, tailLength);


    }

}
