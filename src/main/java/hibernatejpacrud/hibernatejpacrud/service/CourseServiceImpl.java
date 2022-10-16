package hibernatejpacrud.hibernatejpacrud.service;

import java.util.Collection;

import javax.persistence.EntityManager;

import hibernatejpacrud.hibernatejpacrud.dao.CourseDao;
import hibernatejpacrud.hibernatejpacrud.dao.PersistenceManager;
import hibernatejpacrud.hibernatejpacrud.domain.Course;

public class CourseServiceImpl implements GenericService<Course, Long>{

	@Override
	public Course save(Course t) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();		
        
        CourseDao dao = new CourseDao(em);
        
        t = dao.create(t);
        em.getTransaction().commit();
        em.close();
        return t;
	}

	@Override
	public Course update(Course t) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();		
        
        CourseDao dao = new CourseDao(em);
        t = dao.update(t);
        em.getTransaction().commit();
        em.close();
		return t;
	}

	@Override
	public void delete(Course t) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();		
        
        CourseDao dao = new CourseDao(em);
        dao.delete(t);
        em.getTransaction().commit();
        em.close();
	}

	@Override
	public Course get(Course t) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();
        CourseDao dao = new CourseDao(em);
        t = dao.find(t.getIdCurso());
        em.getTransaction().commit();
        em.close();
		return t;
	}

	@Override
	public Collection<Course> getAll() {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();
        Collection<Course> courses;
        CourseDao dao = new CourseDao(em);
        courses = dao.findAll();
        em.getTransaction().commit();
        em.close();
		return courses;
	}

}
