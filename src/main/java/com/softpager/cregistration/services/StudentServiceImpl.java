package com.softpager.cregistration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softpager.cregistration.daos.StudentDao;
import com.softpager.cregistration.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
		
	@Override
	@Transactional
	public List<Student> getStudents() {	
		return studentDao.getStudents();
	}

	@Override
	@Transactional
	public Student getStudent(int theId) {		
		return studentDao.getStudent(theId);
	}

	@Override
	@Transactional 
	public Student registerForCourse(int sId, int cId) {	
		return studentDao.registerForCourse(sId, cId);
	}

	@Override
	@Transactional
	public void create(Student newStudent) {	
		studentDao.create(newStudent);
	}

	@Override
	public void delete(int theId) {
		studentDao.delete(theId);
		
	}

	@Override
	public List<Student> searchStudent(String studentName) {	
		return studentDao.searchStudent(studentName);
	}



}



























