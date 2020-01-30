package com.onebill.productapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_item")
public class OrderItemBean implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "order_item_id")
	private Integer orderItemId;
	@JoinColumn(name = "product_id")
	private ProductBean productBean;
	@JoinColumn(name = "order_id")
	private OrderBean orderBean;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "price")
	private double price;

}
