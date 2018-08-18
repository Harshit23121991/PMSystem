package com.kelloggs.upc.service.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kelloggs.upc.common.constants.UPCErrorConstants;
import com.kelloggs.upc.common.domain.Country;
import com.kelloggs.upc.common.dto.CountryDTO;
import com.kelloggs.upc.common.exception.UPCException;
import com.kelloggs.upc.common.utils.UPCDozerBeanMapper;

@Repository
public class CountryDAOImpl extends BaseDaoImpl implements CountryDAO {

	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	@Autowired
	private UPCDozerBeanMapper dozer;

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
	 * @see com.kelloggs.upc.service.dao.CountryDAO#getCountries()
	 */
	@SuppressWarnings("unchecked")
	public List<CountryDTO> getCountries() {
		List<Country> theCountryList = null;
		Session theSession = null;
		try {
			theSession = getSession();
			final Criteria theCriteria = theSession.createCriteria(Country.class, "country");
			theCountryList = (List<Country>) theCriteria.list();
		} catch (RuntimeException ex) {
			UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		} finally {
			releaseSession(theSession);
		}
		
		return dozer.mapCollection(theCountryList, CountryDTO.class);
	}

	@SuppressWarnings("unchecked")
	public List<CountryDTO> getCountries(final Integer iCountryId, final String iCountryCode) {
		List<Country> theCountryList = null;
		Session theSession = null;
		try {
			theSession = getSession();
			final Criteria theCriteria = theSession.createCriteria(Country.class,
					"country");
			Criterion cr1 = Restrictions.eq("countryID", iCountryId);
			Criterion cr2 = Restrictions.eq("countryCode", iCountryCode);
			theCriteria.add(Restrictions.and(cr1, cr2));
			theCountryList = (List<Country>) theCriteria.list();
		} catch (RuntimeException ex) {
			UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		} finally {
			releaseSession(theSession);
		}
		return dozer.mapCollection(theCountryList, CountryDTO.class);

	}
}
