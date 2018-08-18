package com.kelloggs.upc.service.dao;

import java.util.List;

import com.kelloggs.upc.common.dto.RedemptionInfoDTO;
import com.kelloggs.upc.common.dto.UserDTO;
import com.kelloggs.upc.common.dto.UserDTOs;
import com.kelloggs.upc.common.dto.UserRolesDTO;

public interface UserDAO extends BaseDao {

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
	public UserDTO login(String username, byte[] password);

	public UserRolesDTO getUserRoles();

	/**
	 * This service is used to add/update/disable user.
	 * 
	 * @param iUsername
	 * @param iPassword
	 * @param iRoleId
	 * @param isEnabled
	 * @return
	 * @throws UPCException
	 */
	public UserDTO updateUser(int iUserId, String iLoginId, String iUsername, byte[] iPassword,
			int iRoleId, boolean isEnabled, boolean isCreate);
	
	/**
	 * This DAO is used to Search user.
	 * @param iUsername
	 * @return
	 * @throws UPCException
	 */
	public UserDTOs searchUser(String iUsername);
	
	/**
	 * This DAO is used to fetch Redemption Info of a user.
	 * @param icustomerId
	 * @return
	 * @throws UPCException
	 */
	public List<RedemptionInfoDTO> getUserRedemptionInfo(String icustomerId);

	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================

}
