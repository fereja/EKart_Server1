package com.infy.ekart.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EK_PRODUCT_FEEDBACK")
public class ProductFeedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackId;
	
	private String productId;
	
	private Double productSatisfaction;
	
	@Column(name = "PRODUCT_DSCR_MATCH")
	private Double productDescriptionMatch;
	
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
		ProductFeedback other = (ProductFeedback) obj;
		if (feedbackId == null) {
			if (other.feedbackId != null)
				return false;
		} else if (!feedbackId.equals(other.feedbackId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ProductFeedback [feedbackId=" + feedbackId + ", productId=" + productId + ", productSatisfaction="
				+ productSatisfaction + ", productDescriptionMatch=" + productDescriptionMatch
				+ ", productRecommendation=" + productRecommendation + "]";
	}
	
	
}
