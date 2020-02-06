package com.onebill.productapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.productapp.dto.OrderBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;
	
	@PostMapping(value="/place-order",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean placeOrder(@Valid @RequestBody OrderBean bean) {
		return service.placeOrder(bean);
	}
	@GetMapping(value="/get-order",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean updateCustomer() {
		return service.getOrder();
	}
}
