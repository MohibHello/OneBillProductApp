package com.onebill.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dao.AddressDao;
import com.onebill.productapp.dto.AddressBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.util.ResponseUtil;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;

	@Override
	public ResponseBean addAddress(AddressBean address) {
		ResponseBean response = null;
		try {
			if (addressDao.existByCustomerId(address.getCustomer().getCustomerId()) > 0) {
				addressDao.addAddress(address);
				response = ResponseUtil.fillerSuccess("address added successfully");
			} else {
				response = ResponseUtil.fillerFailure("cid doesnt exist");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerFailure("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getAddress(Integer customerId) {

		ResponseBean response = null;
		try {
			if (addressDao.existByCustomerId(customerId) > 0) {
				List<AddressBean> findByCustomerId = addressDao.getAddress(customerId);
				response = ResponseUtil.fillerSuccess("address retrived successfully");
				response.setAddressBeans(findByCustomerId);
			} else {
				response = ResponseUtil.fillerFailure("id doesnt exists");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

}
