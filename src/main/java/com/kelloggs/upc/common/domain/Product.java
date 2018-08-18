package com.kelloggs.upc.common.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the product_t database table.
 * 
 */
@Entity
@Table(name = "product_t")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_name")
	private String productName;

	//bi-directional many-to-one association to ProductSku
	@OneToMany(mappedBy = "product")
	private List<ProductSku> productSkus;

	//bi-directional many-to-one association to Brand
    @ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

    public Product() {
    }

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(final int iProductId) {
		this.productId = iProductId;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(final String iProductCode) {
		this.productCode = iProductCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(final String iProductName) {
		this.productName = iProductName;
	}

	public List<ProductSku> getProductSkus() {
		return this.productSkus;
	}

	public void setProductSkus(final List<ProductSku> iProductSkus) {
		this.productSkus = iProductSkus;
	}
	
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(final Brand iBrand) {
		this.brand = iBrand;
	}
	
}