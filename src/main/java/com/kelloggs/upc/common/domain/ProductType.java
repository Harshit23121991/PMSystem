package com.kelloggs.upc.common.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the product_type_t database table.
 * 
 */
@Entity
@Table(name = "product_type_t")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_type_id")
	private int productTypeId;

	@Column(name = "product_type_name")
	private String productTypeName;

	//bi-directional many-to-one association to Pack
	@OneToMany(mappedBy = "productType")
	private List<Pack> packCodeSets;

	//bi-directional many-to-one association to Promotion
	@OneToMany(mappedBy = "productType")
	private List<Promotion> promotions;

    public ProductType() {
    }


	public String getProductTypeName() {
		return this.productTypeName;
	}

	public void setProductTypeName(final String iProductTypeName) {
		this.productTypeName = iProductTypeName;
	}

	public List<Pack> getPackCodeSets() {
		return this.packCodeSets;
	}

	public void setPackCodeSets(final List<Pack> iPackCodeSets) {
		this.packCodeSets = iPackCodeSets;
	}
	
	public List<Promotion> getPromotions() {
		return this.promotions;
	}

	public void setPromotions(final List<Promotion> iPromotions) {
		this.promotions = iPromotions;
	}


	public int getProductTypeId() {
		return productTypeId;
	}


	public void setProductTypeId(final int iProductTypeId) {
		this.productTypeId = iProductTypeId;
	}
	
}