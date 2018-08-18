package com.kelloggs.upc.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;


	

@XmlRootElement(name = "productTypes", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("productTypes")
public class ProductTypesDTO {
	
	
	private List<ProductTypeDTO> aProductTypes;
	
	@XmlElement(name = "ProductType")
	public List<ProductTypeDTO> getaProductTypes() {
		return aProductTypes;
	}

	public void setaProductTypes(final List<ProductTypeDTO> iProductTypes) {
		this.aProductTypes = iProductTypes;
	}
	
}
