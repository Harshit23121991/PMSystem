package com.kelloggs.upc.common.dto;

public class ProductDTO {
	
	private String productId;
	
	private String productCode;
	
	private String productName;

	public String getProductId() {
		return productId;
	}

	public void setProductId(final String iProductId) {
		this.productId = iProductId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(final String iProductCode) {
		this.productCode = iProductCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(final String iProductName) {
		this.productName = iProductName;
	}


}
