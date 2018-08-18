package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "redemptionInfo", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("redemptionInfo")
public class RedemptionInfoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String promotionName;
	private String packCodeSetName;
	private Date redemptionDate;
	private String promotionCode;

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(final String iPromotionName) {
		this.promotionName = iPromotionName;
	}

	public String getPackCodeSetName() {
		return packCodeSetName;
	}

	public void setPackCodeSetName(final String iPackCodeSetName) {
		this.packCodeSetName = iPackCodeSetName;
	}

	public Date getRedemptionDate() {
		return redemptionDate;
	}

	public void setRedemptionDate(final Date iRedemptionDate) {
		this.redemptionDate = iRedemptionDate;
	}
	
	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(final String iPromotionCode) {
		this.promotionCode = iPromotionCode;
	}

}
