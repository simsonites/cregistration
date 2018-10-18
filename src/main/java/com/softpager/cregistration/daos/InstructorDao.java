package com.softpager.cregistration.daos;

import java.util.List;

import com.softpager.cregistration.entities.Instructor;

public interface InstructorDao {

	List<Instructor> getInstructors();

	Instructor getInstructor(int theId);

}
