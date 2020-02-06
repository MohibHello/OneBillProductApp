package com.onebill.productapp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBean {

	@NotNull
	private int statusCode;
	@NotNull
	private String message;
	@NotNull
	private String description;

	private List<AddressBean> addressBeans;

	private List<CustomerBean> customerBeans;

	private List<OrderBean> orderBeans;

	private List<ProductBean> productBeans;

	private List<ReviewBean> reviewBeans;

	private List<OrderItemBean> orderItemBeans;
}
