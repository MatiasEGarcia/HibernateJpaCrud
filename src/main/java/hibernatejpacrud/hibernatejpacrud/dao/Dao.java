package hibernatejpacrud.hibernatejpacrud.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

public abstract class Dao<T,K> {
	
	protected EntityManager em;
	
	public Dao(EntityManager em) {
		this.em = em;
	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public abstract T find(K id);
	
	public abstract Collection<T> findAll();
	
	public T create(T t) {
		checkTransaction();
		em.persist(t);
		em.flush();
		em.refresh(t);
		return t;
	}
	
	public T update(T t) {
		checkTransaction();
		return em.merge(t);
	}
	
	public void delete(T t) {
		checkTransaction();
		t = em.merge(t);
		em.remove(t);
	}
	
	protected void checkTransaction() {
		if(!em.getTransaction().isActive()) {
			throw new RuntimeException("Inactive Transaction");
		}
	}
}
