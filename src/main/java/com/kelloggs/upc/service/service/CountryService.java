/**
 * CountryService.java
 */

package com.kelloggs.upc.service.service;

import java.util.List;

import com.kelloggs.upc.common.dto.CountriesDTO;
import com.kelloggs.upc.common.dto.CountryDTO;

public interface CountryService {

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
	 * This service is used to get a list of all Countries.
	 * 
	 * @param
	 * @return A List of CountryDTO
	 */
	public List<CountryDTO> getCountries();
	
	public CountriesDTO getCountries(String iCountryId, String iCountryCode);
	
	
	

	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================
}
