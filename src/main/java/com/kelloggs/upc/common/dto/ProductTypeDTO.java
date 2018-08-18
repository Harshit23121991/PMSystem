package com.kelloggs.upc.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "ProductType", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("ProductType")
public class ProductTypeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int productTypeId;
	
	private String productTypeName;
	
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(final int iProductTypeId) {
		this.productTypeId = iProductTypeId;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(final String iProductTypeName) {
		this.productTypeName = iProductTypeName;
	}
}
