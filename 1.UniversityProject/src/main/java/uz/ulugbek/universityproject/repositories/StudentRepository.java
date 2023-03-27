package uz.ulugbek.universityproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.universityproject.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
