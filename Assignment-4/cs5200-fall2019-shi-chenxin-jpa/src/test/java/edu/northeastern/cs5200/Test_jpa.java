package edu.northeastern.cs5200;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.daos.*;
import edu.northeastern.cs5200.repositories.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_jpa {
	
	@Autowired
	private UniversityDao udao;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	StudentRepository studentRepository;
		
	@Before
	public void test() {
		
		udao.truncateDatabase();
    	
    	//create faculty
    	Faculty alan = new Faculty("alan", "password", "Alan", "Turin", "123A", true);
        Faculty ada = new Faculty("ada", "password", "Ada", "Lovelace", "123B", true);
        udao.createFaculty(alan);
        udao.createFaculty(ada);
        
        //create students
        Student alice = new Student("alice", "password", "Alice", "Wonderland", 2020, 12000);
        Student bob = new Student("bob", "password", "Bob", "Hope", 2021, 23000);
        Student charlie = new Student("charlie", "password", "Charlie", "Brown", 2019, 21000);
        Student dan = new Student("dan", "password", "Dan", "Craig", 2019, 0);
        Student edward = new Student("edward", "password", "Edward", "Scissorhands", 2022, 11000);
        Student frank = new Student("frank", "password", "Frank", "Herbert", 2018, 0);
        Student gregory = new Student("gregory", "password", "Gregory", "Peck", 2023, 10000);

        udao.createStudent(alice);
        udao.createStudent(bob);
        udao.createStudent(charlie);
        udao.createStudent(dan);
        udao.createStudent(edward);
        udao.createStudent(frank);
        udao.createStudent(gregory);
        
        //create courses
		Course c1 = new Course("CS1234");
		Course c2 = new Course("CS2345");
		Course c3 = new Course("CS3456");
		Course c4 = new Course("CS4567");
		udao.createCourse(c1);
		udao.createCourse(c2);
		udao.createCourse(c3);
		udao.createCourse(c4);

		udao.setAuthorForCourse(alan, c1);
		udao.setAuthorForCourse(alan, c2);
		udao.setAuthorForCourse(ada, c3);
		udao.setAuthorForCourse(ada, c4);		
        
		//create sections
		Section s4 = new Section("SEC4321", 50);
		Section s5 = new Section("SEC5432", 50);
		Section s6 = new Section("SEC6543", 50);
		Section s7 = new Section("SEC7654", 50);
		udao.createSection(s4);
		udao.createSection(s5);
		udao.createSection(s6);
		udao.createSection(s7);		
		
		udao.addSectionToCourse(s4, c1);
		udao.addSectionToCourse(s5, c1);
		udao.addSectionToCourse(s6, c2);
		udao.addSectionToCourse(s7, c3);
		
		//enroll students
	    udao.enrollStudentInSection(alice, s4);
	    udao.enrollStudentInSection(alice, s5);
	    udao.enrollStudentInSection(bob, s5);
	    udao.enrollStudentInSection(charlie, s6);
	    
			    	    
    }
    
    @Test
	public void validateUser() {
		
		//validate user number
		System.out.print("***************************************************************************Total amount: ");
		System.out.println(udao.findAllUsers().size());
	    assertEquals(9, udao.findAllUsers().size());
    }    
	@Test
	public void validateFaculty() {
	    //validate faculty number
	    assertEquals(2, udao.findAllFaculty().size());
	}
	
    @Test
	public void validateStudent() {
	    //validate student number
	    assertEquals(7, udao.findAllStudents().size());
    }
    
    @Test
	public void validateCourse() {
	    //validate course number
	    assertEquals(4, udao.findAllCourses().size());
    }
    
    @Test
	public void validateSection() {
	    //validate section number
	    assertEquals(4, udao.findAllSections().size());
    }
    
    @Test
	public void validateAuthorship() {
	    //validate course authorship
		Faculty alan = facultyRepository.findFacultyByFirstName("Alan");
		Faculty ada = facultyRepository.findFacultyByFirstName("Ada");
		assertEquals(2, udao.findCoursesForAuthor(alan).size());
		assertEquals(2, udao.findCoursesForAuthor(ada).size());
    }
    
    @Test
	public void validateSectionPerCourse() {
		//validates section per course
		Course c1 = courseRepository.findCourseByTitle("CS1234");
		Course c2 = courseRepository.findCourseByTitle("CS2345");
		Course c3 = courseRepository.findCourseByTitle("CS3456");
		Course c4 = courseRepository.findCourseByTitle("CS4567");

		assertEquals(2, udao.findSectionForCourse(c1).size());
		assertEquals(1, udao.findSectionForCourse(c2).size());
		assertEquals(1, udao.findSectionForCourse(c3).size());
		assertEquals(0, udao.findSectionForCourse(c4).size());
    }
    
    @Test
	public void validateSectionEnroll() {
		//validate section enrollments
		Section s4 = sectionRepository.findSectionByTitle("SEC4321");
		Section s5 = sectionRepository.findSectionByTitle("SEC5432");
		Section s6 = sectionRepository.findSectionByTitle("SEC6543");
		Section s7 = sectionRepository.findSectionByTitle("SEC7654");
		
		System.out.print("***************************************************************************Total amount: ");
		System.out.println(udao.findStudentsInSection(s4));
		assertEquals(1, udao.findStudentsInSection(s4).size());
		assertEquals(2, udao.findStudentsInSection(s5).size());
		assertEquals(1, udao.findStudentsInSection(s6).size());
		assertEquals(0, udao.findStudentsInSection(s7).size());
    }
    
    @Test
	public void validateStudentEnroll() {
		//validates student enrollments
		Student alice = studentRepository.findStudentByFirstName("Alice");
		Student bob = studentRepository.findStudentByFirstName("Bob");
		Student charlie = studentRepository.findStudentByFirstName("Charlie");
		Student dan = studentRepository.findStudentByFirstName("Dan");
		Student edward = studentRepository.findStudentByFirstName("Edward");
		Student frank = studentRepository.findStudentByFirstName("Frank");
		Student gregory = studentRepository.findStudentByFirstName("Gregory");
		
		assertEquals(2, udao.findSectionsForStudent(alice).size());
		assertEquals(1, udao.findSectionsForStudent(bob).size());
		assertEquals(1, udao.findSectionsForStudent(charlie).size());
		assertEquals(0, udao.findSectionsForStudent(dan).size());
		assertEquals(0, udao.findSectionsForStudent(edward).size());
		assertEquals(0, udao.findSectionsForStudent(frank).size());
		assertEquals(0, udao.findSectionsForStudent(gregory).size());
    }
    
    @Test
	public void validateSeats() {
		//validate seats
		Section s4 = sectionRepository.findSectionByTitle("SEC4321");
		Section s5 = sectionRepository.findSectionByTitle("SEC5432");
		Section s6 = sectionRepository.findSectionByTitle("SEC6543");
		Section s7 = sectionRepository.findSectionByTitle("SEC7654");
	    assertEquals(49, s4.getSeats());
	    assertEquals(48, s5.getSeats());
	    assertEquals(49, s6.getSeats());
	    assertEquals(50, s7.getSeats());
		
		
	}


    
}
