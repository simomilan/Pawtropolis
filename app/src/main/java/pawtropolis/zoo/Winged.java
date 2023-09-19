package pawtropolis.zoo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@ToString
@Getter
@Setter
//@SuperBuilder
public class Winged extends Animal {

    protected double wingspan;

    public Winged (String nickname, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingspan) {
        super(nickname, favoriteFood, age, entryDate, weight, height);

        this.wingspan = wingspan;

        if (wingspan <= 0) {
            throw new IllegalArgumentException("La lunghezza delle ali per un animale alato non può essere negativa o nulla.");
        }


    }




}
