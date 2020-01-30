package com.onebill.productapp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="order")
public class OrderBean implements Serializable {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "shipping_address")
	private String shippingAddress;
	
	@CreationTimestamp
	@Column(name = "date_of_order")
	private Date dateOfOrder;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private CustomerBean customerBean;

	
	
	
}
