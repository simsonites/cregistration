package com.softpager.cregistration.daos;

import java.util.List;

import com.softpager.cregistration.entities.Course;

public interface CourseDao {

	List<Course> getCourses();

	Course registerForCourse(int sId, int cId);

	Course getCourse(int theId);

}
