package com.onebill.productapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dto.ProductBean;
import com.onebill.productapp.repository.ProductRepo;

import lombok.extern.java.Log;

@Log
@Service
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductRepo productRepository;

	@Override
	public void saveOrUpdateProduct(ProductBean product) {
		try {
			productRepository.save(product);
		} catch (Exception e) {
			log.severe("exception in DAO saveOrUpdateProduct(ProductBean product)" + e);
			throw e;
		}
	}

	@Override
	public List<ProductBean> getAllProduct() {
		try {
			return productRepository.findAll();
		} catch (Exception e) {
			log.severe("exception in DAO  getAllProduct()" + e);
			throw e;
		}
	}

	@Override
	public List<ProductBean> getActiveProduct() {
		try {
			return productRepository.getActiveProduct();
		} catch (Exception e) {
			log.severe("exception in DAO getActiveProduct()" + e);
			throw e;
		}
	}

	@Override
	public boolean existsByProductCode(String productCode) {
		try {
			return productRepository.existsByProductCode(productCode);
		} catch (Exception e) {
			log.severe("exception in DAO existsByProductCode(String productCode)" + e);
			throw e;
		}
	}

	@Override
	public boolean existsById(int productId) {
		try {
			return productRepository.existsById(productId);
		} catch (Exception e) {
			log.severe("exception in DAO existsById(productId)" + e);
			throw e;
		}
	}

	@Override
	public Optional<ProductBean> findById(int productId) {
		try {
			return productRepository.findById(productId);
		} catch (Exception e) {
			log.severe("exception in DAO findById(int productId)" + e);
			throw e;
		}
	}

	@Override
	public List<ProductBean> findAll() {
		try {
			return productRepository.findAll();
		} catch (Exception e) {
			log.severe("exception in DAO findById(int productId)" + e);
			throw e;
		}
	}
}
