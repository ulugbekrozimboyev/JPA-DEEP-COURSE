package uz.ulugbek.studentproject.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ulugbek.studentproject.domain.Course;
import uz.ulugbek.studentproject.repositories.CourseRepository;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public Long save(Course course){

        courseRepository.save(course);

        return course.getId();
    }

    public Course findById(Long id){
        return courseRepository.findById(id).orElseThrow();
    }

}
