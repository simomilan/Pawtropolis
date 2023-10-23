package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "bag")
public class Bag implements EntityDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bag_space")
    private int BAG_SPACE = 4;    //errori non  e da però bho


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_player")
    private Player playerEntity;
}
