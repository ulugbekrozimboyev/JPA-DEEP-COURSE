package uz.ulugbek.studentproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.studentproject.domain.Curriculum;

@Repository
public interface CurriculumRepository extends CrudRepository<Curriculum, Long> {
}
