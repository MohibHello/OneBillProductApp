package com.onebill.productapp.dao;

import java.util.List;

import com.onebill.productapp.dto.AddressBean;

public interface AddressDao {

	void addAddress(AddressBean address);

	List<AddressBean> getAddress(int addressId);
	
	int existByCustomerId(int customerId);
}
