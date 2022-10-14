package hibernatejpacrud.hibernatejpacrud;

import javax.persistence.EntityManager;

import hibernatejpacrud.hibernatejpacrud.dao.CourseDao;
import hibernatejpacrud.hibernatejpacrud.dao.PersistenceManager;
import hibernatejpacrud.hibernatejpacrud.domain.Course;

public class HibernateJpaCrud {

    public static void main(String[] args) {
        System.out.println("Testing --------");
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();
        
        CourseDao courseDao= new CourseDao(em);
        
        Course historyCourse = new Course("History",1500);
        
        courseDao.create(historyCourse);
        em.getTransaction().commit();
        em.close();
        System.out.println(historyCourse); //I have the object synchronized with the bdd
    }
}
