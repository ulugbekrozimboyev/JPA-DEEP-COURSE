package uz.ulugbek.universityproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.ulugbek.universityproject.domain.Course;
import uz.ulugbek.universityproject.domain.Curriculum;
import uz.ulugbek.universityproject.domain.Professor;
import uz.ulugbek.universityproject.domain.Student;
import uz.ulugbek.universityproject.services.CourseService;
import uz.ulugbek.universityproject.services.CurriculumService;
import uz.ulugbek.universityproject.services.ProfessorService;
import uz.ulugbek.universityproject.services.StudentService;

import java.time.LocalDate;

@SpringBootTest
class UniversityApplicationTests {

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

        pr.setAddress(new Professor.Address("M.Joe 23", "Lasvegas", "23020"));

        pr.setPersonalContact(new Professor.Contact("my-test@gmail.com", "+1232323232"));
        pr.setBusinessContact(new Professor.Contact("bs-test@gmail.com", "+1434323232"));

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
        return studentService.save(studentTmp1);
    }

    private Long createCourse() {
        Course crTmp = new Course();
        crTmp.setName("test course with student");
        crTmp.setStartDate(LocalDate.now());
        crTmp.setEndDate(LocalDate.now());

        return courseService.save(crTmp);
    }

}
