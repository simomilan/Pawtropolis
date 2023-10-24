package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "player")
public class Player implements EntityDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lifepoints")
    private int lifePoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Bag bag;
}
