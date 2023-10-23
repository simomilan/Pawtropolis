package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name= "species_type")
public class Species implements EntityDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "species_type_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private pawtropolis.persistence.Species species;

}
