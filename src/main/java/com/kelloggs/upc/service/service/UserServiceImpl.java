package com.kelloggs.upc.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelloggs.upc.common.constants.UPCErrorConstants;
import com.kelloggs.upc.common.dto.RedemptionInfoDTO;
import com.kelloggs.upc.common.dto.UserDTO;
import com.kelloggs.upc.common.dto.UserDTOs;
import com.kelloggs.upc.common.dto.UserRolesDTO;
import com.kelloggs.upc.common.exception.UPCException;
import com.kelloggs.upc.service.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	@Autowired
	private UserDAO userDao;

	// =================================================
	// Constructors
	// =================================================
	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================
	// =================================================
	// Overridden Methods
	// =================================================
	
	public UserDTO login(final String username, final String password) {
		UserDTO userDTO = null;
		if (!"".equals(username) && !"".equals(password)) {
			userDTO = userDao.login(username, password.getBytes());
		} else {
			UPCException upcEx = new UPCException();
			upcEx.setError(UPCErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw upcEx;
		}
		
		return userDTO;
	}

	
	public UserRolesDTO getUserRoles() {
		UserRolesDTO userRolesDTO = userDao.getUserRoles();
		return userRolesDTO;
	}

	
	public UserDTO updateUser(final int iUserId, final String iLoginId, final String iUsername, final String iPassword,
			final int iRoleId, final boolean isEnabled, final boolean isCreate) {
		UserDTO userDTO = null;

		if (!"".equals(iUsername) && !"".equals(iPassword) && !"".equals(iLoginId)) {
			userDTO = userDao.updateUser(iUserId, iLoginId.toLowerCase(), iUsername, iPassword.getBytes(), iRoleId, isEnabled, isCreate);
		} else {
			UPCException upcEx = new UPCException();
			upcEx.setError(UPCErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw upcEx;
		}
		
		return userDTO;
	}

	
	public UserDTOs searchUser(final String iUsername) {
		return userDao.searchUser(iUsername);
	}
	
	
	public List<RedemptionInfoDTO> getUserRedemptionInfo(final String icustomerId) {
		
		return userDao.getUserRedemptionInfo(icustomerId);
	}

	
	// =================================================
	// Private Methods
	// =================================================
	
	// =================================================
	// Accessors
	// =================================================

}
