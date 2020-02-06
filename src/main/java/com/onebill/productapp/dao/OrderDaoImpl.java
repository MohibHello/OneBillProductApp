package com.onebill.productapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dto.OrderBean;
import com.onebill.productapp.repository.OrderRepo;

import lombok.extern.java.Log;

@Log
@Service
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	OrderRepo orderRepository;

	@Override
	public void placeOrder(OrderBean order) {
		try {
			orderRepository.save(order);
		} catch (Exception e) {
			log.severe("exception in DAO placeOrder(OrderBean order)" + e);
			throw e;
		}
	}
	
	@Override
	public int existByCustomerId(int customerId) {
		try {
			return orderRepository.existByCustomerId(customerId);
		} catch (Exception e) {
			log.severe("exception in DAO existByCustomerId(int customerId)" + e);
			throw e;
		}
	}

	@Override
	public List<OrderBean> findAllOrder() {
		try {
			return orderRepository.findAll();
		} catch (Exception e) {
			log.severe("exception in DAO findAllOrder()" + e);
			throw e;
		}
	}

}
