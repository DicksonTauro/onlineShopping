package com.jrdsi.onlineShoppingBackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name= "Users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="first_name")
	@NotBlank(message = "Please enter first name")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message = "Please Enter Last Name")
	private String lastName;
	
	@Column(unique=true	)
	@NotBlank(message = "Please email address")
	private String email;
	
	@Column(name="contact_number")
	@NotBlank(message = "Please enter contact number")
	private String contactNumber;
	
	private String role;
	
	@NotBlank(message = "Please enter password")
	private String password;
	
	@Column(name = "active_ind")
	private boolean activeInd;
	
	//comfirm password transientField
	
	@Transient
	private String confirmPassword;
	
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Cart cart;
	
	public void setCart(Cart cart){
		this.cart=cart;
	}
	
	public Cart getCart(){
		return this.cart;
	}

	public Integer getId() {
		return id;
	}
	
	public User(){
		this.activeInd = true;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActiveInd() {
		return activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", activeInd="
				+ activeInd + "]";
	}
	
		

}
