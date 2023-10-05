package pawtropolis.zoo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public class Eagle extends Winged {
    @Builder(builderMethodName = "eagleBuilder")
    public Eagle(String nickname, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingspan) {
        super(nickname, favoriteFood, age, entryDate, weight, height, wingspan);
    }
}