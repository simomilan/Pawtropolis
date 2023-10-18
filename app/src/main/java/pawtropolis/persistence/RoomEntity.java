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
    @Column(name = "room_id")
    private Long roomID;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name= "item_id")
    private List<ItemEntity> items;

    /*@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id")
    private List<AnimalEntity> animals;*/
}
