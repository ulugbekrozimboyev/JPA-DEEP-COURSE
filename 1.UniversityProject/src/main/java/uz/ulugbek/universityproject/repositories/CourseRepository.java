package uz.ulugbek.universityproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.universityproject.domain.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
