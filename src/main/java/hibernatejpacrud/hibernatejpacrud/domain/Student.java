package hibernatejpacrud.hibernatejpacrud.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students", schema = "hibernatecrud")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_student")
	private Long id;
	
	@Column(name= "name")
	private String name; 
	
	@Column(name= "lastname")
	private String lastname; 
	
    @Embedded
	private Contact contact;
    
    @Embedded
   
    private Address address;
    
    @ManyToMany(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name="courses_students",
               joinColumns= @JoinColumn(name="student" ,referencedColumnName="id_student"),                
               inverseJoinColumns=@JoinColumn(name="course", referencedColumnName="id_course"))
    private Collection<Course> courses;
    

	public Student() {
		super();
	}
	
	public Student(String name, String lastname, Contact contact, Address address) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.contact = contact;
		this.address = address;
	}

	public Student(String name, String lastname, Contact contact, Address address, Collection<Course> courses) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.contact = contact;
		this.address = address;
		this.courses = courses;
	}

	public Student(Long id, String name, String lastname, Contact contact, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.contact = contact;
		this.address = address;
	}
	
	public Student(Long id, String name, String lastname, Contact contact, Address address, Collection<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.contact = contact;
		this.address = address;
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}
	
	//List of courses isn't included
	@Override
	public int hashCode() {
		return Objects.hash(address, contact, id, lastname, name);
	}

	@Override//List of courses isn't included
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(contact, other.contact)
				&& Objects.equals(id, other.id) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastname=" + lastname + ", contact=" + contact + ", address="
				+ address + ", courses=" + courses + "]";
	}

	
    
    
}
