package com.kelloggs.upc.ui.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.kelloggs.upc.common.dto.CountryDTO;
import com.kelloggs.upc.common.dto.RoleDTO;
import com.kelloggs.upc.common.dto.UserRolesDTO;


/**
 * The Class BaseBean.
 */
@Named(value = "baseBean")
@ApplicationScoped
public class BaseBean implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** The Constant LOGGER. */
	static final Logger LOGGER = Logger.getLogger(BaseBean.class);

	/** The application bean. */
	@Autowired
	protected ApplicationBean applicationBean;

	/** The resource bundle. */
	protected static final ResourceBundle resourceBundle = FacesContext.getCurrentInstance().getApplication()
			.getResourceBundle(FacesContext.getCurrentInstance(), "SignIn");

	/** The error resource bundle. */
	protected static final ResourceBundle errorResourceBundle = FacesContext.getCurrentInstance().getApplication()
			.getResourceBundle(FacesContext.getCurrentInstance(), "ErrorMessage");

	/** The country list. */
	protected static List<SelectItem> countryList = new ArrayList<SelectItem>();

	/** The role list. */
	protected static List<SelectItem> roleList = new ArrayList<SelectItem>();

	/**
	 * Instantiates a new base bean.
	 */
	public BaseBean()
	{

		LOGGER.info("In base Bean");
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init()
	{

		if (countryList != null && countryList.isEmpty())
		{
			SelectItem item = new SelectItem("", "");
			final List<CountryDTO> countryDTOList = applicationBean.getCountries();

			for (final CountryDTO country : countryDTOList)
			{
				item = new SelectItem(country.getCountryID(), country.getCountryName());
				countryList.add(item);
			}

		}

		if (roleList != null && roleList.isEmpty())
		{
			SelectItem item = null;
			final UserRolesDTO userRolesDTO = applicationBean.getUserRoles();
			if (null != userRolesDTO)
			{
				final List<RoleDTO> userRolesList = userRolesDTO.getUserRole();
				roleList.add(new SelectItem("0", "Select"));
				for (final RoleDTO userRoleDTO : userRolesList)
				{
					item = new SelectItem(userRoleDTO.getRoleId(), userRoleDTO.getRoleName());
					roleList.add(item);
				}
			}
		}

		LOGGER.info("Value: " + applicationBean);

	}

	/**
	 * Gets the application bean.
	 *
	 * @return the application bean
	 */
	public ApplicationBean getApplicationBean()
	{
		return applicationBean;
	}

	/**
	 * Sets the application bean.
	 *
	 * @param iApplicationBean
	 *           the new application bean
	 */
	public void setApplicationBean(final ApplicationBean iApplicationBean)
	{
		this.applicationBean = iApplicationBean;
	}

	/**
	 * Gets the country list.
	 *
	 * @return the country list
	 */
	public List<SelectItem> getCountryList()
	{

		return countryList;
	}

	/**
	 * Sets the country list.
	 *
	 * @param iCountryList
	 *           the new country list
	 */
	public void setCountryList(final List<SelectItem> iCountryList)
	{
		BaseBean.countryList = iCountryList;
	}

	/**
	 * Gets the role list.
	 *
	 * @return the role list
	 */
	public List<SelectItem> getRoleList()
	{
		return roleList;
	}

	/**
	 * Sets the role list.
	 *
	 * @param iRoleList
	 *           the new role list
	 */
	public void setRoleList(final List<SelectItem> iRoleList)
	{
		BaseBean.roleList = iRoleList;
	}

}
