package com.infy.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.ekart.dto.CustomerDTO;
import com.infy.ekart.dto.OrderDTO;
import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.dto.ProductFeedbackDTO;
import com.infy.ekart.dto.SellerFeedbackDTO;
import com.infy.ekart.entity.Customer;
import com.infy.ekart.entity.Order;
import com.infy.ekart.entity.Product;
import com.infy.ekart.entity.ProductFeedback;
import com.infy.ekart.entity.SellerFeedback;
import com.infy.ekart.exception.EKartException;
import com.infy.ekart.repository.CustomerRepository;
import com.infy.ekart.repository.ProductFeedbackRepository;
import com.infy.ekart.repository.SellerFeedbackRepository;

@Service(value = "customerFeedbackService")
@Transactional
public class CustomerFeedbackServiceImpl implements CustomerFeedbackService{

	@Autowired
	private ProductFeedbackRepository productFeedbackRepository;
	
	@Autowired
	private SellerFeedbackRepository sellerFeedbackRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	private static ProductFeedbackDTO toProductFeedbackDTO(ProductFeedback productFeedback) {
		ProductFeedbackDTO productFeedbackDTO = new ProductFeedbackDTO();
		productFeedbackDTO.setFeedbackId(productFeedback.getFeedbackId());
		productFeedbackDTO.setProductDescriptionMatch(productFeedback.getProductDescriptionMatch());
		productFeedbackDTO.setProductId(productFeedback.getProductId());
		productFeedbackDTO.setProductRecommendation(productFeedback.getProductRecommendation());
		productFeedbackDTO.setProductSatisfaction(productFeedback.getProductSatisfaction());
		return productFeedbackDTO;
	}
	
	private static SellerFeedbackDTO toSellerFeedbackDTO(SellerFeedback sellerFeedback) {
		SellerFeedbackDTO sellerFeedbackDTO = new SellerFeedbackDTO();
		sellerFeedbackDTO.setFeedbackId(sellerFeedback.getFeedbackId());
		sellerFeedbackDTO.setProductCondition(sellerFeedback.getProductCondition());
		sellerFeedbackDTO.setProductDeliverySpeed(sellerFeedback.getProductDeliverySpeed());
		sellerFeedbackDTO.setProductPackaging(sellerFeedback.getProductPackaging());
		sellerFeedbackDTO.setSellerEmailId(sellerFeedback.getSellerEmailId());
		return sellerFeedbackDTO;
	}
	
	private static OrderDTO toOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setAddressId(order.getAddressId());
		orderDTO.setDataOfDelivery(order.getDataOfDelivery());
		orderDTO.setDateOfOrder(order.getDateOfOrder());
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setTotalPrice(order.getTotalPrice());
		orderDTO.setOrderNumber(order.getOrderNumber());
		orderDTO.setQuantity(order.getQuantity());
		orderDTO.setPaymentThrough(order.getPaymentThrough());
		orderDTO.setOrderStatus(order.getOrderStatus().toString());
		Product product = order.getProduct();
		if(product != null) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setSellerEmailId(product.getSellerEmailId());
			productDTO.setBrand(product.getBrand());
			productDTO.setCategory(product.getCategory());
			productDTO.setDescription(product.getDescription());
			productDTO.setDiscount(product.getDiscount());
			productDTO.setName(product.getName());
			productDTO.setProductId(product.getProductId());
			productDTO.setQuantity(product.getQuantity());
			orderDTO.setProduct(productDTO);
		}
		return orderDTO;
		
	}
	
	@Override
	public List<ProductFeedbackDTO> getAllProductFeedback(String customerEmail) throws EKartException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(customerEmail).orElseThrow(() -> new EKartException("SERVICE.CAN_NOT_FIND_CUSTOMER"));
		List<ProductFeedbackDTO> productFeedbackDTOs = customer.getProductFeedbackList().stream()
				.map(CustomerFeedbackServiceImpl::toProductFeedbackDTO)
				.collect(Collectors.toList());
		return productFeedbackDTOs;
	}

	@Override
	public List<SellerFeedbackDTO> getAllSellerFeedback(String customerEmail) throws EKartException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(customerEmail).orElseThrow(() -> new EKartException("SERVICE.CAN_NOT_FIND_CUSTOMER"));
		List<SellerFeedbackDTO> sellerFeedbackDTOs = customer.getSellerFeedbackList().stream()
				.map(CustomerFeedbackServiceImpl::toSellerFeedbackDTO)
				.collect(Collectors.toList());
		return sellerFeedbackDTOs;
	}

	@Override
	public List<OrderDTO> getAllOrders(String customerEmail) throws EKartException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(customerEmail).orElseThrow(() -> new EKartException("SERVICE.CAN_NOT_FIND_CUSTOMER"));
		List<OrderDTO> orderDTOs =customer.getOrders().stream()
				.map(CustomerFeedbackServiceImpl::toOrderDTO)
				.collect(Collectors.toList());
		return orderDTOs;
	}

	private static ProductFeedback toProductFeedback(ProductFeedbackDTO productFeedbackDTO) {
		ProductFeedback productFeedback = new ProductFeedback();
		productFeedback.setProductDescriptionMatch(productFeedbackDTO.getProductDescriptionMatch());
		productFeedback.setProductRecommendation(productFeedbackDTO.getProductRecommendation());
		productFeedback.setProductSatisfaction(productFeedbackDTO.getProductSatisfaction());
		productFeedback.setProductId(productFeedbackDTO.getProductId());
		return productFeedback;
	}
	
	private static SellerFeedback toSellerFeedback(SellerFeedbackDTO sellerFeedbackDTO) {
		SellerFeedback sellerFeedback = new SellerFeedback();
		sellerFeedback.setProductCondition(sellerFeedbackDTO.getProductCondition());
		sellerFeedback.setProductDeliverySpeed(sellerFeedbackDTO.getProductDeliverySpeed());
		sellerFeedback.setProductPackaging(sellerFeedbackDTO.getProductPackaging());
		sellerFeedback.setSellerEmailId(sellerFeedbackDTO.getSellerEmailId());
		return sellerFeedback;
	}
	
	@Override
	public ProductFeedbackDTO addProductFeedback(ProductFeedbackDTO productFeedbackDTO, String customerEmail) throws EKartException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(customerEmail).orElseThrow(() -> new EKartException("SERVICE.CAN_NOT_FIND_CUSTOMER"));
		List<ProductFeedback> productFeedbackList = customer.getProductFeedbackList();
		
		if(productFeedbackList == null) {
			productFeedbackList = new ArrayList<ProductFeedback>();
			customer.setProductFeedbackList(productFeedbackList);
		}
		
		//check if productFeedbackList contains productId
		List<ProductFeedback> filteredProductFeedback = productFeedbackList.stream()
				.filter(productFeedback -> productFeedback.getProductId().equals(productFeedbackDTO.getProductId()))
				.collect(Collectors.toList());
		
		if(!filteredProductFeedback.isEmpty()) {
			throw new EKartException("SERVICE.PRODUCT_ALREADY_REVIEWED_BY_CUSTOMER");
		}
		
		
		
		ProductFeedback productFeedback = toProductFeedback(productFeedbackDTO);
		productFeedbackRepository.save(productFeedback);
		
		productFeedbackList.add(productFeedback);
		customer.setProductFeedbackList(productFeedbackList);
		System.out.println(productFeedback);
		return toProductFeedbackDTO(productFeedback);
	}

	@Override
	public SellerFeedbackDTO addSellerFeedback(SellerFeedbackDTO sellerFeedbackDTO, String customerEmail) throws EKartException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(customerEmail).orElseThrow(() -> new EKartException("SERVICE.CAN_NOT_FIND_CUSTOMER"));
		List<SellerFeedback> sellerFeedbackList = customer.getSellerFeedbackList();
		
		if(sellerFeedbackList == null) {
			sellerFeedbackList = new ArrayList<SellerFeedback>();
			customer.setSellerFeedbackList(sellerFeedbackList);
		}
		
		List<SellerFeedback> filteredFeedback = sellerFeedbackList.stream()
				.filter(sellerFeedback -> sellerFeedback.getSellerEmailId().equals(sellerFeedbackDTO.getSellerEmailId()))
				.collect(Collectors.toList());
		
		if(!filteredFeedback.isEmpty()) {
			throw new EKartException("SERVICE.SELLER_ALREADY_REVIEWED_BY_CUSTOMER");
		}
		
		
		
		SellerFeedback sellerFeedback = toSellerFeedback(sellerFeedbackDTO);
		sellerFeedbackRepository.save(sellerFeedback);
		
		sellerFeedbackList.add(sellerFeedback);
		return toSellerFeedbackDTO(sellerFeedback);
	}
	
	
}
