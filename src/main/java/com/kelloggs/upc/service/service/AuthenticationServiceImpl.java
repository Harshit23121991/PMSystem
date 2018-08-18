/*
 * AuthenticationServiceImpl.java
 * This is Class for Authenticating each request
 *
 * */
package com.kelloggs.upc.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelloggs.upc.service.dao.AuthenticationDAO;


@Service
public class AuthenticationServiceImpl implements AuthenticationService
{
	// =================================================
	// Class Variable
	// =================================================

	// =================================================
	// Instance Variable
	// =================================================
	@Autowired
	private AuthenticationDAO authenticationDAO;

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

	public boolean isValid(final String iPublicKey, final String iPrivateKey)
	{
		boolean isValid = false;
		if ((null != iPublicKey && !"".equalsIgnoreCase(iPublicKey)) && (null != iPrivateKey && !"".equalsIgnoreCase(iPrivateKey)))
		{
			isValid = authenticationDAO.isValid(iPublicKey, iPrivateKey);
		}
		return isValid;
	}

}
