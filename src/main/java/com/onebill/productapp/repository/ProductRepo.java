package com.onebill.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onebill.productapp.dto.ProductBean;

public interface ProductRepo extends JpaRepository<ProductBean, Integer> {

	
	@Query(value = "select p from ProductBean p where p.isActive=true")
	List<ProductBean> getActiveProduct();

	boolean existsByProductCode(String pid);
}
