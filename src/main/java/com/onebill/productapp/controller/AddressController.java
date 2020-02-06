package com.onebill.productapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.productapp.dto.AddressBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService service;
	
	@PostMapping(value="/add-address",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean addAddress(@Valid @RequestBody AddressBean bean) {
		return service.addAddress(bean);
	}
	@GetMapping(value="/get-address",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean getAddress(@Valid @RequestParam Integer customerId) {
		return service.getAddress(customerId);
	}
	
}
