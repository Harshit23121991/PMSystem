package com.kelloggs.upc.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "CustomerRedemption", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("CustomerRedemption")
public class CustomerRedemptionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String packCodeName;
	private String promotionName;
	private String redemptionDate;
	private String customerId;
	private String promotionCode;
	

	public String getPackCodeName() {
		return packCodeName;
	}
	public void setPackCodeName(final String iPackCodeName) {
		this.packCodeName = iPackCodeName;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(final String iPromotionName) {
		this.promotionName = iPromotionName;
	}
	public String getRedemptionDate() {
		return redemptionDate;
	}
	public void setRedemptionDate(final String iRredemptionDate) {
		this.redemptionDate = iRredemptionDate;
	}	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPromotionCode() {
		return promotionCode;
	}
	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}
	
}
