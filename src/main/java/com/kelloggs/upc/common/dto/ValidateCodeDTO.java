package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "PackCodeValidator", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("PackCodeValidator")
public class ValidateCodeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String promotionName;

	private String packCodeSetName;

	private Date startDate;

	private Date endDate;

	private boolean validStatus;

	private int redemStatus;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(final Date iStartDate) {
		this.startDate = iStartDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(final Date iEndDate) {
		this.endDate = iEndDate;
	}

	public boolean isValidStatus() {
		return validStatus;
	}

	public void setValidStatus(final boolean iValidStatus) {
		this.validStatus = iValidStatus;
	}

	public int isRedemStatus() {
		return redemStatus;
	}

	public void setRedemStatus(final int iRedemStatus) {
		this.redemStatus = iRedemStatus;
	}

}
