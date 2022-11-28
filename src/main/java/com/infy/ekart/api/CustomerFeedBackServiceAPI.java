package com.infy.ekart.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.dto.AddressDTO;
import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.entity.ProductFeedback;
import com.infy.ekart.exception.EKartException;
import com.infy.ekart.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping(value = "/feedback-api")
@Validated
public class CustomerFeedBackServiceAPI {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private Environment environment;

	static Log logger = LogFactory.getLog(CustomerAPI.class);
	
	@GetMapping(value = "/productfeedbacks/")
	public ResponseEntity<ProductFeedback> productFeedbacks() throws EKartException {
		
//		AddressDTO addressDTO = customerService.getShippingAddress(addressId);
//		return new ResponseEntity<>(addressDTO, HttpStatus.OK);
		
		//ProductDTO
		
		return null;
		
	}

}
