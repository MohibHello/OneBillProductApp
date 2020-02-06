package com.onebill.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dao.OrderDao;
import com.onebill.productapp.dto.OrderBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.util.ResponseUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Override
	public ResponseBean placeOrder(OrderBean order) {
		ResponseBean response = null;
		try {
			int orderDao2 = orderDao.existByCustomerId(order.getCustomerBean().getCustomerId());
			if (orderDao2>0) {
				orderDao.placeOrder(order);
				response=ResponseUtil.fillerSuccess("order added successfully");
			} else {
				response=ResponseUtil.fillerFailure("customer id doesnt exist ");
			}
		} catch (Exception e) {
			response=ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
	return response;
	}

	@Override
	public ResponseBean getOrder() {
		ResponseBean response = null;

		try {
			response = ResponseUtil.fillerSuccess("Order found");
			response.setOrderBeans(orderDao.findAllOrder());
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}
}
