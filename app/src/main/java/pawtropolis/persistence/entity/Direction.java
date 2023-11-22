package pawtropolis.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "direction")
public class Direction implements EntityDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direction_id")
    private Long directionID;

    @Enumerated(EnumType.STRING)
    private pawtropolis.model.Direction cardinalPoint;

    @ManyToOne
    @JoinColumn(name = "from_room_id")
    private Room fromRoom;


    @ManyToOne
    @JoinColumn(name = "to_room_id")
    private Room toRoom;
}
