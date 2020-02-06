package com.onebill.productapp.dao;

import java.util.List;

import com.onebill.productapp.dto.OrderBean;

public interface OrderDao {

	void placeOrder(OrderBean order);

	int existByCustomerId(int customerId);

	List<OrderBean> findAllOrder();
}
