/*
 * AuthenticationService.java
 * This is interface for Authentication DAO
 * 
 * */
package com.kelloggs.upc.service.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationDAO extends BaseDao {

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
	public boolean isValid(String iPublicKey, String iPrivateKey);

	// =================================================
	// Overridden Methods
	// =================================================

}
