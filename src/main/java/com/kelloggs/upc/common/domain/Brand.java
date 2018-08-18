/**
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
 * @author brout
 * 
 */
@Entity
@Table(name = "brand_t")
public class Brand implements Serializable {
	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 8731182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BRAND_ID", unique = true, insertable = true, updatable = false)
	private int brandID;

	@Column(name = "BRAND_NAME")
	private String brandName;

	@Column(name = "BRAND_CODE")
	private String brandCode;

	
	//bi-directional many-to-one association to Country
    @ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "brand")
	private List<Product> products;

	/*//bi-directional many-to-many association to Promotion
	@ManyToMany(mappedBy = "brands", fetch = FetchType.EAGER)
	private List<Promotion> promotions;*/

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(final int iBrandID) {
		this.brandID = iBrandID;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(final String iBrandName) {
		this.brandName = iBrandName;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(final String iBrandCode) {
		this.brandCode = iBrandCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(final Country iCountry) {
		this.country = iCountry;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(final List<Product> iProducts) {
		this.products = iProducts;
	}

/*	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(final List<Promotion> iPromotions) {
		this.promotions = iPromotions;
	}
*/
}
