package com.onebill.productapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "order_item")
public class OrderItemBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_item_id")
	private int orderItemId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductBean productBean;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private OrderBean orderBean;
	
	@Size(max=10,min=1,message="Minimum quantity is 1 and maximum is quantity 10")
	@Column(name = "quantity",length=10)
	private int quantity;
	@Digits(integer=6, fraction=2)
	@Column(name = "price")
	private double price;

}
