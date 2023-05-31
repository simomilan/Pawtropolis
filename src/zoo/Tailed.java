package zoo;

import java.time.LocalDate;


public class Tailed extends Animal {

    protected double tailLength;



    public Tailed (String nickname, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength)  {
        super(nickname, favoriteFood, age, entryDate, weight, height);

        if (tailLength <= 0) {
            throw new IllegalArgumentException("La lunghezza della coda per un animale codato non può essere negativa o nulla.");
        }

        this.tailLength=tailLength;

    }

    public double getTailLength () {
        return tailLength;
    }

}