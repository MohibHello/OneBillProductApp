package com.onebill.productapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dto.ReviewBean;
import com.onebill.productapp.repository.ReviewRepo;

import lombok.extern.java.Log;

@Log
@Service
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	ReviewRepo reviewRepository;
	
	
	@Override
	public void addReview(ReviewBean review) {
		try {
			 reviewRepository.save(review);
		} catch (Exception e) {
			log.severe("exception in DAO  addReview(ReviewBean review)" + e);
			throw e;
		}
	}
	@Override
	public List<ReviewBean> getReview() {
		try {
			 return reviewRepository.findAll();
		} catch (Exception e) {
			log.severe("exception in DAO  addReview(ReviewBean review)" + e);
			throw e;
		}
	}
	@Override
	public void removeReview(ReviewBean review) {
		try {
			 reviewRepository.delete(review);
		} catch (Exception e) {
			log.severe("exception in DAO  removeReview(int reviewId)" + e);
			throw e;
		}
	}
	@Override
	public long existByCustomerId(int customerId) {
		try {
			return reviewRepository.existByCustomerId(customerId);
		} catch (Exception e) {
			log.severe("exception in DAO  existByCustomerId(int customerId)" + e);
			throw e;
		}
	}
	@Override
	public boolean existsById(int reviewId) {
		try {
			return reviewRepository.existsById(reviewId);
		} catch (Exception e) {
			log.severe("exception in DAO  existsById(int reviewId)" + e);
			throw e;
		}
	}
	@Override
	public Optional<ReviewBean> findById(int reviewId) {
		try {
			return reviewRepository.findById(reviewId);
		} catch (Exception e) {
			log.severe("exception in DAO findById(int reviewId)" + e);
			throw e;
		}
	}
}
