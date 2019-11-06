package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@Service
@Transactional
public class UniversityDao {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    // update methods
    public void truncateDatabase() {
        enrollmentRepository.deleteAll();
        sectionRepository.deleteAll();
        courseRepository.deleteAll();
        personRepository.deleteAll();
    }    
	
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }
    
    public Section addSectionToCourse(Section section, Course course) {
        section.setCourse(course);
        return sectionRepository.save(section);
    }

    public Course setAuthorForCourse(Faculty faculty, Course course) {
        course.setAuthor(faculty);
        return courseRepository.save(course);
    }
    
    public Boolean enrollStudentInSection(Student student, Section section) {
        if (section.getSeats() == 0) {
            return false;
        }
        else if (section.getSeats() > 0) {
        	Enrollment enrollment = new Enrollment(student, section);
        	student.addEnrollments(enrollment);
        	section.addEnrollments(enrollment);
        	section.setSeats(section.getSeats() - 1);
        	
            enrollmentRepository.save(enrollment);
            sectionRepository.save(section);

            return true;
        }
        else {
        	return false;
        }
    }
    
    // find methods
    public List<Person> findAllUsers() {
        return (List<Person>) personRepository.findAll();
    }

    public List<Faculty> findAllFaculty() {
        return (List<Faculty>) facultyRepository.findAll();
    }

    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public List<Section> findAllSections() {
        return (List<Section>) sectionRepository.findAll();
    }
    
    public List<Course> findCoursesForAuthor(Faculty faculty) {
        return faculty.getAuthoredCourses();
    }
    
    public List<Section> findSectionForCourse(Course course) {
        return course.getSections();
    }
    
    public List<Student> findStudentsInSection(Section section){
    	List<Enrollment> enrollmentList = sectionRepository.findById(section.getId()).get().getEnrollments();
//    	 = enrollmentRepository.findEnrollmentBySection(section);
    	List<Student> students = new ArrayList<Student>();
    	
    	for(Enrollment enrollment : enrollmentList) {
    		students.add(enrollment.getEnrolledStudent());
    	}
    	return students;
    } 
    
    public List<Section> findSectionsForStudent(Student student){
    	Set<Enrollment> enrollmentList = studentRepository.findById(student.getId()).get().getEnrollments();
//    	= enrollmentRepository.findEnrollmentByStudent(student);
    	List<Section> sections = new ArrayList<Section>();
    	
    	for(Enrollment enrollment : enrollmentList) {
    		sections.add(enrollment.getEnrolledSection());
    	}
    	return sections;
    }
    
}
