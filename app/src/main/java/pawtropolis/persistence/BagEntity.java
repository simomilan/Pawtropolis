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
    @Column(name = "bag_id")
    private Long bagID;

    @Column(name = "bag_space")
    private int BAG_SPACE = 4;    //errori non  e da però bho


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;
}
