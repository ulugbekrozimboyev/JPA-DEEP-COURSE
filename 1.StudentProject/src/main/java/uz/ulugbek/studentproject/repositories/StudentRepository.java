package uz.ulugbek.studentproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.studentproject.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
