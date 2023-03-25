package uz.ulugbek.studentproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.studentproject.domain.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
