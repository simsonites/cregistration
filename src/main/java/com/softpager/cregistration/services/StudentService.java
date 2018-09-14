package com.softpager.cregistration.services;

import java.util.List;

import com.softpager.cregistration.entities.Student;

public interface StudentService {

	List<Student> getStudents();

	Student getStudent(int theId);


}
