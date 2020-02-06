package com.onebill.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onebill.productapp.dto.CustomerBean;

public interface CustomerRepo extends JpaRepository<CustomerBean, Integer> {

	boolean existsByEmail(String email);
	
	@Query(value="select c from CustomerBean c where c.isActive=true")
	List<CustomerBean> getActiveCustomer();
	
	@Query(value="select c from CustomerBean c where c.email=:customerEmail")
	List<CustomerBean> getCustomer(@Param("customerEmail") String customerEmail);
	
}
