package hibernatejpacrud.hibernatejpacrud.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses", schema = "hibernatecrud")
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCurso;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "price")
    private float price;

	public Course() {
		super();
	}

	public Course(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Course(Long idCurso, String name, float price) {
		super();
		this.idCurso = idCurso;
		this.name = name;
		this.price = price;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCurso, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(idCurso, other.idCurso) && Objects.equals(name, other.name)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}

	@Override
	public String toString() {
		return "Course [idCurso=" + idCurso + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}
