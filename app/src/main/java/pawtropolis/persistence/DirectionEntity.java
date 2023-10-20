package pawtropolis.persistence;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pawtropolis.model.Direction;

@Getter
@Setter
@Entity
@Table(name = "direction")
public class DirectionEntity implements EntityDB{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direction_id")
    private Long directionID;

    @Enumerated(EnumType.STRING)
    private Direction direction;

    @ManyToOne
    @JoinColumn(name = "from_room_id")
    private RoomEntity fromRoom;


    @ManyToOne
    @JoinColumn(name = "to_room_id")
    private RoomEntity toRoom;
}
