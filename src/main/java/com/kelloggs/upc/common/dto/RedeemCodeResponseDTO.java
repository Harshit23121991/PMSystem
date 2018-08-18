package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "RedeemCodeResponse", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("RedeemCodeResponse")
public class RedeemCodeResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String responseCode;
	private String responseMessage;
	private String promotionId;
	private List<Integer> brandIds;
	private int countryId;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(final String iResponseCode) {
		this.responseCode = iResponseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(final String iResponseMessage) {
		this.responseMessage = iResponseMessage;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(final int iCountryId) {
		this.countryId = iCountryId;
	}
	public List<Integer> getBrandIds() {
		return brandIds;
	}
	public void setBrandIds(final List<Integer> iBrandIds) {
		this.brandIds = iBrandIds;
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(final String iPromotionId) {
		this.promotionId = iPromotionId;
	}
}
