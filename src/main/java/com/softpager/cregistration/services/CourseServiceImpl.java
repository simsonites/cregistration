package com.softpager.cregistration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softpager.cregistration.daos.CourseDao;
import com.softpager.cregistration.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseDao courseDao;
	
	@Autowired	
	public CourseServiceImpl(CourseDao courseDao) {	
		this.courseDao = courseDao;
	}

	@Override
	@Transactional
	public List<Course> getCourses() {		
		return courseDao.getCourses();
	}

	@Override
	@Transactional
	public Course registerForCourse(int sId, int cId) {		
		return courseDao.registerForCourse(sId, cId);
	}

	@Override
	@Transactional
	public Course getCourse(int theId) {
		return courseDao.getCourse(theId);
	}

}


















