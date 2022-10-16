package hibernatejpacrud.hibernatejpacrud.domain;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
	  @AttributeOverride( name = "phone", column = @Column(name = "phone")),
	  @AttributeOverride( name = "mail", column = @Column(name = "mail"))
	})
public class Contact {

	@Column(name= "phone")
	private String phone;
	
	@Column(name= "mail")
	private String mail;

	public Contact() {
		super();
	}

	public Contact(String phone, String mail) {
		super();
		this.phone = phone;
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mail, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(mail, other.mail) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "Contact [phone=" + phone + ", mail=" + mail + "]";
	}
	
	
}
