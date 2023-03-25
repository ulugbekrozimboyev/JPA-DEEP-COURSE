package uz.ulugbek.studentproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ulugbek.studentproject.domain.Professor;
import uz.ulugbek.studentproject.domain.Student;
import uz.ulugbek.studentproject.repositories.ProfessorRepository;
import uz.ulugbek.studentproject.repositories.StudentRepository;

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
