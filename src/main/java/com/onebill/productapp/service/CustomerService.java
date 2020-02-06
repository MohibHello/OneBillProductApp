package com.onebill.productapp.service;


import com.onebill.productapp.dto.CustomerBean;
import com.onebill.productapp.dto.ResponseBean;

public interface CustomerService {

	ResponseBean addCustomer(CustomerBean customer);
	
	ResponseBean updateCustomer(CustomerBean customer);
	
	ResponseBean deleteCustomer(int customerId);
	
	ResponseBean getActiveCustomer();
	
	ResponseBean getCustomer(String customerEmail);
	
	ResponseBean getAllCustomer();
}
