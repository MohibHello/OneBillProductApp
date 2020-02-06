package com.onebill.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onebill.productapp.dto.AddressBean;

public interface AddressRepo extends JpaRepository<AddressBean, Integer> {
	
	@Query(value="select count(customer_id) from customer where customer_id=:customerId",nativeQuery=true)
	Integer existByCustomerId(@Param("customerId")Integer customerId);
	
	@Query(value="select * from address a where a.customer_id=:cid",nativeQuery=true)
	List<AddressBean> findByCustomerId(@Param("cid")Integer cid);
	
}
