package pawtropolis.zoo;

import lombok.Getter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@ToString

public class Animal {

    /**
     * The animal's nickname
     */
    protected String nickName;
    private String favoriteFood;
    private int age;
    private LocalDate entryDate;
    protected double weight;
    protected double height;

    /**
     * Constructs a new animal with the given attributes
     *
     * @param nickName     the animal's nickname
     * @param favoriteFood
     * @param age
     * @param entryDate
     * @param weight
     * @param height
     * @throws IllegalArgumentException if any of the parameters is not valid (empty strings, negative or zero values)
     */

    protected Animal(String nickName, String favoriteFood, int age, LocalDate entryDate, double weight, double height) {

        // Check if arguments are valid
        if (nickName.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nickName non può essere vuoto.");
        }
        if (favoriteFood.trim().isEmpty()) {
            throw new IllegalArgumentException("Il cibo preferito non può essere vuoto.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("L'età non può essere negativa o nulla.");
        }
        if (entryDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La data di inserimento non può essere successiva a quella odierna.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Il peso non può essere negativo o nullo.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("L'altezza non può essere negativa o nulla.");
        }

        this.nickName = nickName;
        this.favoriteFood = favoriteFood;
        this.age = age;
        this.entryDate = entryDate;
        this.weight = weight;
        this.height = height;

    }


}