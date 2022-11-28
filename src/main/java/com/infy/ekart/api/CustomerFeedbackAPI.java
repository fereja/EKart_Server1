package com.infy.ekart.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.dto.CustomerDTO;
import com.infy.ekart.dto.OrderDTO;
import com.infy.ekart.dto.ProductFeedbackDTO;
import com.infy.ekart.dto.SellerFeedbackDTO;
import com.infy.ekart.exception.EKartException;
import com.infy.ekart.service.CustomerFeedbackServiceImpl;

@RestController
@RequestMapping("/feedback-api")
@CrossOrigin
@Validated
public class CustomerFeedbackAPI {
	
	@Autowired
	private CustomerFeedbackServiceImpl customerFeedbackService;
	
	@GetMapping("/productFeedbacks/{customerEmail}/customer")
	public ResponseEntity<List<ProductFeedbackDTO>> productFeedbacks(@PathVariable("customerEmail") String customerEmail) throws EKartException{
		List<ProductFeedbackDTO> productFeedbacks = customerFeedbackService.getAllProductFeedback(customerEmail);
		return new ResponseEntity<List<ProductFeedbackDTO>>(productFeedbacks, HttpStatus.OK);
	}
	
	@GetMapping("/orders/{customerEmail}/customer")
	public ResponseEntity<CustomerDTO> getAllOrders(@PathVariable("customerEmail") String customerEmail) throws EKartException {
		List<OrderDTO> orderDTOs = customerFeedbackService.getAllOrders(customerEmail);
		List<ProductFeedbackDTO> productFeedbackDTOs = customerFeedbackService.getAllProductFeedback(customerEmail);
		List<SellerFeedbackDTO> sellerFeedbackDTOs = customerFeedbackService.getAllSellerFeedback(customerEmail);
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setOrders(orderDTOs);
		customerDTO.setProductFeedbackList(productFeedbackDTOs);
		customerDTO.setSellerFeedbackList(sellerFeedbackDTOs);
		return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
	}
	
	
	@PostMapping("/productFeedbacks/{customerEmail}/customer")
	public ResponseEntity<ProductFeedbackDTO> postProductFeedback(@Valid @RequestBody ProductFeedbackDTO productFeedbackDTO, @PathVariable("customerEmail") String customerEmail) throws EKartException {
		ProductFeedbackDTO returnedFeedbackDTO = customerFeedbackService.addProductFeedback(productFeedbackDTO, customerEmail);
		return new ResponseEntity<ProductFeedbackDTO>(returnedFeedbackDTO, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/sellerFeedbacks/{customerEmail}/customer")
	public ResponseEntity<SellerFeedbackDTO> postSellerFeedback(@Valid @RequestBody SellerFeedbackDTO sellerFeedbackDTO, @PathVariable("customerEmail") String customerEmail) throws EKartException {
		SellerFeedbackDTO returnedFeedbackDTO = customerFeedbackService.addSellerFeedback(sellerFeedbackDTO, customerEmail);
		return new ResponseEntity<SellerFeedbackDTO>(returnedFeedbackDTO, HttpStatus.CREATED);
	}
}
