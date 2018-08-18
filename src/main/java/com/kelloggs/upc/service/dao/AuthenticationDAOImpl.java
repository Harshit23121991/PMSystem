/*
 * AuthenticationDAOImpl.java
 * This is Class for Authentication DAO Implementation
 * 
 * */
package com.kelloggs.upc.service.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kelloggs.upc.common.constants.UPCErrorConstants;
import com.kelloggs.upc.common.domain.ApiAccess;
import com.kelloggs.upc.common.exception.UPCException;


@Repository
public class AuthenticationDAOImpl extends BaseDaoImpl implements AuthenticationDAO
{

	// =================================================
	// Class Variable
	// =================================================

	// =================================================
	// Instance Variable
	// =================================================

	// =================================================
	// Class Variable
	// =================================================

	// =================================================
	// Constructor
	// =================================================

	// =================================================
	// Class Method
	// =================================================

	// =================================================
	// Instance Methods
	// =================================================

	// =================================================
	// Overridden Methods
	// =================================================

	@SuppressWarnings("unchecked")
	public boolean isValid(final String iPublicKey, final String iPrivateKey)
	{

		Session theSession = null;
		List<ApiAccess> theApiAccessList = null;
		try
		{
			theSession = getSession();
			final Criteria theCriteria = theSession
					.createCriteria(ApiAccess.class, "apiaccess")
					.add(Restrictions.and(Restrictions.eq("publicKey", iPublicKey.getBytes()),
							Restrictions.eq("privateKey", iPrivateKey.getBytes()))).add(Restrictions.eq("isEnabled", true));

			theApiAccessList = theCriteria.list();
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
		return !theApiAccessList.isEmpty();
	}
}
