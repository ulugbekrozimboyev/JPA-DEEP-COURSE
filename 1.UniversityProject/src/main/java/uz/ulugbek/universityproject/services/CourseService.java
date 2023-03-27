package uz.ulugbek.universityproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ulugbek.universityproject.domain.Course;
import uz.ulugbek.universityproject.repositories.CourseRepository;

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
