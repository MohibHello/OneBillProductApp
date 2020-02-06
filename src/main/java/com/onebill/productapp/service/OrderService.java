package com.onebill.productapp.service;


import com.onebill.productapp.dto.OrderBean;
import com.onebill.productapp.dto.ResponseBean;

public interface OrderService {

	ResponseBean placeOrder(OrderBean order);
	
	ResponseBean getOrder();
	
}
