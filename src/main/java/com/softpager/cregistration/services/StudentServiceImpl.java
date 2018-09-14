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



}



























