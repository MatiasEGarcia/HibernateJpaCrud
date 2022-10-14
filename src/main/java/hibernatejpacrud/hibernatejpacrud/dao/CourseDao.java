package hibernatejpacrud.hibernatejpacrud.dao;


import javax.persistence.EntityManager;

import hibernatejpacrud.hibernatejpacrud.domain.Course;

public class CourseDao extends Dao<Course,Long> {

	public CourseDao(EntityManager em) {
		super(em);
	}
	
	@Override
	public Course find(Long id) {
		EntityManager em = this.getEntityManager();
		return em.find(Course.class, id);
	}
}
