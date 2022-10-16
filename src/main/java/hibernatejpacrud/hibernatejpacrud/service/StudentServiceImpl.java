package hibernatejpacrud.hibernatejpacrud.service;

import java.util.Collection;

import javax.persistence.EntityManager;

import hibernatejpacrud.hibernatejpacrud.dao.PersistenceManager;
import hibernatejpacrud.hibernatejpacrud.dao.StudentDao;
import hibernatejpacrud.hibernatejpacrud.domain.Student;

public class StudentServiceImpl implements GenericService<Student, Long> {

	@Override
	public Student save(Student t) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		StudentDao dao= new StudentDao(em);
		
		t = dao.create(t);
        em.getTransaction().commit();
        em.close();
        return t;
	}

	@Override
	public Student update(Student t) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();		
        
        StudentDao dao = new StudentDao(em);
        t = dao.update(t);
        em.getTransaction().commit();
        em.close();
		return t;
	}

	@Override
	public void delete(Student t) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();		
        
        StudentDao dao = new StudentDao(em);
        dao.delete(t);
        em.getTransaction().commit();
        em.close();		
	}

	@Override
	public Student get(Student t) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();
        StudentDao dao = new StudentDao(em);
        t = dao.find(t.getId());
        em.getTransaction().commit();
        em.close();
		return t;
	}

	@Override
	public Collection<Student> getAll() {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();
        Collection<Student> students;
        StudentDao dao = new StudentDao(em);
        students = dao.findAll();
        em.getTransaction().commit();
        em.close();
		return students;
	}

}
