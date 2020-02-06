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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class AddressBean implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "address_id", length = 15)
	private int addressId;
	
	@Size(max=255,min=1,message="address should not exceed 255 characters")
	@Column(name = "address", length = 255)
	private String address;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private CustomerBean customer;
	
	@Size(min=4,max=10,message="address type should be greater than 4 and less than 10 characters")
	@Column(name="address_type", length=10)
	private String addressType;
}
