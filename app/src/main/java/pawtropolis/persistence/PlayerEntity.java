package pawtropolis.persistence;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "player")
public class PlayerEntity implements EntityDB{

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerID;

    @Column(name = "name")
    private String name;

    @Column(name = "lifepoints")
    private int lifepoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bagID")
    private BagEntity bag;
}
