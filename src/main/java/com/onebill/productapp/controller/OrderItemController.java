package com.onebill.productapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.productapp.dto.OrderItemBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.service.OrderItemService;

@RestController
public class OrderItemController {
	
	@Autowired
	OrderItemService service;

	@PostMapping(value="/place-item",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean placeItem(@Valid @RequestBody OrderItemBean bean) {
		return service.addItem(bean);
	}
	@GetMapping(value="/get-item",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean getItem() {
		return service.getItem();
	}
	@GetMapping(value="/get-customer-item",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean getCustomerItem(@Valid @RequestParam int cid) {
		return service.getCustomerItem(cid);
	}
}
