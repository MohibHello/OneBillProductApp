package com.onebill.productapp.dao;

import java.util.List;

import com.onebill.productapp.dto.CustomerBean;

public interface CustomerDao {

	void saveOrUpdateCustomer(CustomerBean customer);

	CustomerBean findCustomer(int customerId);

	boolean existsById(int customerId);

	boolean existsByEmail(String customerEmail);

	List<CustomerBean> getActiveCustomer();

	List<CustomerBean> getCustomer(String customerEmail);

	List<CustomerBean> getAllCustomer();
}
