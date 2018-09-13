package com.softpager.cregistration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softpager.cregistration.daos.InstructorDao;
import com.softpager.cregistration.entities.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired 
	private InstructorDao  instructorDao;
	
	@Override
	@Transactional
	public List<Instructor> getInstructors() {		
		return  instructorDao.getInstructors();
	}

}
