package pawtropolis.zoo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class Lion extends Tailed{

    @Builder(builderMethodName = "lionBuilder")
    public Lion(String nickname, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(nickname, favoriteFood, age, entryDate, weight, height, tailLength);

    }

}
