package hibernatejpacrud.hibernatejpacrud;

import java.util.ArrayList;
import java.util.Collection;

import hibernatejpacrud.hibernatejpacrud.domain.Address;
import hibernatejpacrud.hibernatejpacrud.domain.Contact;
import hibernatejpacrud.hibernatejpacrud.domain.Course;
import hibernatejpacrud.hibernatejpacrud.domain.Student;
import hibernatejpacrud.hibernatejpacrud.service.CourseServiceImpl;
import hibernatejpacrud.hibernatejpacrud.service.StudentServiceImpl;

public class HibernateJpaCrud {

    public static void main(String[] args) {
        System.out.println("Testing --------");
        
        /*Get all courses
		CourseServiceImpl courseService = new CourseServiceImpl();

        Collection<Course> courses = courseService.getAll();
        System.out.println("Courses:" + courses );
        */
        
        /*Save student
        
        StudentServiceImpl service = new StudentServiceImpl();
        Address address = new Address("Mexico","i don't know the street");
        Contact contact = new Contact("1111-1111","elen@gmail.com");
        Student newStudent = new Student("ELena","Garcia",contact,address);
        newStudent = service.save(newStudent);
        System.out.println("Student added :" + newStudent );
        */
        
        
        //Save student with the course he signed up for
        
        StudentServiceImpl studentService = new StudentServiceImpl();
        CourseServiceImpl courseService = new CourseServiceImpl();
        Course course = new Course("Geografia",800);
        course = courseService.save(course);
        
        
        Address address = new Address("Argentina","i don't know the street");
        Contact contact = new Contact("5555-5555","rocio@gmail.com");
        Collection<Course> studentCourses = new ArrayList<Course>();
        studentCourses.add(course);
        Student newStudent = new Student("Rocio","Garcia",contact,address,studentCourses);
        newStudent = studentService.save(newStudent);
        System.out.println("Student added :" + newStudent );
        
    }
}
