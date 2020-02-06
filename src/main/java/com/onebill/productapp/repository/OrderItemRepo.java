package com.onebill.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onebill.productapp.dto.OrderItemBean;

public interface OrderItemRepo extends JpaRepository<OrderItemBean, Integer> {

	@Query(value="select count(*) from order_product o where o.order_id=:oid",nativeQuery=true)
	Integer	existByOrderId(@Param("oid")Integer oid);
	
	@Query("select o from OrderItemBean o where o.orderBean.customerBean.customerId=:cid")
	List<OrderItemBean> getCustomerProducts(@Param("cid")Integer cid);
	
}
