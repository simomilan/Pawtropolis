package pawtropolis.persistence;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "item")
public class ItemEntity implements EntityDB{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //o identity????!!
    @Column(name = "item_id")
    private Long itemID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "required_space")
    private int requiredSpace;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bag_id")
    private BagEntity bagEntity;

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;*/
}
