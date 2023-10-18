package pawtropolis.persistence;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "bag")
public class BagEntity implements EntityDB{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bag_id")
    private Long bagID;

    @Column(name = "bag_space")
    private int BAG_SPACE = 4;    //errori non  e da però bho

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<ItemEntity> item;*///da vede bene sta cosa

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;
}
