package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "promotion_brand_mapping_t")
public class PromotionBrandMapping implements Serializable {
	

	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 8731182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Id
	private PromotionBrandMappingPk id;

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
	public PromotionBrandMappingPk getId() {
		return id;
	}

	public void setId(final PromotionBrandMappingPk iId) {
		id = iId;
	}
	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================
	
}
