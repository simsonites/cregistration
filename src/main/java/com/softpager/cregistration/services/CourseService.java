package com.softpager.cregistration.services;

import java.util.List;

import com.softpager.cregistration.entities.Course;

public interface CourseService {

	List<Course> getCourses();

	Course registerForCourse(int sId, int cId);

	Course getCourse(int theId);

}
