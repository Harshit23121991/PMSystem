package com.kelloggs.upc.service.service;

import java.util.List;

import com.kelloggs.upc.common.dto.RedemptionInfoDTO;
import com.kelloggs.upc.common.dto.UserDTO;
import com.kelloggs.upc.common.dto.UserDTOs;
import com.kelloggs.upc.common.dto.UserRolesDTO;

public interface UserService {

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
	 * This service is used to authenticate user.
	 * 
	 * @param
	 * @return A List of UserDTO
	 */
	public UserDTO login(String username, String password);

	/**
	 * This service is used to get list of user roles.
	 * 
	 * @param
	 * @return A List of UserDTO
	 */
	public UserRolesDTO getUserRoles();

	
	/**
	 * This service is used to add/update/disable user
	 * @param username
	 * @param password
	 * @param roleId
	 * @param isEnabled
	 * @return
	 */
	public UserDTO updateUser(int iUserId, String iLoginId, String iUsername, String iPassword, int iRoleId,
			boolean isEnabled, boolean isCreate);
	
	/**
	 * This service is used to search user
	 * @param iUsername
	 * @return
	 * @throws UPCException
	 */
	public UserDTOs searchUser(String iUsername);
	
	/**
	 * This service is used to fetch redemption of a particular user
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
