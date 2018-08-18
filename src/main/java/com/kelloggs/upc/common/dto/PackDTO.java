package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XmlRootElement(name = "pack", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("pack")
public class PackDTO implements Serializable {
	
	private static final long serialVersionUID = 2818020343212551189L;
	
	private CountryDTO country;
	
	private BrandDTO brand;
	
	private int packCodeSetID;

	private PromotionDTO promotion;
		
	private String packCodeSetName;

	private ProductTypeDTO productType;

	private ProductDTO product;

	private int noOfCodes;
	
	private Date startDate;

	private Date endDate;
	

	

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(final BrandDTO iBrand) {
		this.brand = iBrand;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(final CountryDTO iCountry) {
		this.country = iCountry;
	}

	public int getPackCodeSetID() {
		return packCodeSetID;
	}

	public void setPackCodeSetID(final int iPackCodeSetID) {
		this.packCodeSetID = iPackCodeSetID;
	}

	public PromotionDTO getPromotion() {
		return promotion;
	}

	public void setPromotion(final PromotionDTO iPromotion) {
		this.promotion = iPromotion;
	}

	public String getPackCodeSetName() {
		return packCodeSetName;
	}

	public void setPackCodeSetName(final String iPackCodeSetName) {
		this.packCodeSetName = iPackCodeSetName;
	}

	public ProductTypeDTO getProductType() {
		return productType;
	}

	public void setProductType(final ProductTypeDTO iProductType) {
		this.productType = iProductType;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(final ProductDTO iProduct) {
		this.product = iProduct;
	}

	public int getNoOfCodes() {
		return noOfCodes;
	}

	public void setNoOfCodes(final int iNoOfCodes) {
		this.noOfCodes = iNoOfCodes;
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
	
	
	


}
