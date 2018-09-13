package com.softpager.cregistration.entities;

import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@Column(name="course_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	@NotBlank(message="")	
	private String title;
	
	@Column(name="description")
	@NotBlank(message="")	
	private String description;
	
	@Column(name="credits")
	@NotBlank(message="")	
	private int numberOfCredits;
	
	@ManyToMany(fetch=FetchType.EAGER,  cascade= {CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name="course_student", joinColumns=@JoinColumn(name="student_id"), 
	inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Student>students;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "course_instructor", joinColumns = @JoinColumn(name = "course_id"),
	inverseJoinColumns = @JoinColumn(name = "instructor_id"))
	private Instructor instructor;

	public Course() {
	}

	public Course(String title, String description, int numberOfCredits) {	
		this.title = title;
		this.description = description;
		this.numberOfCredits = numberOfCredits;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfCredits() {
		return this.numberOfCredits;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + this.id + ", title=" + this.title + ", description=" + this.description
				+ ", numberOfCredits=" + this.numberOfCredits + ", students=" + this.students + ", instructor="
				+ this.instructor + "]";
	}
	
	
	

}






























