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

import com.softpager.cregistration.entities.Instructor;

@Repository
public class InstructorDaoImpl implements  InstructorDao {

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	@Override
	public List<Instructor> getInstructors() {	
		Session currentSession =  sessionFactory.getCurrentSession();
		CriteriaBuilder cBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Instructor> instructorsCriteriaQuery = cBuilder.createQuery(Instructor.class);
		Root<Instructor> instructorsRootQuery = instructorsCriteriaQuery.from(Instructor.class);
		instructorsCriteriaQuery.select(instructorsRootQuery);
		Query<Instructor> instructorsQuery = currentSession.createQuery(instructorsCriteriaQuery);
		instructorsQuery.setFirstResult(0);
		instructorsQuery.setMaxResults(5);
		List<Instructor> listOfInstructors = instructorsQuery.getResultList();		
		return listOfInstructors;
	}

	
	@Override
	public Instructor getInstructor(int theId) {
		Session currentSession =  sessionFactory.getCurrentSession();
		
	   CriteriaBuilder cBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Instructor> instructorCriteriaQuery = cBuilder.createQuery(Instructor.class);
		Root<Instructor> instructorRootQuery = instructorCriteriaQuery.from(Instructor.class);
		instructorCriteriaQuery.select(instructorRootQuery)
		.where(cBuilder.equal(instructorRootQuery.get("id"), theId));
		Query<Instructor> instructorQuery = currentSession.createQuery(instructorCriteriaQuery);
		Instructor theInstructor =  instructorQuery.getSingleResult();
		return theInstructor;
	}

	


}

















