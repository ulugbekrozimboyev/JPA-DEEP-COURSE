package uz.ulugbek.studentproject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.ulugbek.studentproject.domain.Course;
import uz.ulugbek.studentproject.domain.Curriculum;
import uz.ulugbek.studentproject.domain.Professor;
import uz.ulugbek.studentproject.domain.Student;
import uz.ulugbek.studentproject.services.CourseService;
import uz.ulugbek.studentproject.services.CurriculumService;
import uz.ulugbek.studentproject.services.ProfessorService;
import uz.ulugbek.studentproject.services.StudentService;

import java.time.LocalDate;

@SpringBootTest
class StudentApplicationTests {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CurriculumService curriculumService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testProfessor() {

        Professor pr = new Professor();
        pr.setFirstName("test");
        pr.setLastName("test");

        professorService.save(pr);
    }

    @Test
    public void testProfessorAndCourse() {

        Professor prTmp = new Professor();
        prTmp.setFirstName("test");
        prTmp.setLastName("test");

        Course crTmp = new Course();
        crTmp.setName("test course");
        crTmp.setStartDate(LocalDate.now());
        crTmp.setEndDate(LocalDate.now());

        Long profId = professorService.save(prTmp);
        Long courseId = courseService.save(crTmp);

        Professor professor = professorService.findById(profId);
        Course course = courseService.findById(courseId);

        professor.getCourses().add(course);
        professorService.save(professor);

        course.setProfessor(professor);
        courseService.save(course);

    }

//    @Test
//    public void testCourseAndStudent() {
//
//        Long courseId1 = createCourse();
//        Long courseId2 = createCourse();
//
//        Long studentId1 = createStudent();
//        Long studentId2 = createStudent();
//
//        Course course1 = courseService.findById(courseId1);
//        Course course2 = courseService.findById(courseId2);
//
//        Student student1 = studentService.findById(studentId1);
//        Student student2 = studentService.findById(studentId2);
//
//        student1.getCourses().add(course1);
//        student1.getCourses().add(course2);
//        studentService.save(student1);
//
//        course1.getStudents().add(student1);
//        course1.getStudents().add(student2);
//        courseService.save(course1);
//
//        student2.getCourses().add(course2);
//        studentService.save(student2);
//
//        course2.getStudents().add(student2);
//        courseService.save(course2);
//
//    }

    @Test
    public void testStudentWithCourse () {

        Long courseId1 = createCourse();
        Long courseId2 = createCourse();

        Long studentId1 = createStudent();
        Long studentId2 = createStudent();

        Course course1 = courseService.findById(courseId1);
        Course course2 = courseService.findById(courseId2);

        Student student1 = studentService.findById(studentId1);
        Student student2 = studentService.findById(studentId2);

        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        studentService.save(student1);

        student2.getCourses().add(course2);
        studentService.save(student2);

    }

    @Test
    public void testCurriculum(){

        Course course = new Course();
        course.setName("test course with student");
        course.setStartDate(LocalDate.now());
        course.setEndDate(LocalDate.now());

        Curriculum curriculum = new Curriculum();
        curriculum.setDescription("test desc");
        curriculum.setCourse(course);

        curriculumService.save(curriculum);

    }

    private Long createStudent() {
        Student studentTmp1 = new Student();
        studentTmp1.setFirstName("test student");
        studentTmp1.setLastName("test student");
        studentTmp1.setState(1);
        Long studentId1 = studentService.save(studentTmp1);
        return studentId1;
    }

    private Long createCourse() {
        Course crTmp = new Course();
        crTmp.setName("test course with student");
        crTmp.setStartDate(LocalDate.now());
        crTmp.setEndDate(LocalDate.now());

        Long courseId = courseService.save(crTmp);
        return courseId;
    }

}
