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
		List<Instructor> listOfInstructors = instructorsQuery.getResultList();		
		return listOfInstructors;
	}

}
