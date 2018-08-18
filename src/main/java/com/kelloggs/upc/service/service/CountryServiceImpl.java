/**
 * CountryServiceImpl.java
 */

package com.kelloggs.upc.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelloggs.upc.common.constants.UPCErrorConstants;
import com.kelloggs.upc.common.dto.CountriesDTO;
import com.kelloggs.upc.common.dto.CountryDTO;
import com.kelloggs.upc.common.exception.UPCException;
import com.kelloggs.upc.service.dao.CountryDAO;

@Service
public class CountryServiceImpl implements CountryService {

	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	@Autowired
	private CountryDAO countryDao;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.service.CountryService#getCountries()
	 */
	public List<CountryDTO> getCountries() {
		List<CountryDTO> aReturnValue = null;
		aReturnValue = countryDao.getCountries();
		return aReturnValue;
	}

	public CountriesDTO getCountries(final String iCountryId, final String iCountryCode) {
		List<CountryDTO> theCountryList = null;
		if (validateGetCountries(iCountryId, iCountryCode)) {
			theCountryList = countryDao.getCountries(Integer.parseInt(iCountryId), iCountryCode);
		} else {
			UPCException upcEx = new UPCException();
			upcEx.setError(UPCErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw upcEx;
		}
		CountriesDTO countries = new CountriesDTO();
		countries.setaCountries(theCountryList);
		
		return countries;
	}

	private boolean validateGetCountries(final String iCountryId, final String iCountryCode) {
		boolean isValid = Boolean.FALSE;
		if ((null != iCountryId && "" != iCountryId) && (null != iCountryCode && "" != iCountryCode)) {
			isValid = Boolean.TRUE;
			try {
				Integer.parseInt(iCountryId);
			} catch (RuntimeException e) {
				UPCException upcEx = new UPCException();
				upcEx.setError(UPCErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
				throw upcEx;
			}
		}
		return isValid;
	}
}
