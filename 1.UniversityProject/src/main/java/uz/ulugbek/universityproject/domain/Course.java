package uz.ulugbek.universityproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Data
@EqualsAndHashCode
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    private Professor professor;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private Set<Student> students = new HashSet<>();
}
