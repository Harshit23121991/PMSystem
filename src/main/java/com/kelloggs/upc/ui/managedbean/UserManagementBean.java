/*
 * Copyright (c) 2014, Cluster India.
 *
 */
package com.kelloggs.upc.ui.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.kelloggs.upc.common.dto.UserDTO;
import com.kelloggs.upc.common.dto.UserDTOs;
import com.kelloggs.upc.common.exception.UPCException;
import com.kelloggs.upc.service.service.UserService;
import com.kelloggs.upc.ui.common.UPCConstants;


/**
 * The Class UserManagementBean.
 */
@Named(value = "usermanageBean")
@ViewScoped
public class UserManagementBean extends BaseBean
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant LOGGER. */
	static final Logger LOGGER = Logger.getLogger(UserManagementBean.class);

	/** The user. */
	private List<UserDTO> userList = new ArrayList<UserDTO>(1);

	/** User Creation Properties. */
	/** The hidden user id value. */
	private String hiddenUserIdValue = "";

	/** The user name value. */
	private String userNameValue = "".intern();

	/** The user id value. */
	private String loginId = "";

	/** The password value. */
	private String passwordValue = "";

	/** The confirm password value. */
	private String confirmPasswordValue = "";

	/** The role value. */
	private String roleValue = "";

	/** The enable value. */
	private String enableValue = "";

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The Constant CREATE_USER_CODE. */
	private static final Integer CREATE_USER_CODE = 1;

	/** The search user value. */
	private final String Search_ALL_USER = "";

	/** Search Feature */
	/** The search user value. */
	private String searchUserValue = "";

	// =================================================
	// Constructors
	// =================================================
	/**
	 * Instantiates a new user manage bean.
	 */
	public UserManagementBean()
	{
		super();
		LOGGER.debug(" Entered UserManageBean constructor");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.ui.managedbean.BaseBean#init()
	 */
	@Override
	@PostConstruct
	public void init()
	{
		userList = getAllUser().getUser();
	}

	/**
	 * Gets the all user.
	 *
	 * @return the all user
	 */
	public UserDTOs getAllUser()
	{
		UserDTOs userDTOs = null;
		try
		{
			userDTOs = userService.searchUser(Search_ALL_USER);
		}
		catch (final UPCException e)
		{

			final FacesMessage facesMessage = new FacesMessage(errorResourceBundle.getString(e.getError().getKey() + ".error"));
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("userManagedFormErrors", facesMessage);

		}
		return userDTOs;
	}

	/**
	 * Creates the new user.
	 */
	public void createNewUser()
	{

		LOGGER.debug(" Entered createNewUser service");
		final String username = getUserNameValue();
		final String password = getPasswordValue();
		final String roleid = getRoleValue();
		final String enabled = getEnableValue();
		final String userid = getLoginId();
		try
		{

			UserDTO ouserDTO = null;
			if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(roleid)
					&& StringUtils.isNotBlank(enabled))
			{

				ouserDTO = userService.updateUser(CREATE_USER_CODE, userid, username, password, Integer.parseInt(roleid),
						"1".equals(enabled), true);
				if (ouserDTO != null)
				{
					final FacesMessage fm = new FacesMessage(UPCConstants.UPCMessages.MANAGEUSER_CREATE_SUCCESS.getMsg());
					fm.setSeverity(FacesMessage.SEVERITY_INFO);
					FacesContext.getCurrentInstance().addMessage("userManagement:createUser", fm);
				}
				searchAllUser();
				setUserNameValue("");
				setLoginId("");
				setPasswordValue("");
				setConfirmPasswordValue("");
				setRoleValue("");
				setEnableValue("");
			}
		}
		catch (final UPCException e)
		{

			final FacesMessage fm = new FacesMessage(errorResourceBundle.getString(e.getError().getKey() + ".error"));
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("pageError_userCreateForm", fm);
			LOGGER.error(" Error Occured in creating user ", e);
		}

		LOGGER.debug(" Exit from createNewUser service");
	}


	/**
	 * <p>
	 * <code>UserManageBean.populateExistingUser</code> method uses {@link com.kelloggs.upc.common.dto.UserDTO } data
	 * transfer object and set the value to backing bean properties for respective users
	 * </p>
	 *
	 * <pre>
	 * userDTO.isEnabled()  is true= 1
	 * userDTO.isEnabled()  is false = 0
	 * </pre>
	 *
	 * @param userDTO
	 *           It accepts {@link com.kelloggs.upc.common.dto.UserDTO }
	 * @since 1.0.0
	 */
	public void populateExistingUser(final UserDTO userDTO)
	{
		LOGGER.debug(" Entered populateExistingUser service");
		setHiddenUserIdValue(String.valueOf(userDTO.getUserID()));
		setUserNameValue(userDTO.getUserName());
		setLoginId(userDTO.getLoginID());
		setPasswordValue(userDTO.getUserPassword());
		setConfirmPasswordValue(userDTO.getUserPassword());
		setRoleValue(String.valueOf(userDTO.getUserRoleID()));
		if (userDTO.isEnabled())
		{
			setEnableValue("1");
		}
		else
		{
			setEnableValue("0");
		}
		LOGGER.debug(" Exsited from populateExistingUser service");
	}

	/**
	 * Search user by name.
	 *
	 * @param event
	 *           the event
	 */
	public void searchUserByName(final ValueChangeEvent event)
	{
		LOGGER.debug(" Entered searchUserByName service");
		final String userIputValue = ((String) event.getNewValue());
		UserDTOs oUserDTOs = null;
		if (StringUtils.isNotBlank(userIputValue))
		{
			oUserDTOs = userService.searchUser(userIputValue);
			setUserList(oUserDTOs.getUser());
		}
		else
		{
			setSearchUserValue(userIputValue);
			searchAllUser();
		}

		LOGGER.debug(" Exsited from searchUserByName service");
	}


	/**
	 * Update existing user.
	 */
	public void updateExistingUser()
	{
		LOGGER.debug(" Entered updateExistingUser service");
		try
		{

			final String username = getUserNameValue();
			final String password = getPasswordValue();
			final String roleid = getRoleValue();
			final String enabled = getEnableValue();
			final String userid = getHiddenUserIdValue();
			final String loginId = getLoginId();
			UserDTO userDTO = null;
			if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(roleid)
					&& StringUtils.isNotBlank(enabled) && StringUtils.isNotBlank(userid) && StringUtils.isNotBlank(loginId))
			{
				userDTO = userService.updateUser(Integer.parseInt(userid), loginId, username, password, Integer.parseInt(roleid),
						"1".equals(enabled), false);
				if (userDTO != null && StringUtils.isNotBlank(userDTO.getLoginID()))
				{
					final FacesMessage fm = new FacesMessage(UPCConstants.UPCMessages.MANAGEUSER_UPDATE_SUCCESS.getMsg());
					fm.setSeverity(FacesMessage.SEVERITY_INFO);
					FacesContext.getCurrentInstance().addMessage("userManagement:updated", fm);
				}
				searchAllUser();
			}
		}
		catch (final UPCException e)
		{
			LOGGER.error(" Error Occured in creating user " + e.getMessage());
			final FacesMessage fm = new FacesMessage(errorResourceBundle.getString(e.getError().getKey() + ".error"));
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("pageError_userCreateForm", fm);
		}
		LOGGER.debug(" Exsited from updateExistingUser service");
	}


	/**
	 * Search all user.
	 */
	public void searchAllUser()
	{
		setUserList(getAllUser().getUser());
	}

	/**
	 * Gets the user list.
	 *
	 * @return the user list
	 */
	public List<UserDTO> getUserList()
	{
		return userList;
	}

	/**
	 * Sets the user list.
	 *
	 * @param userList
	 *           the new user list
	 */
	public void setUserList(final List<UserDTO> userList)
	{
		this.userList = userList;
	}

	/**
	 * Gets the hidden user id value.
	 *
	 * @return the hidden user id value
	 */
	public String getHiddenUserIdValue()
	{
		return hiddenUserIdValue;
	}

	/**
	 * Sets the hidden user id value.
	 *
	 * @param hiddenUserIdValue
	 *           the new hidden user id value
	 */
	public void setHiddenUserIdValue(final String hiddenUserIdValue)
	{
		this.hiddenUserIdValue = hiddenUserIdValue;
	}

	/**
	 * Gets the user name value.
	 *
	 * @return the user name value
	 */
	public String getUserNameValue()
	{
		return userNameValue;
	}

	/**
	 * Sets the user name value.
	 *
	 * @param userNameValue
	 *           the new user name value
	 */
	public void setUserNameValue(final String userNameValue)
	{
		this.userNameValue = userNameValue;
	}

	/**
	 * Gets the login id.
	 *
	 * @return the login id
	 */
	public String getLoginId()
	{
		return loginId;
	}

	/**
	 * Sets the login id.
	 *
	 * @param loginId
	 *           the new login id
	 */
	public void setLoginId(final String loginId)
	{
		this.loginId = loginId;
	}

	/**
	 * Gets the password value.
	 *
	 * @return the password value
	 */
	public String getPasswordValue()
	{
		return passwordValue;
	}

	/**
	 * Sets the password value.
	 *
	 * @param passwordValue
	 *           the new password value
	 */
	public void setPasswordValue(final String passwordValue)
	{
		this.passwordValue = passwordValue;
	}

	/**
	 * Gets the confirm password value.
	 *
	 * @return the confirm password value
	 */
	public String getConfirmPasswordValue()
	{
		return confirmPasswordValue;
	}

	/**
	 * Sets the confirm password value.
	 *
	 * @param confirmPasswordValue
	 *           the new confirm password value
	 */
	public void setConfirmPasswordValue(final String confirmPasswordValue)
	{
		this.confirmPasswordValue = confirmPasswordValue;
	}

	/**
	 * Gets the role value.
	 *
	 * @return the role value
	 */
	public String getRoleValue()
	{
		return roleValue;
	}

	/**
	 * Sets the role value.
	 *
	 * @param roleValue
	 *           the new role value
	 */
	public void setRoleValue(final String roleValue)
	{
		this.roleValue = roleValue;
	}

	/**
	 * Gets the enable value.
	 *
	 * @return the enable value
	 */
	public String getEnableValue()
	{
		return enableValue;
	}

	/**
	 * Sets the enable value.
	 *
	 * @param enableValue
	 *           the new enable value
	 */
	public void setEnableValue(final String enableValue)
	{
		this.enableValue = enableValue;
	}

	/**
	 * Gets the user service.
	 *
	 * @return the user service
	 */
	public UserService getUserService()
	{
		return userService;
	}

	/**
	 * Sets the user service.
	 *
	 * @param userService
	 *           the new user service
	 */
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	public String getSearchUserValue()
	{
		return searchUserValue;
	}

	public void setSearchUserValue(final String searchUserValue)
	{
		this.searchUserValue = searchUserValue;
	}
}
