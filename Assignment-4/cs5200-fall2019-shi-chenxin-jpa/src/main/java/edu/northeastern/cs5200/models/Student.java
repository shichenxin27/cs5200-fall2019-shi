package edu.northeastern.cs5200.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends Person {
	
	private int gradYear;
    private long scholarship;
    
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Enrollment> enrollments = new HashSet<>();
    
    public Student() {}
    
	public Student(String username, String password, String firstName, String lastName, int gradYear, long scholarship) {
		super(username, password, firstName, lastName);
		this.gradYear = gradYear;
		this.scholarship = scholarship;
	}
	
	public Student(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
	
	public int getGradYear() {
		return gradYear;
	}
	
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
	
	public Long getScholarship() {
		return scholarship;
	}
	
	public void setScholarship(Long scholarship) {
		this.scholarship = scholarship;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public void addEnrollments(Enrollment enroll) {
		this.enrollments.add(enroll);
		if(enroll.getEnrolledStudent()!=this) {
			enroll.setEnrolledStudent(this);
		}
	}
	
}
