package hibernatejpacrud.hibernatejpacrud;

import hibernatejpacrud.hibernatejpacrud.dao.CourseDao;
import hibernatejpacrud.hibernatejpacrud.domain.Course;

public class HibernateJpaCrud {

    public static void main(String[] args) {
        System.out.println("Testing --------");
        CourseDao dao= new CourseDao();
        
        /*Course newCourse = new Course("History",1500);
        dao.save(newCourse);
        System.out.println("Course saved");
        Course courseObtained = dao.getByName(newCourse.getName());
        System.out.println("Course obtained = " + courseObtained);*/
        
        /*Course newCourse = new Course(1L,"History",1000);
        dao.update(newCourse);
        System.out.println("Course updated");*/
        
        Course newCourse = dao.getByName("History");
        dao.delete(newCourse);
        System.out.println("Course deleted");
    }
}
