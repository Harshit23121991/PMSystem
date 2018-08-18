package com.kelloggs.upc.common.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pack_code_set_t")
public class Pack implements Serializable {
	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 8731182217277505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PACK_CODE_SET_ID", unique = true, insertable = true, updatable = false)
	private int packCodeSetID;

	@ManyToOne
	@JoinColumn(name = "PROMOTION_ID", insertable = true, updatable = true)
	private Promotion promotion;

	@Column(name = "PACK_CODE_SET_NAME", insertable = true, updatable = true)
	private String packCodeSetName;

	@Column(name = "PRODUCT_ID")
	private String productID;
	
	@Column(name = "BRAND_ID")
	private int brandID;

	@Column(name = "NO_OF_CODES")
	private int noOfCodes;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	// bi-directional many-to-one association to CustRedemption
	@OneToMany(mappedBy = "packCodeSet")
	private List<CustomerRedemption> custRedemptions;

	// bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

	// bi-directional many-to-one association to Batch
	@OneToMany(mappedBy = "packCodeSet")
	private List<Batch> promotionBatchs;

	public int getPackCodeSetID() {
		return packCodeSetID;
	}

	public void setPackCodeSetID(final int iPackCodeSetID) {
		this.packCodeSetID = iPackCodeSetID;
	}

	public String getPackCodeSetName() {
		return packCodeSetName;
	}

	public void setPackCodeSetName(final String iPackCodeSetName) {
		this.packCodeSetName = iPackCodeSetName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(final String iProductID) {
		this.productID = iProductID;
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

	public Promotion getPromotion() {
		return promotion;
	}
	
	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(final int iBrandID) {
		this.brandID = iBrandID;
	}

	public void setPromotion(final Promotion iPromotion) {
		this.promotion = iPromotion;
	}

	public List<Batch> getPromotionBatchs() {
		return promotionBatchs;
	}

	public void setPromotionBatchs(final List<Batch> iPromotionBatchs) {
		this.promotionBatchs = iPromotionBatchs;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(final ProductType iProductType) {
		this.productType = iProductType;
	}

	public List<CustomerRedemption> getCustRedemptions() {
		return custRedemptions;
	}

	public void setCustRedemptions(final List<CustomerRedemption> iCustRedemptions) {
		this.custRedemptions = iCustRedemptions;
	}

}