package com.onebill.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onebill.productapp.dto.OrderBean;

public interface OrderRepo extends JpaRepository<OrderBean, Integer> {

	@Query(value="select count(*) from customer where customer_id=:cid",nativeQuery=true)
	Integer existByCustomerId(@Param("cid")Integer cid);
}
