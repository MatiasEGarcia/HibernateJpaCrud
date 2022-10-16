package hibernatejpacrud.hibernatejpacrud.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	static private final String PERSISTENCE_UNIT_NAME= "HibernatePU";
	protected static PersistenceManager me= null;
	private EntityManagerFactory emf =null;
	
	private PersistenceManager() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			this.setEmf(emf);
		}
	}
	
	public static PersistenceManager getInstance() {
		if(me == null) {
			me = new PersistenceManager();
		}
		return me;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public EntityManager createEntityManager() {
		return emf.createEntityManager(); //Always the same EntityManagerFactory but different EntityManager
	}
	
	
}
