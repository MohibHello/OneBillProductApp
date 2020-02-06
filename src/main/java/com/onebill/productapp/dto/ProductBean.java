package com.onebill.productapp.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int productId;
	@Size(max=40,min=3,message="length should be greater than 3 and less than 40")
	@Column(name = "product_name", length = 40)
	private String productName;
	@Size(max=15,min=4,message="length should be greater than 4 and less than 15 ")
	@Column(name = "product_code", length = 15, unique = true)
	private String productCode;
	@Size(max=255,min=3,message="description should not exceed 255 characters")
	@Column(name = "description", length = 255)
	private String description;
	@Min( value=1,message="minimimum price should be greater than or equal to 1")
	@Digits(integer=6, fraction=2)
	@Column(name = "price", length = 15)
	private double price;
	@NotNull
	@DecimalMin(value="0.0")
	@DecimalMax(value="5.0")
	@Column(name = "rating", length = 10)
	private double rating;
	@NotNull
	@Max(value=10,message="maximum quantity 10")
	@Min(value=1,message="minimum quantity 1")
	@Column(name = "quantity", length = 10)
	private int quantity;
	@Column(name = "is_active")
	private boolean isActive;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<OrderItemBean> itemBeans;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ReviewBean> reviewBeans;

}
