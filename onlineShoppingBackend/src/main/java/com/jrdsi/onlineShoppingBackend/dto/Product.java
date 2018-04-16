package com.jrdsi.onlineShoppingBackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	
	@NotBlank(message = "Please enter the product name !")
	private String name;
	
	@NotBlank(message="Please enter brand name!")
	private String brand;
	
	@JsonIgnore
	@NotBlank(message = "Please enter the description for product !")
	private String description;
	
	@Column(name = "unit_price")
	@NotNull(message = "please enter the price of the product")
	@Min(value=1 ,message = "unit price should be grater the one")
	private Double unitPrice;
	
	@NotNull(message = "Please enter the Quantity")
	@Min(value=0,message="Quantity should not be less than zero")
	private Integer quantity;
	
	@Column(name = "active_ind")
	private Boolean activeInd;
	
	@Column(name = "category_id")
	@JsonIgnore
	private Integer categoryId;
	
	@Column(name = "supplier_id")
	@JsonIgnore
	private Integer supplierId;
	
	private Integer purchases;
	
	private Integer views;
	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	//default constructor used to set unique value for code
	public Product() {
		this.code = "PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();
		this.purchases = Integer.valueOf(0);
		this.views = Integer.valueOf(0);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(Boolean activeInd) {
		this.activeInd = activeInd;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getPurchases() {
		return purchases;
	}

	public void setPurchases(Integer purchases) {
		this.purchases = purchases;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id =  id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", activeInd=" + activeInd
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}
	
	
	
	
	

}
