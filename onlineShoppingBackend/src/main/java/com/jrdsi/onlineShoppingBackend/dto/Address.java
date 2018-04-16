package  com.jrdsi.onlineShoppingBackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	public Integer getUser() {
		return userId;
	}

	public void setUser(Integer userId) {
		this.userId = userId;
	}

	@Column(name="address_line_one")
	@NotBlank(message = "Please enter the Address Line One")
	private String addressLineOne;
	
	@Column(name="address_line_two")
	@NotBlank(message = "Please enter the Address Line Two")
	private String addressLineTwo;
	
	@NotBlank(message = "Please enter the city name")
	private String city;
	
	@NotBlank(message = "Please enter the State name")
	private String state;
	
	@NotBlank(message = "please enter the country name")
	private String country;
	
	@Column(name="postal_code")
	@NotBlank(message = "please enter the postal code")
	private String postalCode;
	
	private boolean shipping;
	
	private boolean billing;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	
	
	

}
