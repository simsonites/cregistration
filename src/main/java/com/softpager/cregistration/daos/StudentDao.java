package com.softpager.cregistration.daos;

import java.util.List;

import com.softpager.cregistration.entities.Student;

public interface StudentDao {

	List<Student> getStudents();

	Student getStudent(int theId);

	Student registerForCourse(int sId, int cId);

	void create(Student newStudent);

	void delete(int theId);

	List<Student> searchStudent(String studentName);

}
