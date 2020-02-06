package com.onebill.productapp.service;


import com.onebill.productapp.dto.ProductBean;
import com.onebill.productapp.dto.ResponseBean;

public interface ProductService {

	ResponseBean addProduct(ProductBean product);

	ResponseBean editProduct(ProductBean product);

	ResponseBean deleteProduct(Integer productId);

	ResponseBean getAllProduct();

	ResponseBean getActiveProduct();
}
