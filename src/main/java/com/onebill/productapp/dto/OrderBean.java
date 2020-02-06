package com.onebill.productapp.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "order_product")
public class OrderBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;

	@Max(value=255,message="address should not exceed 255 characters")
	@Column(name = "shipping_address",length=255)
	private String shippingAddress;

	@NotNull
	@CreationTimestamp
	@Column(name = "date_of_order")
	private LocalDate dateOfOrder;
	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private CustomerBean customerBean;

}
