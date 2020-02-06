package com.onebill.productapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dto.AddressBean;
import com.onebill.productapp.repository.AddressRepo;

import lombok.extern.java.Log;

@Log
@Service
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private AddressRepo addressRepository;

	@Override
	public void addAddress(AddressBean address) {

		try {
			addressRepository.save(address);
		} catch (Exception e) {
			log.severe("exception in DAO addAddress(AddressBean address)" + e);
			throw e;
		}
	}

	@Override
	public List<AddressBean> getAddress(int addressId) {
		try {
			return addressRepository.findByCustomerId(addressId);
		} catch (Exception e) {
			log.severe("exception in DAO getAddress(int addressId)" + e);
			throw e;
		}
	}
	@Override
	public int existByCustomerId(int customerId) {
		try {
			return addressRepository.existByCustomerId(customerId);
		} catch (Exception e) {
			log.severe("exception in DAO existByCustomerId(int addressId)" + e);
			throw e;
		}
	}

}
