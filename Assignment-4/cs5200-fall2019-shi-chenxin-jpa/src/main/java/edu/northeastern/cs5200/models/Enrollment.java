package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity
public class Enrollment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int grade = 0;
    private String feedback;

    @ManyToOne()
    private Student student;
    @ManyToOne()
	private Section section;

    public Enrollment() {}

	public Enrollment(Student student, Section section) {
	    this.student = student;
        this.section = section;
    }
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Student getEnrolledStudent() {
        return student;
    }

    public void setEnrolledStudent(Student student) {
        this.student = student;
        if (!student.getEnrollments().contains(this)) {
            student.getEnrollments().add(this);
        }
    }

    public Section getEnrolledSection() {
        return section;
    }

    public void setEnrolledSection(Section section) {
        this.section = section;
        if (!section.getEnrollments().contains(this)) {
            section.getEnrollments().add(this);
        }
    }
	
	
}
