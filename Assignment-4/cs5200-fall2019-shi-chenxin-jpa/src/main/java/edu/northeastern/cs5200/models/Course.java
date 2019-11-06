package edu.northeastern.cs5200.models;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@ManyToOne
	private Faculty author;
	
	@OneToMany(mappedBy="course", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	//@LazyCollection(LazyCollectionOption.FALSE)
	private List<Section> courseSections = new ArrayList<>();
	
	
	public Course() {}
	
	public Course(String title) {
        this.title = title;
    }
	
	public Course(String title, Faculty faculty) {
		this.title = title;
		this.author = faculty;
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
	
    public List<Section> getSections() {
        return courseSections;
    }

    public void setSections(List<Section> sections) {
        this.courseSections = sections;
    }
    
    public Faculty getAuthor() {
        return author;
    }

    public void setAuthor(Faculty author) {
        this.author = author;
        if (!author.getAuthoredCourses().contains(this)) {
            author.getAuthoredCourses().add(this);
        }
    }
}
