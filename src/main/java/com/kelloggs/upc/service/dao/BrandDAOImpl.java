/**
 * BrandDAOImpl.java
 *
 */
package com.kelloggs.upc.service.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kelloggs.upc.common.constants.UPCErrorConstants;
import com.kelloggs.upc.common.constants.UPCServiceConstants;
import com.kelloggs.upc.common.domain.Brand;
import com.kelloggs.upc.common.domain.Country;
import com.kelloggs.upc.common.domain.OperationLog;
import com.kelloggs.upc.common.domain.Promotion;
import com.kelloggs.upc.common.domain.PromotionBrandMapping;
import com.kelloggs.upc.common.domain.User;
import com.kelloggs.upc.common.dto.BrandDTO;
import com.kelloggs.upc.common.dto.CountryDTO;
import com.kelloggs.upc.common.dto.ResponseDTO;
import com.kelloggs.upc.common.exception.UPCException;
import com.kelloggs.upc.common.utils.UPCDozerBeanMapper;
import com.kelloggs.upc.hibernate.criterion.LikeExpression;


@Repository
public class BrandDAOImpl extends BaseDaoImpl implements BrandDAO
{

	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	@Autowired
	private UPCDozerBeanMapper dozer;

	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================
	@SuppressWarnings("unchecked")
	public List<BrandDTO> getBrands(final int iCountryId)
	{
		List<Brand> theBrandList = null;
		Session theSession = null;
		try
		{
			theSession = getSession();

			final Criteria theCriteria = theSession.createCriteria(Brand.class, "brand").setFetchMode("promotions", FetchMode.LAZY)
					.add(Restrictions.eq("brand.country.countryID", iCountryId)).addOrder(Order.asc("brandName"));
			theBrandList = theCriteria.list();

		}
		catch (final RuntimeException ex)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}
		return dozer.mapCollection(theBrandList, BrandDTO.class);
	}

	@SuppressWarnings("unchecked")
	public List<BrandDTO> getBrandsDetailsByPromotion(final int iPromotionId)
	{
		List<Brand> theBrandList = new ArrayList<Brand>();
		List<BrandDTO> theBrandDTOList = null;
		Session theSession = null;
		Promotion thePromotion = null;
		try
		{
			theSession = getSession();

			Criteria theCriteria = theSession.createCriteria(Promotion.class, "promotion").add(
					Restrictions.eq("promotionID", iPromotionId));
			thePromotion = (Promotion) theCriteria.uniqueResult();
			if (thePromotion != null)
			{
				theCriteria = theSession.createCriteria(PromotionBrandMapping.class, "promotionbrandmapping").add(
						Restrictions.sqlRestriction("promotion_id=" + iPromotionId));
				final List<PromotionBrandMapping> thePromotionBrandMappingList = theCriteria.list();
				final StringBuffer aStringBuffer = new StringBuffer();
				for (int i = 0; i < thePromotionBrandMappingList.size(); i++)
				{
					final PromotionBrandMapping aPromotionBrandMapping = thePromotionBrandMappingList.get(i);
					if (i == thePromotionBrandMappingList.size() - 1)
					{
						aStringBuffer.append(aPromotionBrandMapping.getId().getBrandId());
					}
					else
					{
						aStringBuffer.append(aPromotionBrandMapping.getId().getBrandId());
						aStringBuffer.append(",");
					}
				}
				if (thePromotionBrandMappingList.size() != 0)
				{
					theCriteria = theSession.createCriteria(Brand.class, "brand").add(
							Restrictions.sqlRestriction("brand_id IN (" + aStringBuffer + ")"));
					theBrandList = theCriteria.list();
				}

				/*
				 * PersistentBag persistentBag = (PersistentBag) thePromotion.getBrands(); theBrandList = (List<Brand>)
				 * persistentBag.getStoredSnapshot();
				 */
				theBrandDTOList = new ArrayList<BrandDTO>();
				for (final Brand aBrand : theBrandList)
				{
					final BrandDTO aBrandDTO = new BrandDTO();
					aBrandDTO.setBrandID(String.valueOf(aBrand.getBrandID()));
					aBrandDTO.setBrandCode(aBrand.getBrandCode());
					aBrandDTO.setBrandName(aBrand.getBrandName());
					theBrandDTOList.add(aBrandDTO);
				}

			}
			else
			{
				theBrandDTOList = new ArrayList<BrandDTO>();
			}

		}
		catch (final RuntimeException ex)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}
		return theBrandDTOList;
	}

	@SuppressWarnings("unchecked")
	public ResponseDTO updateBrand(final int iBrandId, final String iBrandName, final String iBrandCode, final int iCountryId,
			final boolean isActive, final int iUserId)
	{

		Session theSession = null;
		final ResponseDTO aResponseDTO = new ResponseDTO();
		List<Brand> theBrandList = null;
		Criteria theCriteria = null;
		Brand theBrand = null;
		try
		{
			theSession = getSession();
			// check for brandName for country for update and create which
			// already exists
			theCriteria = theSession.createCriteria(Brand.class, "brand").add(Restrictions.eq("brandName", iBrandName))
					.add(Restrictions.eq("brand.country.countryID", iCountryId));
			theBrandList = theCriteria.list();
			if (iBrandId != 0)
			{
				/**** Check for brand id existence ****/
				theCriteria = theSession.createCriteria(Brand.class).setFetchMode("promotions", FetchMode.LAZY)
						.add(Restrictions.eq("brandID", iBrandId));
				theBrand = (Brand) theCriteria.uniqueResult();
				if (theBrand == null)
				{
					final UPCException upcEx = new UPCException();
					upcEx.setError(UPCErrorConstants.ErrorCode.BRAND_NOT_FOUND_ERROR);
					throw upcEx;
				}
				if (isActive)
				{
					if (!theBrandList.isEmpty())
					{
						final UPCException upcEx = new UPCException();
						upcEx.setError(UPCErrorConstants.ErrorCode.BRANDNAME_ALREADY_EXISTS_ERROR);
						throw upcEx;
					}
					theBrand.setBrandCode(iBrandCode);
					theBrand.setBrandName(iBrandName);
					final Country country = new Country();
					country.setCountryID(iCountryId);
					theBrand.setCountry(country);
					theSession.update(theBrand);
					theSession.flush();
					aResponseDTO.setMessage(UPCErrorConstants.SUCCESS_UPDATE_BRAND);
				}
				else
				{
					theSession.delete(theBrand);

					// Add to Operation log table
					if (!isActive)
					{
						final OperationLog aoperationLog = new OperationLog();
						aoperationLog.setOpType(UPCServiceConstants.OPERATION_TYPE_DELETE);
						aoperationLog.setEntityId(iBrandId);
						aoperationLog.setEntityType(UPCServiceConstants.ENTITY_TYPE_BRAND);
						final User auser = new User();
						auser.setUserID(iUserId);
						aoperationLog.setUser(auser);
						aoperationLog.setOpTime(Calendar.getInstance().getTime());
						theSession.saveOrUpdate(aoperationLog);
					}

					theSession.flush();
					aResponseDTO.setMessage(UPCErrorConstants.SUCCESS_DELETE_BRAND);
				}
			}
			/*** Adding new Brand ****/
			else
			{
				/**** Check for adding new brandname which is already exits ****/
				if (!theBrandList.isEmpty())
				{
					final UPCException upcEx = new UPCException();
					upcEx.setError(UPCErrorConstants.ErrorCode.BRANDNAME_ALREADY_EXISTS_ERROR);
					throw upcEx;
				}
				final Brand aBrand = new Brand();
				aBrand.setBrandCode(iBrandCode);
				aBrand.setBrandName(iBrandName);
				final Country country = new Country();
				country.setCountryID(iCountryId);
				aBrand.setCountry(country);
				theSession.save(aBrand);
				theSession.flush();
				aResponseDTO.setMessage(UPCErrorConstants.SUCCESS_CREATE_BRAND);
			}
		}
		catch (final UPCException ex)
		{
			throw ex;
		}
		catch (final RuntimeException ex)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}
		return aResponseDTO;
	}

	@SuppressWarnings("unchecked")
	public List<BrandDTO> searchBrands(final int iCountryId, String iBrandName)
	{

		List<Brand> theBrandList = new ArrayList<Brand>();
		final List<BrandDTO> aBrandDTOList = new ArrayList<BrandDTO>();
		Session theSession = null;
		iBrandName = iBrandName.trim();
		try
		{
			theSession = getSession();
			if (iCountryId != 0)
			{
				final Criteria theCriteria = theSession.createCriteria(Brand.class, "brand").addOrder(Order.asc("brandName"))
						.setFetchMode("promotions", FetchMode.LAZY);
				final Criterion cr1 = Restrictions.eq("brand.country.countryID", iCountryId);
				final Criterion cr2 = new LikeExpression("brandName", iBrandName, MatchMode.ANYWHERE);
				theCriteria.add(Restrictions.and(cr1, cr2));
				theBrandList = theCriteria.list();
			}
			else if (iCountryId == 0)
			{
				final Criteria theCriteria = theSession.createCriteria(Brand.class).addOrder(Order.asc("brandName"))
						.add(new LikeExpression("brandName", iBrandName, MatchMode.ANYWHERE))
						.setFetchMode("promotions", FetchMode.LAZY);
				theBrandList = theCriteria.list();
			}
			if (!theBrandList.isEmpty())
			{
				for (final Brand aBrand : theBrandList)
				{
					final BrandDTO brandDTO = new BrandDTO();
					final CountryDTO countryDTO = new CountryDTO();
					countryDTO.setCountryID(String.valueOf(aBrand.getCountry().getCountryID()));
					countryDTO.setCountryName(aBrand.getCountry().getCountryName());
					countryDTO.setCountryCode(aBrand.getCountry().getCountryCode());
					brandDTO.setCountry(countryDTO);
					brandDTO.setBrandID(String.valueOf(aBrand.getBrandID()));
					brandDTO.setBrandName(aBrand.getBrandName());
					brandDTO.setBrandCode(aBrand.getBrandCode());
					aBrandDTOList.add(brandDTO);
				}
			}
		}
		catch (final UPCException upcEx)
		{
			throw upcEx;
		}
		catch (final RuntimeException ex)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}
		return aBrandDTOList;
	}
}
