package com.onebill.productapp.service;


import com.onebill.productapp.dto.OrderItemBean;
import com.onebill.productapp.dto.ResponseBean;

public interface OrderItemService {

	ResponseBean addItem(OrderItemBean orderItem);
	
	ResponseBean getItem();
	
	ResponseBean getCustomerItem(Integer cid);
}
