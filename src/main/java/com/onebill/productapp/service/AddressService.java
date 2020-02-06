package com.onebill.productapp.service;

import com.onebill.productapp.dto.AddressBean;
import com.onebill.productapp.dto.ResponseBean;

public interface AddressService {

	ResponseBean addAddress(AddressBean address);
	
	ResponseBean getAddress(Integer addressId);
	
}
