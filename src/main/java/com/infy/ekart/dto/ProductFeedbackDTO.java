package com.infy.ekart.dto;

import javax.validation.constraints.Null;

import com.sun.istack.NotNull;

public class ProductFeedbackDTO {
	
	@Null
	private Integer feedbackId;
	
	@NotNull
	private String productId;

	@NotNull
	private Double productSatisfaction;
	
	@NotNull
	private Double productDescriptionMatch;
	
	@NotNull
	private Double productRecommendation;
	
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	
	public Double getProductSatisfaction() {
		return productSatisfaction;
	}
	public void setProductSatisfaction(Double productSatisfaction) {
		this.productSatisfaction = productSatisfaction;
	}
	public Double getProductDescriptionMatch() {
		return productDescriptionMatch;
	}
	public void setProductDescriptionMatch(Double productDescriptionMatch) {
		this.productDescriptionMatch = productDescriptionMatch;
	}
	public Double getProductRecommendation() {
		return productRecommendation;
	}
	public void setProductRecommendation(Double productRecommendation) {
		this.productRecommendation = productRecommendation;
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
		ProductFeedbackDTO other = (ProductFeedbackDTO) obj;
		if (feedbackId == null) {
			if (other.feedbackId != null)
				return false;
		} else if (!feedbackId.equals(other.feedbackId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductFeedbackDTO [feedbackId=" + feedbackId + ", productId=" + productId + ", productSatisfaction="
				+ productSatisfaction + ", productDescriptionMatch=" + productDescriptionMatch
				+ ", productRecommendation=" + productRecommendation + ", getFeedbackId()=" + getFeedbackId()
				+ ", getProductId()=" + getProductId() + ", getProductSatisfaction()=" + getProductSatisfaction()
				+ ", getProductDescriptionMatch()=" + getProductDescriptionMatch() + ", getProductRecommendation()="
				+ getProductRecommendation() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
