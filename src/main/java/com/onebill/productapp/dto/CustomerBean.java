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
@Table(name = "customer")
public class CustomerBean implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "customer_id", length = 10)
	private Integer customerId;
	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(name = "email", length = 30)
	private String email;
	@Column(name = "phone", length = 15)
	private Integer phone;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "user_type", length = 5)
	private String userType;

	
}
