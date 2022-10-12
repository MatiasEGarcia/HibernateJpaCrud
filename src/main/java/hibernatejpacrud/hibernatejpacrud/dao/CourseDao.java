package hibernatejpacrud.hibernatejpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernatejpacrud.hibernatejpacrud.domain.Course;

public class CourseDao {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CourseDao() {
		emf = Persistence.createEntityManagerFactory("HibernatePU");
		em = emf.createEntityManager();
	}
	
	public void closeEm() {
		em.close();
	}
	
	public List<Course> listAll() {
		String hql = "FROM Course";
		Query query= em.createQuery(hql);
		List<Course> courses = query.getResultList();
		return courses;
	}
	
	public Course getById(Long id) {
		return em.find(Course.class, id);
	}
	
	public Course getByName(String name) {
		String hql = "FROM Course WHERE name =:name";
		Query query= em.createQuery(hql);
		query.setParameter("name", name);
		Course course = (Course) query.getSingleResult();
		return course;
	}
	
	public void save(Course course) {
		try {
			em.getTransaction().begin();
			em.persist(course);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		}
	}
	

	public void update(Course course) {
		try {
			em.getTransaction().begin();
			em.merge(course);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		}
	}
	
	public void delete(Course course) {
		try {
			em.getTransaction().begin();
			em.remove(course);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		}
	}

}
