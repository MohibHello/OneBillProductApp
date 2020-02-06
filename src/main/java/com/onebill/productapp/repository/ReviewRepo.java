package com.onebill.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onebill.productapp.dto.ReviewBean;

public interface ReviewRepo extends JpaRepository<ReviewBean, Integer> {

	@Query(value="select count(c) from CustomerBean c where c.customerId=:cid")
	Long existByCustomerId(@Param("cid")Integer cid);
	
	
}
