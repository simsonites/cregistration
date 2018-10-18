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

	@Override
	public Student registerForCourse(int sId, int cId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student theStudent = currentSession.get(Student.class, sId);
		Course theCourse = currentSession.get(Course.class, cId);
		if((sId <= 0) || (cId <= 0)) {
			System.out.println("invalid ids");
			}
		theStudent.addCourseForStudent(theCourse);
		currentSession.saveOrUpdate(theStudent);		
		return theStudent;
	}

	@Override
	public void create(Student newStudent) {	
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(newStudent);		
	}

	@Override
	public void delete(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student theStudent = currentSession.get(Student.class, theId);
		currentSession.delete(theStudent);		
	}
	//search query
		@Override
		public List<Student> searchStudent(String studentName) {	
			Session currentSession = sessionFactory.getCurrentSession();
		    @SuppressWarnings("rawtypes")
			Query  searchQuery = null;			  
			        if (studentName != null && studentName.trim().length() > 0) {
			            // search for firstName or lastName ... case insensitive
			        	searchQuery =currentSession.createQuery("from Student where lower(firstName) like :theName or "
			        		                                                                               	+ " lower(lastName) like :theName", Student.class);
			        	searchQuery.setParameter("theName", "%" + studentName.toLowerCase() + "%");
			        	}
			        else {
			            // theSearchName is empty ... so just get all student
			        	searchQuery =currentSession.createQuery("from Student", Student.class);            
			        }
			         // execute query and get result list
			        @SuppressWarnings("unchecked")
					List<Student> student = searchQuery.getResultList();		                
			        // return the results        
			        return student;
				
		}
	
	
	
	
}


























