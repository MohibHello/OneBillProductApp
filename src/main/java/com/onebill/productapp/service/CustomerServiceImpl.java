package com.onebill.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dao.CustomerDao;
import com.onebill.productapp.dto.AddressBean;
import com.onebill.productapp.dto.CustomerBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.util.ResponseUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public ResponseBean addCustomer(CustomerBean customer) {

		ResponseBean response = null;

		try {
			if (!customerDao.existsByEmail(customer.getEmail())) {
				
				AddressBean addressBean=new  AddressBean();
				customer.setActive(true);
				customerDao.saveOrUpdateCustomer(customer);
				response = ResponseUtil.fillerSuccess("customer added successfully");
			} else {
				response = ResponseUtil.fillerFailure("customer email already exist");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;

	}

	@Override
	public ResponseBean updateCustomer(CustomerBean customer) {
		ResponseBean response = null;

		try {
			if (customerDao.existsById(customer.getCustomerId())) {

				CustomerBean customerBean = customerDao.findCustomer(customer.getCustomerId());

				if (customer.getFirstName() != null && !customer.getLastName().trim().equals("")) {
					customerBean.setFirstName(customer.getFirstName());
				}
				if (customer.getEmail() != null && !customer.getLastName().trim().equals("")) {
					customerBean.setEmail(customer.getEmail());
				}
				if (customer.getLastName() != null && !customer.getLastName().trim().equals("")) {
					customerBean.setLastName(customer.getLastName());
				}
				if (customer.getPhone() != null && !customer.getLastName().trim().equals("")) {
					customerBean.setPhone(customer.getPhone());
				}
				customerBean.setActive(true);
				customerDao.saveOrUpdateCustomer(customerBean);
				response = ResponseUtil.fillerSuccess("customer updated successfully");
			} else {
				response = ResponseUtil.fillerFailure("data not found for registered Customer ");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean deleteCustomer(int customerId) {
		ResponseBean response = null;

		try {
			if (customerDao.existsById(customerId)) {

				CustomerBean customerBean = customerDao.findCustomer(customerId);
				customerBean.setActive(false);
				customerDao.saveOrUpdateCustomer(customerBean);
				response = ResponseUtil.fillerSuccess("customer deleted successfully");
			} else {
				response = ResponseUtil.fillerFailure("customer id doesnt exist");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getActiveCustomer() {

		ResponseBean response = null;

		try {
			List<CustomerBean> customerBeans = customerDao.getActiveCustomer();
			if (!customerBeans.isEmpty()) {
				response = ResponseUtil.fillerSuccess("All Active Customers found");
				response.setCustomerBeans(customerBeans);
			} else {
				response = ResponseUtil.fillerFailure("No Active Customers found");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getAllCustomer() {
		ResponseBean response = null;

		try {
			response = ResponseUtil.fillerSuccess("Customer found");
			response.setCustomerBeans(customerDao.getAllCustomer());
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getCustomer(String customerEmail) {
		ResponseBean response = null;

		try {
			List<CustomerBean> customerBeans = customerDao.getCustomer(customerEmail);
			if (customerBeans != null) {
				response = ResponseUtil.fillerSuccess("Customer found");
				response.setCustomerBeans(customerBeans);
			} else {
				response = ResponseUtil.fillerFailure("No Customer found for entered Email");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

}
