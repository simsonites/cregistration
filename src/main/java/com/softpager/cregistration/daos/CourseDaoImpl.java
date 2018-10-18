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
import com.softpager.cregistration.entities.Student;

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

	@Override
	public Course registerForCourse(int sId, int cId) {		
		Session currentSession = sessionFactory.getCurrentSession();
		Student theStudent = currentSession.get(Student.class, sId);
		Course theCourse = currentSession.get(Course.class, cId);
		if((sId <= 0)|| (cId <= 0)) {
			System.out.println("invalid ids");
		}
		theCourse.addStudentToCourse(theStudent);
		return theCourse;
	}

	@Override
	public Course getCourse(int theId) {	
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder cBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Course> courseCriteriaQuery = cBuilder.createQuery(Course.class);
		Root<Course> rootQuery = courseCriteriaQuery.from(Course.class);
		courseCriteriaQuery.select(rootQuery).where(cBuilder.equal(rootQuery.get("id"), theId));
		Query<Course> courseQuery = currentSession.createQuery(courseCriteriaQuery);
		Course theCourse = courseQuery.getSingleResult();
		return theCourse;
	}

}





















