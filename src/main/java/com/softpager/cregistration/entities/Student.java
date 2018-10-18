package com.softpager.cregistration.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="students")
public class Student {
	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	@NotBlank(message="")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message="")
	private String lastName;
	
	@Column(name="email")
	@NotBlank(message="")
	@Email(message="")
	private String email;
	
	@Column(name="gender")
	@NotBlank(message="")
	private String gender;
	
	@OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name="course_student", joinColumns=@JoinColumn(name="student_id"), 
	inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Course> courses;
	
	public Student() {		
	}

	public Student(String firstName, String lastName, String email, String gender) {	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.courses = new ArrayList<>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourseForStudent(Course theCourse) {
		if(this.courses ==null) {
			this.courses = new ArrayList<>();			
		}
		this.courses.add(theCourse);
		this.setCourses(courses);
	}

		
}



























