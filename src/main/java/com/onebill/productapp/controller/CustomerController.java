package com.onebill.productapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.productapp.dto.CustomerBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.service.CustomerService;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping(value = "/add-customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addCustomer(@Valid @RequestBody CustomerBean bean) {
		return service.addCustomer(bean);
	}

	@PutMapping(value = "/update-customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean aupdateCustomer(@Valid @RequestBody CustomerBean bean) {
		return service.updateCustomer(bean);
	}

	@PatchMapping(value = "/remove-customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean deleteCustomer(@Valid @RequestParam Integer customerId) {
		return service.deleteCustomer(customerId);
	}

	@GetMapping(value = "/get-customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getActiveCustomer() {
		return service.getActiveCustomer();
	}

	@GetMapping(value = "/get-customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getCustomer(@Valid @RequestParam String customerEmail) {
		return service.getCustomer(customerEmail);
	}

	@GetMapping(value = "/get-all-customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getAllCustomer() {
		return service.getAllCustomer();
	}
}
