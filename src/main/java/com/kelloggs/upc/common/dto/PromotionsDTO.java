package com.kelloggs.upc.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "promotions", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("promotions")
public class PromotionsDTO {

	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	
	private List<PromotionDTO> aPromotions;

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
	@XmlElement(name = "Promotion")
	public List<PromotionDTO> getaPromotions() {
		return aPromotions;
	}

	public void setaPromotions(final List<PromotionDTO> iPromotions) {
		this.aPromotions = iPromotions;
	}

}
