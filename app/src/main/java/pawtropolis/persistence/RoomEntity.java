package pawtropolis.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "room")
public class RoomEntity implements EntityDB{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomID;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "itemID")
    private List<ItemEntity> items;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animalID")
    private List<AnimalEntity> animals;
}
