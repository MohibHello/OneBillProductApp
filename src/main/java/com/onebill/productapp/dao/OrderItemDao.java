package com.onebill.productapp.dao;

import java.util.List;

import com.onebill.productapp.dto.OrderItemBean;

public interface OrderItemDao {

	void addItem(OrderItemBean orderItem);

	List<OrderItemBean> getItem();

	List<OrderItemBean> getCustomerItem(Integer cid);
	
	int existByOrderId(int orderId);
	
}
