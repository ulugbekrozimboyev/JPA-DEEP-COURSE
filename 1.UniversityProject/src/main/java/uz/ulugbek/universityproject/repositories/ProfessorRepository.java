package uz.ulugbek.universityproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.universityproject.domain.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
