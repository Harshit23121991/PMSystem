package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "promotion", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("promotion")
public class PromotionDTO implements Serializable {
	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 8761182207276505663L;

	// =================================================
	// Instance Variables
	// =================================================

	private int promotionID;

	private String promotionName;
	
	private String codePrefix;

	private CountryDTO country;

	private ProductTypeDTO productType;

	private String promotionCode;

	private boolean isPurgingReqd;

	private int purgeNoOfDays;
	
	private List<BrandDTO> brands;

	
	
	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(final String iPromotionCode) {
		this.promotionCode = iPromotionCode;
	}

	public int getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(final int iPromotionID) {
		this.promotionID = iPromotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(final String iPromotionName) {
		this.promotionName = iPromotionName;
	}
	
	public boolean isPurgingReqd() {
		return isPurgingReqd;
	}

	public void setPurgingReqd(final boolean iIsPurgingReqd) {
		this.isPurgingReqd = iIsPurgingReqd;
	}

	public int getPurgeNoOfDays() {
		return purgeNoOfDays;
	}

	public void setPurgeNoOfDays(final int iPurgeNoOfDays) {
		this.purgeNoOfDays = iPurgeNoOfDays;
	}

	public List<BrandDTO> getBrands() {
		return brands;
	}

	public void setBrands(final List<BrandDTO> iBrands) {
		this.brands = iBrands;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(final CountryDTO iCountry) {
		this.country = iCountry;
	}

	public ProductTypeDTO getProductType() {
		return productType;
	}

	public void setProductType(final ProductTypeDTO iProductType) {
		this.productType = iProductType;
	}

	public String getCodePrefix() {
		return codePrefix;
	}

	public void setCodePrefix(String codePrefix) {
		this.codePrefix = codePrefix;
	}
}
