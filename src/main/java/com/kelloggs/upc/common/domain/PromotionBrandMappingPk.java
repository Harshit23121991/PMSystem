package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PromotionBrandMappingPk implements Serializable {
	

	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 8731182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Column(name = "brand_id")
	private int brandId;

	@Column(name = "promotion_id", unique = true)
	private String promotionId;

	
	// =================================================
	// Constructors
	// =================================================
	// =================================================
	// Overridden Methods
	// =================================================
	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(final int iBrandId) {
		this.brandId = iBrandId;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(final String iPromotionId) {
		this.promotionId = iPromotionId;
	}
	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================
	
}
