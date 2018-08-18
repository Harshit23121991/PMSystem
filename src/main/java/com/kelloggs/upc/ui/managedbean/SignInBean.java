/*
 * Copyright (c) 2014, Cluster India.
 *
 */
package com.kelloggs.upc.ui.managedbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.kelloggs.upc.common.dto.MenuDTO;
import com.kelloggs.upc.common.dto.RoleDTO;
import com.kelloggs.upc.common.dto.SignInDTO;
import com.kelloggs.upc.common.dto.UserDTO;
import com.kelloggs.upc.common.dto.UserRolesDTO;
import com.kelloggs.upc.common.exception.UPCException;
import com.kelloggs.upc.service.service.UserService;


/**
 * The Class SignInBean.
 */
@Named(value = "SignInBean")
@SessionScoped
public class SignInBean extends BaseBean
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant LOGGER. */
	static final Logger LOGGER = Logger.getLogger(SignInBean.class);

	@Autowired
	private UserService userService;

	/**
	 * Instantiates a new sign in bean.
	 */
	public SignInBean()
	{
		System.out.println(" SignInBean ");
	}


	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	/* Stores data from business logic in below fields */
	/** The login dto. */
	private UserDTO loginDTO;

	/** The validate reponse. */
	private String validateReponse;

	/** The user menu names. */
	private List<MenuDTO> userMenuNames;

	/** The complete user menu names. */
	private List<SignInDTO> completeUserMenuNames = new ArrayList<SignInDTO>();

	/** The sub menu names. */
	private List<SignInDTO> subMenuNames = new ArrayList<SignInDTO>();

	/** The role id. */
	private String roleId;


	/**
	 * Checks if is tab visible.
	 *
	 * @param iStr
	 *           the i str
	 * @return true, if is tab visible
	 */
	public boolean isTabVisible(final String iStr)
	{

		final Map<Short, RoleDTO> userRolesMap = applicationBean.getUserRolesMap();

		if (loginDTO == null)
		{
			return false;
		}
		final List<MenuDTO> menuList = userRolesMap.get((short) this.loginDTO.getUserRoleID()).getMenu();

		for (final MenuDTO menu : menuList)
		{

			if (iStr.equals(menu.getMenuName()))
			{
				return true;
			}
		}

		return false;

	}

	/**
	 * Checks if is sub menu visible.
	 *
	 * @param iMenuName
	 *           the i menu name
	 * @param iSubMenuName
	 *           the i sub menu name
	 * @return true, if is sub menu visible
	 */
	public boolean isSubMenuVisible(final String iMenuName, final String iSubMenuName)
	{

		final Map<Short, RoleDTO> userRolesMap = applicationBean.getUserRolesMap();

		if (loginDTO == null)
		{
			return false;
		}

		final List<MenuDTO> menuList = userRolesMap.get((short) this.loginDTO.getUserRoleID()).getMenu();

		for (final MenuDTO menu : menuList)
		{

			if (iMenuName.equals(menu.getMenuName()) && menu.getSubMenu() != null && menu.getSubMenu().containsValue(iSubMenuName))
			{
				return true;
			}

		}

		return false;

	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public String getRoleId()
	{
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param iRoleId
	 *           the new role id
	 */
	public void setRoleId(final String iRoleId)
	{
		this.roleId = iRoleId;
	}

	/**
	 * Gets the complete user menu names.
	 *
	 * @return the complete user menu names
	 */
	public List<SignInDTO> getCompleteUserMenuNames()
	{
		return completeUserMenuNames;
	}

	/**
	 * Sets the complete user menu names.
	 *
	 * @param iCompleteUserMenuNames
	 *           the new complete user menu names
	 */
	public void setCompleteUserMenuNames(final List<SignInDTO> iCompleteUserMenuNames)
	{
		this.completeUserMenuNames = iCompleteUserMenuNames;
	}

	/**
	 * Gets the validate reponse.
	 *
	 * @return the validate reponse
	 */
	public String getValidateReponse()
	{
		return validateReponse;
	}

	/**
	 * Sets the validate reponse.
	 *
	 * @param iValidateReponse
	 *           the new validate reponse
	 */
	public void setValidateReponse(final String iValidateReponse)
	{
		this.validateReponse = iValidateReponse;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param iUserName
	 *           the new user name
	 */
	public void setUserName(final String iUserName)
	{
		this.userName = iUserName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param iPassword
	 *           the new password
	 */
	public void setPassword(final String iPassword)
	{
		this.password = iPassword;
	}

	/**
	 * Gets the login dto.
	 *
	 * @return the login dto
	 */
	public UserDTO getLoginDTO()
	{
		return loginDTO;
	}

	/**
	 * Sets the login dto.
	 *
	 * @param iLoginDTO
	 *           the new login dto
	 */
	public void setLoginDTO(final UserDTO iLoginDTO)
	{
		this.loginDTO = iLoginDTO;
	}

	/**
	 * Gets the user menu names.
	 *
	 * @return the user menu names
	 */
	public List<MenuDTO> getUserMenuNames()
	{
		return userMenuNames;
	}

	/**
	 * Sets the user menu names.
	 *
	 * @param iUserMenuNames
	 *           the new user menu names
	 */
	public void setUserMenuNames(final List<MenuDTO> iUserMenuNames)
	{
		this.userMenuNames = iUserMenuNames;
	}

	/**
	 * Gets the sub menu names.
	 *
	 * @return the sub menu names
	 */
	public List<SignInDTO> getSubMenuNames()
	{
		return subMenuNames;
	}

	/**
	 * Sets the sub menu names.
	 *
	 * @param iSubMenuNames
	 *           the new sub menu names
	 */
	public void setSubMenuNames(final List<SignInDTO> iSubMenuNames)
	{
		this.subMenuNames = iSubMenuNames;
	}

	/**
	 * Validate login fields.
	 *
	 * @return true, if successful
	 */
	private boolean validateLoginFields()
	{

		LOGGER.debug("Inside SignInBean.validateLoginFields");
		boolean isValid = true;
		validateReponse = "";
		if (this.userName == null || this.userName.length() == 0)
		{
			final FacesMessage fm = new FacesMessage("Username is Empty");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("loginForm:userName", fm);
			validateReponse = "fail";
			isValid = false;
		}
		if (this.password == null || this.password.length() == 0)
		{
			final FacesMessage fm = new FacesMessage("Password is Empty");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("loginForm:password", fm);
			validateReponse = "fail";
			isValid = false;
		}

		LOGGER.debug("End of SignInBean.validateLoginFields");
		return isValid;

	}

	/**
	 * Sign in user.
	 *
	 * @return the string
	 */
	public String signInUser()
	{
		LOGGER.debug("Inside SignInBean.signInUser");

		try
		{

			if (StringUtils.isNotBlank(userName) && StringUtils.isNotEmpty(password))
			{

				loginDTO = getUserService().login(this.userName, this.password);
				if (loginDTO != null)
				{
					validateReponse = "success";
					final FacesContext context = FacesContext.getCurrentInstance();
					final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
					final HttpSession httpSession = request.getSession();
					httpSession.setAttribute("userid", loginDTO.getUserID());

					final UserRolesDTO allUserRoles = applicationBean.getUserRoles();

					if (allUserRoles != null && allUserRoles.getUserRole() != null && allUserRoles.getUserRole().size() > 0)
					{

						boolean validRole = false;
						final List<RoleDTO> theRoleDTOList = allUserRoles.getUserRole();
						for (final RoleDTO userRoleDTO : theRoleDTOList)
						{

							if (userRoleDTO.getRoleId() == loginDTO.getUserRoleID())
							{
								userMenuNames = userRoleDTO.getMenu();
								completeUserMenuNames.clear();
								subMenuNames.clear();
								for (final MenuDTO s : userMenuNames)
								{

									final SignInDTO sinDto = new SignInDTO();
									sinDto.setId(s.getMenuName());
									sinDto.setDisplayName(resourceBundle.getString(s.getMenuName()));
									completeUserMenuNames.add(sinDto);
									if (s.getSubMenu() != null)
									{
										String subMenuName = "";
										final Iterator<Integer> aIterator = s.getSubMenu().keySet().iterator();
										while (aIterator.hasNext())
										{
											subMenuName = s.getSubMenu().get(aIterator.next());
											final SignInDTO aSignInDTO = new SignInDTO();
											aSignInDTO.setId(subMenuName);
											aSignInDTO.setDisplayName(resourceBundle.getString(subMenuName));
											subMenuNames.add(aSignInDTO);
										}

									}
								}

								validRole = true;
							}

						}

						// Logout user if user role is not present in all user
						if (!validRole)
						{
							logout();
						}

					}
				}
			}
		}
		catch (final UPCException aUpcApplicationException)
		{

			validateReponse = "fails";
		}

		LOGGER.debug("End of SignInBean.signInUser");
		return validateReponse;

	}

	/**
	 * Logout.
	 *
	 * @return the string
	 */
	public String logout()
	{
		LOGGER.debug("Inside logout");
		final FacesContext context = FacesContext.getCurrentInstance();
		final ExternalContext ec = context.getExternalContext();
		final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.getSession(false).invalidate();
		LOGGER.debug("Existed logout");
		return "signin";
	}

	/**
	 * Checks if is login.
	 */
	public void isLogin()
	{
		LOGGER.debug("Inside logout");
		final FacesContext context = FacesContext.getCurrentInstance();
		final ExternalContext ec = context.getExternalContext();

		final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		if (request.isRequestedSessionIdValid())
		{
			LOGGER.debug("User session exists");
		}
		LOGGER.debug("Existed logout");
	}

	/**
	 * Checks if is logged in.
	 *
	 * @return true, if is logged in
	 */
	public boolean isLoggedIn()
	{
		LOGGER.debug("Inside isLoggedIn");
		final boolean isLoggedUser = (loginDTO != null);
		LOGGER.debug("Inside isLoggedIn");
		return isLoggedUser;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

}
