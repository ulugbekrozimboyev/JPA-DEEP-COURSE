package uz.ulugbek.studentproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ulugbek.studentproject.domain.Curriculum;
import uz.ulugbek.studentproject.repositories.CurriculumRepository;

@Service
@RequiredArgsConstructor
public class CurriculumService {

    private final CurriculumRepository curriculumRepository;

    @Transactional
    public Long save(Curriculum curriculum){

        curriculumRepository.save(curriculum);

        return curriculum.getId();
    }

    public Curriculum findById(Long id){
        return curriculumRepository.findById(id).orElseThrow();
    }

}
