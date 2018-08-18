package com.kelloggs.upc.service.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kelloggs.upc.common.dto.RedemptionInfoDTO;
import com.kelloggs.upc.common.dto.RedemptionsInfoDTO;
import com.kelloggs.upc.common.dto.UserDTO;
import com.kelloggs.upc.common.dto.UserDTOs;
import com.kelloggs.upc.common.dto.UserRolesDTO;
import com.kelloggs.upc.service.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserResource {
	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	@Autowired
	private UserService userService;

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

	@RequestMapping(value = "/login", method ={ RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(
			@RequestParam(value = "username") final String username,
			@RequestParam(value = "password") final String password) {

		UserDTO userDTO = userService.login(username, password); 

		return new ModelAndView("xml", "UserDTO", userDTO);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ModelAndView getUserRoles() {  

		UserRolesDTO userRolesDTO = userService.getUserRoles();

		return new ModelAndView("xml", "UserRolesDTO", userRolesDTO);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateUSer(
			@RequestParam(value = "userid") final int iUserId, 
			@RequestParam(value = "loginid") final String iLoginId, 
			@RequestParam(value = "username") final String iUsername,
			@RequestParam(value = "password") final String iPassword,
			@RequestParam(value = "roleid") final int iRoleId,
			@RequestParam(value = "enabled") final boolean isEnabled,
			@RequestParam(value = "iscreate") final boolean isCreate) {

		UserDTO userDTO = userService.updateUser(iUserId, iLoginId, iUsername, iPassword, iRoleId, isEnabled, isCreate);

		return new ModelAndView("xml", "UserDTO", userDTO);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchUser(@RequestParam(value = "username") final String iUsername) {

		UserDTOs userDTOs = userService.searchUser(iUsername);

		return new ModelAndView("xml", "UserDTOs", userDTOs);
	}
	
	@RequestMapping(value = "/redemption", method = RequestMethod.GET)
	public ModelAndView getUserRedemptionInfo(@RequestParam(value = "customerId") final String icustomerId) {
		
		List<RedemptionInfoDTO> redemptionInfoDTO = userService.getUserRedemptionInfo(icustomerId);
		
		RedemptionsInfoDTO redemptionsInfoDTO = new RedemptionsInfoDTO();
		
		redemptionsInfoDTO.setRedemptionInfo(redemptionInfoDTO);
		
		return new ModelAndView("xml", "redemptionInfo", redemptionsInfoDTO);
	}
	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================
}
