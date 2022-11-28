package com.infy.ekart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EK_SELLER_FEEDBACK")
public class SellerFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackId;
	
	private String sellerEmailId;
	

	
	private Integer productDeliverySpeed;
	private Integer productCondition;
	private Integer productPackaging;
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public String getSellerEmailId() {
		return sellerEmailId;
	}
	public void setSellerEmailId(String sellerEmailId) {
		this.sellerEmailId = sellerEmailId;
	}
	
	public Integer getProductDeliverySpeed() {
		return productDeliverySpeed;
	}
	public void setProductDeliverySpeed(Integer productDeliverySpeed) {
		this.productDeliverySpeed = productDeliverySpeed;
	}
	public Integer getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(Integer productCondition) {
		this.productCondition = productCondition;
	}
	public Integer getProductPackaging() {
		return productPackaging;
	}
	public void setProductPackaging(Integer productPackaging) {
		this.productPackaging = productPackaging;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feedbackId == null) ? 0 : feedbackId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellerFeedback other = (SellerFeedback) obj;
		if (feedbackId == null) {
			if (other.feedbackId != null)
				return false;
		} else if (!feedbackId.equals(other.feedbackId))
			return false;
		return true;
	}
	
}
