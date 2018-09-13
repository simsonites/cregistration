package com.softpager.cregistration.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softpager.cregistration.entities.Course;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Course> getCourses() {		
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder cBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Course> courseCriteriaQuery = cBuilder.createQuery(Course.class);
		Root<Course> courseRootQuery = courseCriteriaQuery.from(Course.class);
		courseCriteriaQuery.select(courseRootQuery);
		Query<Course> courseQuery = currentSession.createQuery(courseCriteriaQuery);
		List<Course> listOfCourses = courseQuery.getResultList();
		return listOfCourses;
	}

}





















