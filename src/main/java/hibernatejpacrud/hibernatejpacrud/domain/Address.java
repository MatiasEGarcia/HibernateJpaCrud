package hibernatejpacrud.hibernatejpacrud.domain;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
	  @AttributeOverride( name = "country", column = @Column(name = "country")),
	  @AttributeOverride( name = "address", column = @Column(name = "address"))
	})
public class Address {

	@Column(name= "country")
	private String country;
	
	@Column(name= "address")
	private String address;

	public Address() {
		super();
	}

	public Address(String country, String address) {
		super();
		this.country = country;
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, country);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(address, other.address) && Objects.equals(country, other.country);
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", address=" + address + "]";
	}
	
	
	
}
