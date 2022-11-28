package com.infy.ekart.dto;

import javax.validation.constraints.Null;

import com.sun.istack.NotNull;

public class SellerFeedbackDTO {
	
	@Null
	private Integer feedbackId;
	
	@NotNull
	private String sellerEmailId;
	
	@NotNull
	private Integer productDeliverySpeed;
	
	@NotNull
	private Integer productCondition;
	
	@NotNull
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
		SellerFeedbackDTO other = (SellerFeedbackDTO) obj;
		if (feedbackId == null) {
			if (other.feedbackId != null)
				return false;
		} else if (!feedbackId.equals(other.feedbackId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SellerFeedbackDTO [feedbackId=" + feedbackId + ", sellerEmailId=" + sellerEmailId
				+ ", productDeliverySpeed=" + productDeliverySpeed + ", productCondition=" + productCondition
				+ ", productPackaging=" + productPackaging + ", getFeedbackId()=" + getFeedbackId()
				+ ", getSellerEmailId()=" + getSellerEmailId() + ", getProductDeliverySpeed()="
				+ getProductDeliverySpeed() + ", getProductCondition()=" + getProductCondition()
				+ ", getProductPackaging()=" + getProductPackaging() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
