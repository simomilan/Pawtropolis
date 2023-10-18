package pawtropolis.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name ="animal")
public class AnimalEntity implements EntityDB{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "animal_id")
    private Long animalId;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "species")
    @Enumerated(EnumType.STRING)
    private Species species;

    @Column(name = "favorite_food")
    private String favoriteFood;

    @Column(name = "age")
    private int age;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name ="weight")
    private double weight;

    @Column(name = "height")
    private double height;

    @Column(name = "wingspan")
    private double wingspan;

    @Column(name = "tail_length")
    private double tailLenght;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;
}
