package uz.ulugbek.universityproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ulugbek.universityproject.domain.Professor;
import uz.ulugbek.universityproject.repositories.ProfessorRepository;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Transactional
    public Long save(Professor professor){

        professorRepository.save(professor);

        return professor.getId();
    }

    public Professor findById(Long id){
        return professorRepository.findById(id).orElseThrow();
    }

}
