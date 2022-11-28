package com.infy.ekart.service;

import java.util.List;

import com.infy.ekart.dto.OrderDTO;
import com.infy.ekart.dto.ProductFeedbackDTO;
import com.infy.ekart.dto.SellerFeedbackDTO;
import com.infy.ekart.exception.EKartException;

public interface CustomerFeedbackService {
	List<ProductFeedbackDTO> getAllProductFeedback(String customerEmail) throws EKartException;
	List<SellerFeedbackDTO> getAllSellerFeedback(String customerEmail) throws EKartException;
	//in user story 1, we have to disable feedback buttons for sellers and products for whom
	//we have already done the feedback.
	//where do we get all orders of a customer from?
	List<OrderDTO> getAllOrders(String customerEmail) throws EKartException;
	
	
	ProductFeedbackDTO addProductFeedback(ProductFeedbackDTO productFeedbackDTO, String customerEmail) throws EKartException;
	SellerFeedbackDTO addSellerFeedback(SellerFeedbackDTO sellerFeedbackDTO, String customerEmail) throws EKartException;
}
