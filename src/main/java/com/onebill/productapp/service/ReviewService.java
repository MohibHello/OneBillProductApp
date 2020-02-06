package com.onebill.productapp.service;

import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.dto.ReviewBean;

public interface ReviewService {

	ResponseBean addReview(ReviewBean review);

	ResponseBean removeReview(int reviewId);

	ResponseBean getReview();
}
