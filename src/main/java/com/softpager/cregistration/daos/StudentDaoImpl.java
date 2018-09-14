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

import com.softpager.cregistration.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder cBuider = currentSession.getCriteriaBuilder();
		CriteriaQuery<Student> studentCriteriaQuery = cBuider.createQuery(Student.class);
		Root<Student>studentRoot = studentCriteriaQuery.from(Student.class);
		studentCriteriaQuery.select(studentRoot);
		Query<Student> studentQuery = currentSession.createQuery(studentCriteriaQuery);
		List<Student> listOfStudents = studentQuery.getResultList();		
		return listOfStudents;
	}

	@Override
	public Student getStudent(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder cBuider = currentSession.getCriteriaBuilder();
		CriteriaQuery<Student> studentCriteriaQuery = cBuider.createQuery(Student.class);
		Root<Student> studentRootQuery = studentCriteriaQuery.from(Student.class);
		studentCriteriaQuery.select(studentRootQuery).where(cBuider.equal(studentRootQuery.get("id"), theId));
		Query<Student> studentQuery = currentSession.createQuery(studentCriteriaQuery);
		Student theStudent = studentQuery.getSingleResult();
		return theStudent;
	}




}


























