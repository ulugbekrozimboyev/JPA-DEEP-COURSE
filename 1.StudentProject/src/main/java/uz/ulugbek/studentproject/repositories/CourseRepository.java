package uz.ulugbek.studentproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.studentproject.domain.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
