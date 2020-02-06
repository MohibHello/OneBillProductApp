package com.onebill.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dao.OrderItemDao;
import com.onebill.productapp.dto.OrderItemBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.util.ResponseUtil;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemDao orderItemDao;

	@Override
	public ResponseBean addItem(OrderItemBean orderItem) {
		ResponseBean response = null;
		try {
			if (orderItemDao.existByOrderId(orderItem.getOrderBean().getOrderId()) > 0) {

				orderItemDao.addItem(orderItem);
				response = ResponseUtil.fillerSuccess("item added successfully");
			} else {
				response = ResponseUtil.fillerFailure("order id doesnt exist ");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getItem() {
		ResponseBean response = null;

		try {
			response = ResponseUtil.fillerSuccess("Ordered item found");
			response.setOrderItemBeans(orderItemDao.getItem());
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getCustomerItem(Integer cid) {
		ResponseBean response = null;

		try {
			response = ResponseUtil.fillerSuccess("product item found");
			response.setOrderItemBeans(orderItemDao.getCustomerItem(cid));
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

}
