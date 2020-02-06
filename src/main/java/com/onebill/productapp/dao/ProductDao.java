package com.onebill.productapp.dao;

import java.util.List;
import java.util.Optional;

import com.onebill.productapp.dto.ProductBean;

public interface ProductDao {

	void saveOrUpdateProduct(ProductBean product);

	List<ProductBean> getAllProduct();

	List<ProductBean> getActiveProduct();
	
	boolean existsByProductCode(String productCode);
	
	boolean existsById(int productId);
	
	Optional<ProductBean> findById(int productId);
	
	List<ProductBean> findAll();
	
}
