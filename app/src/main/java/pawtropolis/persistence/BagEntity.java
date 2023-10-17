package pawtropolis.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bag")
public class BagEntity implements EntityDB{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bagID;

    @Column(name = "bag_space")
    private static final int BAG_SPACE =4;    //errori non  e da però bho

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemID")
    private List<ItemEntity> item;                    //da vede bene sta cosa



}
