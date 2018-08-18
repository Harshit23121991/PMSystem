package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the product_sku_t database table.
 * 
 */
@Entity
@Table(name = "product_sku_t")
public class ProductSku implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_sku_id")
	private int productSkuId;

	@Column(name = "product_sku_code")
	private String productSkuCode;

	@Column(name = "product_sku_name")
	private String productSkuName;

	//bi-directional many-to-one association to Product
    @ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

    public ProductSku() {
    }

	public int getProductSkuId() {
		return this.productSkuId;
	}

	public void setProductSkuId(final int iProductSkuId) {
		this.productSkuId = iProductSkuId;
	}

	public String getProductSkuCode() {
		return this.productSkuCode;
	}

	public void setProductSkuCode(final String  iProductSkuCode) {
		this.productSkuCode = iProductSkuCode;
	}

	public String getProductSkuName() {
		return this.productSkuName;
	}

	public void setProductSkuName(final String iProductSkuName) {
		this.productSkuName = iProductSkuName;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(final Product iProduct) {
		this.product = iProduct;
	}
	
}