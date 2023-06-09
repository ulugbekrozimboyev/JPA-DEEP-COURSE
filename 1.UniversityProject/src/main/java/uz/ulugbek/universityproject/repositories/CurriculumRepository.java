package uz.ulugbek.universityproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.universityproject.domain.Curriculum;

@Repository
public interface CurriculumRepository extends CrudRepository<Curriculum, Long> {
}
