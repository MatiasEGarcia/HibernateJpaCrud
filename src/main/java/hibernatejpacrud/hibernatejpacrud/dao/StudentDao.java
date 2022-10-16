package hibernatejpacrud.hibernatejpacrud.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hibernatejpacrud.hibernatejpacrud.domain.Student;

public class StudentDao extends Dao<Student,Long>{

	public StudentDao(EntityManager em) {
		super(em);
	}
	
	@Override
	public Student find(Long id) {
		checkTransaction();		
		return em.find(Student.class, id);
	}

	@Override
	@SuppressWarnings("unchecked") //for the getResultList
	public Collection<Student> findAll() {
		checkTransaction();
		String hql = "FROM Student";
		Query query= em.createQuery(hql);
		return query.getResultList();
	}

}
