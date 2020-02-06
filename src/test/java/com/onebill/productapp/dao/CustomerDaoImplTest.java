package com.onebill.productapp.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onebill.productapp.dto.CustomerBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.service.CustomerService;
import com.onebill.productapp.util.ResponseUtil;


@SpringBootTest
@RunWith(JUnit4ClassRunner.class)
public class CustomerDaoImplTest {
	
	@Autowired
    CustomerService service;
    
    @Test
	public void saveOrUpdateCustomer(CustomerBean customer) {
		
		CustomerBean customerBean=new CustomerBean();
		customerBean.setActive(true);
		customerBean.setEmail("working@qas.com");
		customerBean.setFirstName("kiran");
		customerBean.setLastName("k");
		customerBean.setPhone("+917766884512");
		
		ResponseBean actual=service.addCustomer(customerBean);
		
		ResponseBean expected=ResponseUtil.fillerSuccess("customer added successfully");
		
		assertEquals(expected, actual);
	}
}
