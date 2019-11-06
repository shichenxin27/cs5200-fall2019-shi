package edu.northeastern.cs5200.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String title;
    private int seats;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "section", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Enrollment> enrollments = new ArrayList<>();
    
    public Section() {}

    public Section( String title,int seats) {
		super();
		this.seats = seats;
		this.title = title;
	}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}    
    
	public int getSeats() {
		return seats;
	}
    
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
		if(!course.getSections().contains(this)) {
			course.getSections().add(this);
		}
	}
	
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public void addEnrollments(Enrollment enroll) {
		this.enrollments.add(enroll);
		if(enroll.getEnrolledSection()!=this) {
			enroll.setEnrolledSection(this);
			this.seats = this.seats - 1;
		}
	}
    
}
