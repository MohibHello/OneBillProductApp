package com.onebill.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.productapp.dao.ReviewDao;
import com.onebill.productapp.dto.ResponseBean;
import com.onebill.productapp.dto.ReviewBean;
import com.onebill.productapp.util.ResponseUtil;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao reviewDao;

	@Override
	public ResponseBean addReview(ReviewBean review) {

		ResponseBean response = null;
		try {
			if (reviewDao.existByCustomerId(review.getCustomerBean().getCustomerId())>0) {
				reviewDao.addReview(review);
				response = ResponseUtil.fillerSuccess("review added successfully");
			} else {
				response = ResponseUtil.fillerFailure("review id already exist ");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean removeReview(int reviewId) {
		ResponseBean response = null;
		try {
			if (reviewDao.existsById(reviewId)) {

				ReviewBean bean = reviewDao.findById(reviewId).get();

				reviewDao.removeReview(bean);
				response = ResponseUtil.fillerSuccess("review removed successfully");
			} else {
				response = ResponseUtil.fillerFailure("review not found");
			}
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getReview() {
		ResponseBean response = null;

		try {
			response = ResponseUtil.fillerSuccess("Review found");
			response.setReviewBeans(reviewDao.getReview());
		} catch (Exception e) {
			response = ResponseUtil.fillerException("Exception occured :-" + e.getMessage());
		}
		return response;
	}
}
