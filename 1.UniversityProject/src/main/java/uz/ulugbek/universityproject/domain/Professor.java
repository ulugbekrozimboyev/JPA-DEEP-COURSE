package uz.ulugbek.universityproject.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "professors")
@Data
public class Professor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
    private List<Course> courses;
}
