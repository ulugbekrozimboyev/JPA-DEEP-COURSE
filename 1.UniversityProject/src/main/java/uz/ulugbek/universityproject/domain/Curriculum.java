package uz.ulugbek.universityproject.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "curriculums")
@Data
public class Curriculum {

    @Id
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    @MapsId
    private Course course;
}
