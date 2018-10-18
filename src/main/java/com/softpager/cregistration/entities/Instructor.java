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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="instructors")
public class Instructor {

	@Id
	@Column(name = "instructor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	@NotBlank(message = "")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "")
	private String lastName;

	@Column(name = "mobile")
	@NotBlank(message = "")
	private String mobile;

	@NotBlank(message = "")
	@Column(name = "email")
	private String email;

	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "instructor", fetch= FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST,	CascadeType.REFRESH })
	private List<Course> courses;

	public Instructor() {
	}

	public Instructor(String firstName, String lastName, String mobile, String email, String title) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.title = title;
	//	this.courses = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void add(Course tempCourse) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
	}


}
