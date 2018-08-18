package com.kelloggs.upc.ui.managedbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.kelloggs.upc.common.dto.CountryDTO;
import com.kelloggs.upc.common.dto.RoleDTO;
import com.kelloggs.upc.common.dto.UserRolesDTO;
import com.kelloggs.upc.service.service.CountryService;
import com.kelloggs.upc.service.service.UserService;


/**
 * The Class ApplicationBean.
 */
@Named(value = "ApplicationBean")
@ApplicationScoped
public class ApplicationBean implements Serializable
{
	/** The Constant LOGGER. */
	static final Logger LOGGER = Logger.getLogger(ApplicationBean.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CountryService countryService;

	@Inject
	private UserService userService;


	/** The countries. */
	private List<CountryDTO> countries;

	/** The user roles. */
	private UserRolesDTO userRoles;

	/** The user roles map. */
	private Map<Short, RoleDTO> userRolesMap = new HashMap<Short, RoleDTO>();

	public CountryService getCountryService()
	{
		return countryService;
	}

	public void setCountryService(CountryService countryService)
	{
		this.countryService = countryService;
	}


	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	/**
	 * Gets the countries.
	 * 
	 * @return the countries
	 */
	public List<CountryDTO> getCountries()
	{
		if (countries == null)
		{
			countries = getCountryService().getCountries();
		}
		return countries;
	}

	/**
	 * Sets the countries.
	 * 
	 * @param iCountries
	 *           the new countries
	 */
	public void setCountries(final List<CountryDTO> iCountries)
	{
		this.countries = iCountries;
	}

	/**
	 * Gets the user roles.
	 * 
	 * @return the user roles
	 */
	public UserRolesDTO getUserRoles()
	{
		if (userRoles == null)
		{
			userRoles = userService.getUserRoles();
		}
		return userRoles;
	}

	/**
	 * Gets the user roles map.
	 * 
	 * @return the user roles map
	 */
	public Map<Short, RoleDTO> getUserRolesMap()
	{

		final List<RoleDTO> userRoleDTOList = userRoles.getUserRole();

		for (final RoleDTO userRole : userRoleDTOList)
		{
			userRolesMap.put((short) userRole.getRoleId(), userRole);
		}

		return userRolesMap;
	}

	/**
	 * Sets the user roles map.
	 * 
	 * @param iUserRolesMap
	 *           the i user roles map
	 */
	public void setUserRolesMap(final Map<Short, RoleDTO> iUserRolesMap)
	{
		this.userRolesMap = iUserRolesMap;
	}

	/**
	 * Sets the user roles.
	 * 
	 * @param iUserRoles
	 *           the new user roles
	 */
	public void setUserRoles(final UserRolesDTO iUserRoles)
	{
		this.userRoles = iUserRoles;
	}

}
