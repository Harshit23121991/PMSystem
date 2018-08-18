package com.kelloggs.upc.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "brands", namespace = "com.kelloggs.upc.common.dto")
//@XStreamAlias("brands")
public class BrandsDTO {
	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	//@XmlElement(name = "Brand")
	private List<BrandDTO> aBrands;

	// =================================================
	// Constructors
	// =================================================
	// =================================================
	// Overridden Methods
	// =================================================
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
	@XmlElement(name = "Brand")
	public List<BrandDTO> getaBrands() {
		return aBrands;
	}

	public void setaBrands(final List<BrandDTO> iBrands) {
		this.aBrands = iBrands;
	}

}
