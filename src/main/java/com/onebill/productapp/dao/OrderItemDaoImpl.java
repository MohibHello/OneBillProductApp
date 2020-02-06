package com.onebill.productapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dto.OrderItemBean;
import com.onebill.productapp.repository.OrderItemRepo;

import lombok.extern.java.Log;

@Log
@Service
public class OrderItemDaoImpl implements OrderItemDao {

	
	@Autowired
	OrderItemRepo orderItemRepository;
	
	
	@Override
	public void addItem(OrderItemBean orderItem) {
		try {
			orderItemRepository.save(orderItem);
		} catch (Exception e) {
			log.severe("exception in DAO addItem(OrderItemBean orderItem)" + e);
			throw e;
		}
	}

	@Override
	public List<OrderItemBean> getItem() {
		try {
			return orderItemRepository.findAll();
		} catch (Exception e) {
			log.severe("exception in DAO addItem(OrderItemBean orderItem)" + e);
			throw e;
		}
	}

	@Override
	public List<OrderItemBean> getCustomerItem(Integer cid) {
		try {
			return orderItemRepository.getCustomerProducts(cid);
		} catch (Exception e) {
			log.severe("exception in DAO addItem(OrderItemBean orderItem)" + e);
			throw e;
		}
	}

	@Override
	public int existByOrderId(int orderId) {
		try {
			return orderItemRepository.existByOrderId(orderId);
		} catch (Exception e) {
			log.severe("exception in DAO addItem(OrderItemBean orderItem)" + e);
			throw e;
		}
	}


}
