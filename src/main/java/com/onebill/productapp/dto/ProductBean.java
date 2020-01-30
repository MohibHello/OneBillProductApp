package com.onebill.productapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class ProductBean implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Integer productId;
	@Column(name="product_name",length=255 )
	private String productName;
	@Column(name="product_code", length=15)
	private String productCode;
	@Column(name="description",length=255)
	private String description;
	@Column(name="price",length=15)
	private double price;
	@Column(name="rating",length=10)
	private double rating;
	@Column(name="quantity",length=10 )
	private Integer quantity;
	@Column(name="is_active")
	private boolean isActive;
	
}
