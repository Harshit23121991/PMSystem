/*
 * Copyright (c) 2014, Cluster India.
 * 
 */
package com.kelloggs.upc.common.domain;

import java.io.Serializable;
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


/**
 * The Class Promotion.
 */
@Entity
@Table(name = "promotion_t")
public class Promotion implements Serializable
{
	// =================================================
	// Class Variables
	// =================================================
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8761182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	/** The promotion id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROMOTION_ID", unique = true, insertable = true, updatable = false)
	private int promotionID;

	/** The promotion name. */
	@Column(name = "PROMOTION_NAME")
	private String promotionName;

	/** The promotion code. */
	@Column(name = "PROMOTION_CODE", insertable = true, updatable = true)
	private String promotionCode;

	/** The is purging reqd. */
	@Column(name = "IS_PURGING_REQD")
	private boolean isPurgingReqd;

	/** The purge no of days. */
	@Column(name = "PURGE_NO_OF_DAYS", insertable = true, updatable = true)
	private int purgeNoOfDays;

	//bi-directional many-to-one association to Pack
	/** The pack code sets. */
	@OneToMany(mappedBy = "promotion")
	private List<Pack> packCodeSets;

	/*
	 * //bi-directional many-to-many association to Brand
	 * 
	 * @ManyToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinTable( name = "promotion_brand_mapping_t" , joinColumns = {
	 * 
	 * @JoinColumn(name = "promotion_id") } , inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "brand_id") } )
	 * 
	 * private List<Brand> brands;
	 */

	//bi-directional many-to-one association to Country
	/** The country. */
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	//bi-directional many-to-one association to ProductType
	/** The product type. */
	@ManyToOne
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

	/** The code prefix. */
	@Column(name = "CODE_PREFIX", insertable = true, updatable = true)
	private String codePrefix;

	/**
	 * Gets the promotion id.
	 * 
	 * @return the promotion id
	 */
	public int getPromotionID()
	{
		return promotionID;
	}

	/**
	 * Sets the promotion id.
	 * 
	 * @param iPromotionID
	 *           the new promotion id
	 */
	public void setPromotionID(final int iPromotionID)
	{
		this.promotionID = iPromotionID;
	}

	/**
	 * Gets the promotion name.
	 * 
	 * @return the promotion name
	 */
	public String getPromotionName()
	{
		return promotionName;
	}

	/**
	 * Sets the promotion name.
	 * 
	 * @param iPromotionName
	 *           the new promotion name
	 */
	public void setPromotionName(final String iPromotionName)
	{
		this.promotionName = iPromotionName;
	}

	/**
	 * Gets the promotion code.
	 * 
	 * @return the promotion code
	 */
	public String getPromotionCode()
	{
		return promotionCode;
	}

	/**
	 * Sets the promotion code.
	 * 
	 * @param iPromotionCode
	 *           the new promotion code
	 */
	public void setPromotionCode(final String iPromotionCode)
	{
		this.promotionCode = iPromotionCode;
	}

	/**
	 * Checks if is purging reqd.
	 * 
	 * @return true, if is purging reqd
	 */
	public boolean isPurgingReqd()
	{
		return isPurgingReqd;
	}

	/**
	 * Sets the purging reqd.
	 * 
	 * @param iIsPurgingReqd
	 *           the new purging reqd
	 */
	public void setPurgingReqd(final boolean iIsPurgingReqd)
	{
		this.isPurgingReqd = iIsPurgingReqd;
	}

	/**
	 * Gets the purge no of days.
	 * 
	 * @return the purge no of days
	 */
	public int getPurgeNoOfDays()
	{
		return purgeNoOfDays;
	}

	/**
	 * Sets the purge no of days.
	 * 
	 * @param iPurgeNoOfDays
	 *           the new purge no of days
	 */
	public void setPurgeNoOfDays(final int iPurgeNoOfDays)
	{
		this.purgeNoOfDays = iPurgeNoOfDays;
	}

	/**
	 * Gets the pack code sets.
	 * 
	 * @return the pack code sets
	 */
	public List<Pack> getPackCodeSets()
	{
		return packCodeSets;
	}

	/**
	 * Sets the pack code sets.
	 * 
	 * @param ipackCodeSets
	 *           the new pack code sets
	 */
	public void setPackCodeSets(final List<Pack> ipackCodeSets)
	{
		this.packCodeSets = ipackCodeSets;
	}

	/*
	 * public List<Brand> getBrands() { return brands; }
	 * 
	 * public void setBrands(final List<Brand> iBrands) { this.brands = iBrands; }
	 */

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public Country getCountry()
	{
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param iCountry
	 *           the new country
	 */
	public void setCountry(final Country iCountry)
	{
		this.country = iCountry;
	}

	/**
	 * Gets the product type.
	 * 
	 * @return the product type
	 */
	public ProductType getProductType()
	{
		return productType;
	}

	/**
	 * Sets the product type.
	 * 
	 * @param iProductType
	 *           the new product type
	 */
	public void setProductType(final ProductType iProductType)
	{
		this.productType = iProductType;
	}

	/**
	 * Gets the code prefix.
	 * 
	 * @return the code prefix
	 */
	public String getCodePrefix()
	{
		return codePrefix;
	}

	/**
	 * Sets the code prefix.
	 * 
	 * @param codePrefix
	 *           the new code prefix
	 */
	public void setCodePrefix(final String codePrefix)
	{
		this.codePrefix = codePrefix;
	}

}
