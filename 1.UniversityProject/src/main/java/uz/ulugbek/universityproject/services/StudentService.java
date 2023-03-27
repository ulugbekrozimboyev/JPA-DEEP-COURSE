package uz.ulugbek.universityproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ulugbek.universityproject.domain.Student;
import uz.ulugbek.universityproject.repositories.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public Long save(Student student){

        studentRepository.save(student);

        return student.getId();
    }

    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow();
    }

}
