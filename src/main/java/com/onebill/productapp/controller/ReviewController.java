package com.onebill.productapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.dto.ReviewBean;
import com.onebill.productapp.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	ReviewService service;
	
	@PostMapping(value="/add-review",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean addReview(@Valid @RequestBody ReviewBean bean) {
		return service.addReview(bean);
	}
	@DeleteMapping(value="/remove-review",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseBean deleteReview(@Valid @RequestParam Integer bean) {
		return service.removeReview(bean);
	}
	@GetMapping(value="/get-review",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getReview() {
	return service.getReview();
	}
}
