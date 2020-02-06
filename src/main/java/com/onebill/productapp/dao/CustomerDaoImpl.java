package com.onebill.productapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dto.CustomerBean;
import com.onebill.productapp.repository.AddressRepo;
import com.onebill.productapp.repository.CustomerRepo;

import lombok.extern.java.Log;

@Log
@Service
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	CustomerRepo customerRepository;

	@Autowired
	AddressRepo addressRepository;

	@Override
	public void saveOrUpdateCustomer(CustomerBean customer) {
		try {
			CustomerBean customerBean = customerRepository.save(customer);
			if(customerBean.getAddressBean()!=null) {
			customerBean.getAddressBean().iterator().forEachRemaining(addressBean->{
			 addressBean.setCustomer(customerBean);
			 addressRepository.save(addressBean);
			 });
			}
		} catch (Exception e) {
			log.severe("Exception in DAO addCustomer(CustomerBean customer)" + e);
			throw e;
		}

	}

	@Override
	public CustomerBean findCustomer(int customerId) {
		try {
			return customerRepository.findById(customerId).get();
		} catch (Exception e) {
			log.severe("Exception in DAO updateCustomer(CustomerBean customer)" + e);
			throw e;
		}
	}

	@Override
	public boolean existsById(int customerId) {
		try {
			return customerRepository.existsById(customerId);
		} catch (Exception e) {
			log.severe("Exception in DAO existsById(int customerId)" + e);
			throw e;
		}
	}

	@Override
	public boolean existsByEmail(String customerEmail) {
		try {
			return customerRepository.existsByEmail(customerEmail);
		} catch (Exception e) {
			log.severe("Exception in DAO existsByEmail(String customerEmail)" + e);
			throw e;
		}
	}

	@Override
	public List<CustomerBean> getActiveCustomer() {
		try {
			return customerRepository.getActiveCustomer();
		} catch (Exception e) {
			log.severe("Exception in DAO getActiveCustomer()" + e);
			throw e;
		}
	}

	@Override
	public List<CustomerBean> getCustomer(String customerEmail) {
		try {
			return customerRepository.getCustomer(customerEmail);
		} catch (Exception e) {
			log.severe("Exception in DAO getCustomer(String customerEmail)" + e);
			throw e;
		}
	}

	@Override
	public List<CustomerBean> getAllCustomer() {
		try {
			return customerRepository.findAll();
		} catch (Exception e) {
			log.severe("Exception in DAO getAllCustomer()" + e);
			throw e;
		}
	}

}
