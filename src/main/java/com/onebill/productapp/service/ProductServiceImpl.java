package com.onebill.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dao.ProductDao;
import com.onebill.productapp.dto.ProductBean;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.util.ResponseUtil;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public ResponseBean addProduct(ProductBean product) {
		ResponseBean response = null;
		try {
			if (!productDao.existsByProductCode(product.getProductCode())) {
				product.setActive(true);
				productDao.saveOrUpdateProduct(product);
				response = ResponseUtil.fillerSuccess("product added successfully");
			} else {
				response = ResponseUtil.fillerFailure("product Code is not unique ");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean editProduct(ProductBean product) {
		ResponseBean response = null;
		try {
			if (productDao.existsById(product.getProductId())) {

				ProductBean bean = productDao.findById(product.getProductId()).get();
				if (product.getProductName() != null && !product.getProductName().trim().equals("")) {
					bean.setProductName(product.getProductName());
				}
				if (product.getProductCode() != null && !product.getProductName().trim().equals("")) {
					bean.setProductCode(product.getProductCode());
				}
				if (product.getPrice() != 0) {
					bean.setPrice(product.getPrice());
				}
				if (product.getQuantity() != 0) {
					bean.setQuantity(product.getQuantity());
				}
				if (product.getDescription() != null && !product.getDescription().trim().equals("")) {
					bean.setDescription(product.getDescription());
				}
				if (product.getRating() != 0) {
					bean.setRating(product.getRating());
				}

				productDao.saveOrUpdateProduct(product);
				response = ResponseUtil.fillerSuccess("product updated successfully");
			} else {
				response = ResponseUtil.fillerFailure("product not found ");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean deleteProduct(Integer productId) {
		ResponseBean response = null;
		try {
			if (productDao.existsById(productId)) {

				ProductBean bean = productDao.findById(productId).get();

				bean.setActive(false);

				productDao.saveOrUpdateProduct(bean);
				response = ResponseUtil.fillerSuccess("product deleted successfully");
			} else {
				response = ResponseUtil.fillerFailure("product not found");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getAllProduct() {
		ResponseBean response = null;

		try {
			response = ResponseUtil.fillerSuccess("Product found");
			response.setProductBeans(productDao.findAll());
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getActiveProduct() {
		ResponseBean response = null;

		try {
			List<ProductBean> productBeans = productDao.getActiveProduct();
			if(!productBeans.isEmpty()) {
			response = ResponseUtil.fillerSuccess("All Active product found");
			response.setProductBeans(productBeans);
			}
			else {
				response = ResponseUtil.fillerSuccess("No Active product found");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

}
