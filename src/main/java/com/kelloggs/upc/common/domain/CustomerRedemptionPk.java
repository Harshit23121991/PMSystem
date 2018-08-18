package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerRedemptionPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "pack_code_set_id")
	private int packCodeSetId;
	@Column(name = "promotion_code")
	private String promotionCode;

	public CustomerRedemptionPk() {
		// TODO Auto-generated constructor stub
	}

	public CustomerRedemptionPk(final int ipackCodeSetId, final String iCustomerId, final String iPromotionCode) {
		this.customerId = iCustomerId;
		this.packCodeSetId = ipackCodeSetId;
		this.promotionCode = iPromotionCode;
	}

	

	@Override
	public boolean equals(final Object arg0) {
		if (arg0 == null) {
			return false;
		}
		if (!(arg0 instanceof CustomerRedemptionPk)) {
			return false;
		}
		CustomerRedemptionPk arg1 = (CustomerRedemptionPk) arg0;
		return (this.packCodeSetId == arg1.getPackCodeSetId())
				&& (arg1.getCustomerId().equals(this.customerId))
				&& (arg1.getPromotionCode().equals(this.promotionCode));

	}

	@Override
	public int hashCode() {
		int code = 0;
		code += packCodeSetId;
		if (customerId != null) {
			code += customerId.hashCode();
		}
		if (promotionCode != null) {
			code += promotionCode.hashCode();
		}
		return code;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(final String iCustomerId) {
		this.customerId = iCustomerId;
	}

	public int getPackCodeSetId() {
		return packCodeSetId;
	}

	public void setPackCodeSetId(final int iPackCodeSetId) {
		this.packCodeSetId = iPackCodeSetId;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(final String iPromotionCode) {
		this.promotionCode = iPromotionCode;
	}
}