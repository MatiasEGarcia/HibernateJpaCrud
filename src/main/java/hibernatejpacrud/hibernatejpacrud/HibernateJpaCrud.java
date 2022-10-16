package hibernatejpacrud.hibernatejpacrud;

import java.util.Collection;

import hibernatejpacrud.hibernatejpacrud.domain.Course;
import hibernatejpacrud.hibernatejpacrud.service.CourseServiceImpl;

public class HibernateJpaCrud {

    public static void main(String[] args) {
        System.out.println("Testing --------");
        
        CourseServiceImpl courseService = new CourseServiceImpl();
        
        /*Get all courses
        Collection<Course> courses = courseService.getAll();
        System.out.println("Los cursos son:" + courses );
        */
        
        
        
        
    }
}
