package com.kelloggs.upc.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kelloggs.upc.common.dto.CountryDTO;

@Repository
public interface CountryDAO extends BaseDao {
	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
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

	/**
	 * Fetch list of all countries
	 * 
	 * @param
	 * @return A List of CountryDTO's
	 */
	public List<CountryDTO> getCountries();
	public List<CountryDTO> getCountries(Integer iCountryId, String  iCountryCode);


	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================
}
