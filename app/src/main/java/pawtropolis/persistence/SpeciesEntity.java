package pawtropolis.persistence;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name= "species_type")
public class SpeciesEntity implements EntityDB{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_species_type")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Species species;

}
