package com.kelloggs.upc.common.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country_t")
public class Country implements Serializable {
	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 8731182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Id
	@Column(name = "COUNTRY_ID", unique = true, insertable = true, updatable = false)
	private int countryID;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@Column(name = "COUNTRY_CODE", unique = true, insertable = true, updatable = false)
	private String countryCode;

	// bi-directional many-to-one association to Brand
	@OneToMany(mappedBy = "country")
	private List<Brand> brands;

	// bi-directional many-to-one association to Promotion
	@OneToMany(mappedBy = "country")
	private List<Promotion> promotions;

	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="countryID", referencedColumnName = "countryID") private
	 * Set<Brand> brands;
	 */

	// =================================================
	// Constructors @JoinTable(name = "brand_t", joinColumns = {
	// @JoinColumn(name = "COUNTRY_ID") }, inverseJoinColumns = {
	// @JoinColumn(name = "COUNTRY_ID") })
	// =================================================
	// =================================================
	// Overridden Methods
	// =================================================
	@Override
	public boolean equals(final Object arg0) {
		if (arg0 == null) {
			return false;
		}
		if (!(arg0 instanceof Country)) {
			return false;
		}
		Country arg1 = (Country) arg0;
		return (this.countryID == arg1.getCountryID())
				&& (arg1.getCountryName().equals(this.countryName))
				&& (arg1.getCountryCode().equals(this.countryCode));

	}

	@Override
	public int hashCode() {
		int code = 0;
		code += countryID;
		if (countryName != null) {
			code += countryName.hashCode();
		}
		if (countryCode != null) {
			code += countryCode.hashCode();
		}
		return code;
	}
	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================
	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================

	public int getCountryID() {
		return countryID;
	}

	/*
	 * public Set<Brand> getBrands() { return brands; }
	 * 
	 * public void setBrands(Set<Brand> brands) { this.brands = brands; }
	 */
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(final String iCountryCode) {
		this.countryCode = iCountryCode;
	}

	public void setCountryID(final int iCountryID) {
		this.countryID = iCountryID;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(final String iName) {
		this.countryName = iName;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(final List<Brand> iBrands) {
		this.brands = iBrands;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(final List<Promotion> iPromotions) {
		this.promotions = iPromotions;
	}
}
