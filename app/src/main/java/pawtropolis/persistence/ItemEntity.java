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
    private Long itemID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "required_space")
    private int requiredSpace;


}
