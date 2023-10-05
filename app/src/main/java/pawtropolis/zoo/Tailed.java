package pawtropolis.zoo;

import lombok.*;


import java.time.LocalDate;
@ToString
@Getter
@Setter
public class Tailed extends Animal {

    protected double tailLength;


    @Builder
    public Tailed (String nickname, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength)  {
       super(nickname, favoriteFood, age, entryDate, weight, height);

        if (tailLength <= 0) {
            throw new IllegalArgumentException("La lunghezza della coda per un animale codato non può essere negativa o nulla.");
        }

        this.tailLength=tailLength;


    }



}