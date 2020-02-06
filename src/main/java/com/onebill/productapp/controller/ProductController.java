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

import com.onebill.productapp.dto.ProductBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.service.ProductService;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping(value="/add-product",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean addProduct(@Valid @RequestBody ProductBean bean) {
		return service.addProduct(bean);
	}
	@PutMapping(value="/update-product",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean updateProduct(@Valid @RequestBody ProductBean bean) {
		return service.editProduct(bean);
	}
	@PatchMapping(value="/remove-product",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean deleteProduct(@Valid @RequestParam int productId) {
		return service.deleteProduct(productId);
	}
	@GetMapping(value="/get-product",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean getProduct() {
		return service.getAllProduct();
	}
	@GetMapping(value="/get-active-product",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean getActiveProduct() {
		return service.getActiveProduct();
	}
	
}
