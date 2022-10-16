package hibernatejpacrud.hibernatejpacrud.dao;


import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hibernatejpacrud.hibernatejpacrud.domain.Course;

public class CourseDao extends Dao<Course,Long> {

	public CourseDao(EntityManager em) {
		super(em);
	}
	
	@Override
	public Course find(Long id) {
		checkTransaction();
		return em.find(Course.class, id);
	}

	@Override
	@SuppressWarnings("unchecked") //for the getResultList
	public Collection<Course> findAll() {
		checkTransaction();
		String hql = "FROM Course";
		Query query= em.createQuery(hql);
		return query.getResultList();
		
	}
	
	
}
