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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
@Validated
public class CustomerBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", length = 10)
	private int customerId;
	@NotNull
	@Size(max = 20, min = 1, message = "length should be greater than 3 and less than 20")
	@Column(name = "first_name", length = 20)
	private String firstName;
	@NotNull
	@Size(max = 20, min = 1, message = "length should be greater than 3 and less than 20")
	@Column(name = "last_name", length = 20)
	private String lastName;
	@NotNull
	@Email
	@Column(name = "email", length = 30, unique = true)
	private String email;
	@NotNull
	@Size(max=15,min=10, message ="length should be equal to 10 or less than 15")
	@Column(name = "phone", length = 15, unique = true)
	private String phone;
	@NotNull
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "customer_type", length = 10)
	private String customerType;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<AddressBean> addressBean;

}
