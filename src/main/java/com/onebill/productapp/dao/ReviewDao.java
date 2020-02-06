package com.onebill.productapp.dao;

import java.util.List;
import java.util.Optional;

import com.onebill.productapp.dto.ReviewBean;

public interface ReviewDao {

	void addReview(ReviewBean review);

	void removeReview(ReviewBean review);

	List<ReviewBean> getReview();

	long existByCustomerId(int customerId);
	
	boolean existsById(int reviewId);
	
	Optional<ReviewBean> findById(int reviewId);
}
