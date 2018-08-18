package com.kelloggs.upc.service.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kelloggs.upc.common.constants.UPCErrorConstants;
import com.kelloggs.upc.common.domain.CustomerRedemption;
import com.kelloggs.upc.common.domain.Menu;
import com.kelloggs.upc.common.domain.User;
import com.kelloggs.upc.common.domain.UserRole;
import com.kelloggs.upc.common.dto.MenuDTO;
import com.kelloggs.upc.common.dto.RedemptionInfoDTO;
import com.kelloggs.upc.common.dto.RoleDTO;
import com.kelloggs.upc.common.dto.UserDTO;
import com.kelloggs.upc.common.dto.UserDTOs;
import com.kelloggs.upc.common.dto.UserRolesDTO;
import com.kelloggs.upc.common.exception.UPCException;


@Repository
public class UserDAOImpl extends BaseDaoImpl implements UserDAO
{

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.UserDAO#login(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public UserDTO login(final String username, final byte[] password)
	{
		Session theSession = null;
		final UserDTO userDTO = new UserDTO();
		try
		{
			theSession = getSession();
			Criteria theCriteria = theSession
					.createCriteria(User.class, "user")
					.add(Restrictions.and(Restrictions.eq("loginID", username).ignoreCase(), Restrictions.eq("userPassword", password)))
					.add(Restrictions.eq("isEnabled", true));
			final List<User> theUserList = theCriteria.list();
			if (theUserList.isEmpty())
			{
				final UPCException upcEx = new UPCException();
				upcEx.setError(UPCErrorConstants.ErrorCode.USERNAME_PASSWORD_DOESNT_MATCH_ERROR);
				throw upcEx;
			}

			for (final User user : theUserList)
			{
				theCriteria = theSession.createCriteria(UserRole.class, "UserRole").add(
						Restrictions.eq("roleId", user.getUserRoleID()));
				final List<UserRole> theRoleList = theCriteria.list();
				userDTO.setUserID(user.getUserID());
				userDTO.setLoginID(user.getLoginID());
				userDTO.setUserName(user.getUserName());
				userDTO.setUserPassword(new String(user.getUserPassword()));
				userDTO.setUserRoleID(user.getUserRoleID());
				userDTO.setUserRoleName(theRoleList.get(0).getRoleName());
				userDTO.setEnabled(user.isEnabled());
			}
		}
		catch (final UPCException ex)
		{
			throw ex;
		}
		catch (final RuntimeException ex)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}

		return userDTO;
	}

	@SuppressWarnings("unchecked")
	public UserRolesDTO getUserRoles()
	{
		UserRolesDTO userRolesDTO = new UserRolesDTO();
		Session theSession = null;
		try
		{
			theSession = getSession();
			Criteria theCriteria = theSession.createCriteria(UserRole.class, "UserRole").createAlias("menu", "m")
					.addOrder(Order.asc("roleId")).addOrder(Order.asc("m.parentId")).addOrder(Order.asc("m.orderNumber"));
			final List<UserRole> theRoleList = theCriteria.list();

			theCriteria = theSession.createCriteria(Menu.class, "menu").add(Restrictions.eq("parentId", 0));
			final List<Menu> theMenuList = theCriteria.list();

			if (!theRoleList.isEmpty())
			{
				userRolesDTO = getUserRolesDTO(theRoleList, theMenuList);
			}
		}
		catch (final RuntimeException ex)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		catch (final Exception e)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(e);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}
		return userRolesDTO;
	}

	@SuppressWarnings("unchecked")
	public UserDTO updateUser(final int iUserId, final String iLoginId, final String iUsername, final byte[] iPassword,
			final int iRoleId, final boolean isEnabled, final boolean isCreate)
	{

		Session theSession = null;
		Transaction tx = null;
		final UserDTO aUserDTO = new UserDTO();

		try
		{
			theSession = getSession();
			tx = theSession.getTransaction();

			/**** Check for invalid role id ****/
			Criteria theCriteria = theSession.createCriteria(UserRole.class, "UserRoleMenu").add(Restrictions.eq("roleId", iRoleId));
			final List<UserRole> theUserRoleMenuList = theCriteria.list();
			if (theUserRoleMenuList.isEmpty())
			{
				final UPCException upcEx = new UPCException();
				upcEx.setError(UPCErrorConstants.ErrorCode.INVALID_ROLE_ID_ERROR);
				throw upcEx;
			}

			User aUser = null;
			/*** Adding new user ****/
			if (isCreate)
			{
				aUser = (User) theSession.createCriteria(User.class, "user").add(Restrictions.eq("loginID", iLoginId)).uniqueResult();
				if (aUser != null)
				{
					final UPCException upcEx = new UPCException();
					upcEx.setError(UPCErrorConstants.ErrorCode.USERNAME_ALREADY_EXISTS_ERROR);
					throw upcEx;
				}
				aUser = new User();
				aUser.setLoginID(iLoginId);
				aUser.setUserName(iUsername);
				aUser.setUserPassword(iPassword);
				aUser.setUserRoleID(iRoleId);
				aUser.setEnabled(isEnabled);
			}
			/*** Updating user ****/
			else
			{

				aUser = (User) theSession.createCriteria(User.class, "user").add(Restrictions.ne("userID", iUserId))
						.add(Restrictions.eq("loginID", iLoginId)).uniqueResult();

				if (aUser != null)
				{
					final UPCException upcEx = new UPCException();
					upcEx.setError(UPCErrorConstants.ErrorCode.USERNAME_ALREADY_EXISTS_ERROR);
					throw upcEx;
				}

				aUser = (User) theSession.createCriteria(User.class, "user").add(Restrictions.eq("userID", iUserId)).uniqueResult();

				aUser.setUserName(iUsername);
				aUser.setLoginID(iLoginId);
				aUser.setUserPassword(iPassword);
				aUser.setUserRoleID(iRoleId);
				aUser.setEnabled(isEnabled);
			}

			tx.begin();
			theSession.saveOrUpdate(aUser);
			tx.commit();


			/**** Retrieving added/Modified user deatils ****/
			aUser = (User) theSession.createCriteria(User.class, "user").add(Restrictions.eq("loginID", iLoginId)).uniqueResult();

			theCriteria = theSession.createCriteria(UserRole.class, "UserRole")
					.add(Restrictions.eq("roleId", aUser.getUserRoleID()));
			final List<UserRole> theRoleList = theCriteria.list();
			aUserDTO.setUserID(aUser.getUserID());
			aUserDTO.setLoginID(aUser.getLoginID());
			aUserDTO.setUserName(aUser.getUserName());
			aUserDTO.setUserPassword(new String(aUser.getUserPassword()));
			aUserDTO.setUserRoleID(aUser.getUserRoleID());
			aUserDTO.setUserRoleName(theRoleList.get(0).getRoleName());
			aUserDTO.setEnabled(aUser.isEnabled());


		}
		catch (final UPCException ex)
		{
			throw ex;
		}
		catch (final RuntimeException ex)
		{
			tx.rollback();
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}
		return aUserDTO;
	}

	@SuppressWarnings("unchecked")
	public UserDTOs searchUser(final String iUsername)
	{
		Session theSession = null;
		final UserDTOs userDTOs = new UserDTOs();
		try
		{
			theSession = getSession();
			final StringBuffer aStringBuffer = new StringBuffer();
			aStringBuffer.append("%");
			if (null != iUsername)
			{
				aStringBuffer.append(iUsername);
			}
			aStringBuffer.append("%");

			Criteria theCriteria = theSession.createCriteria(User.class, "user")
					.add(Restrictions.like("userName", aStringBuffer.toString())).addOrder(Order.asc("userName"));
			final List<User> theUserList = theCriteria.list();
			final List<UserDTO> theUserDTOList = new ArrayList<UserDTO>();
			theCriteria = theSession.createCriteria(UserRole.class, "UserRole");
			final List<UserRole> theRoleList = theCriteria.list();
			final Map<Integer, String> theRoleMap = new HashMap<Integer, String>();
			for (final UserRole aUserRole : theRoleList)
			{
				theRoleMap.put(aUserRole.getRoleId(), aUserRole.getRoleName());
			}
			for (final User user : theUserList)
			{
				final UserDTO aUserDTO = new UserDTO();
				aUserDTO.setUserID(user.getUserID());
				aUserDTO.setLoginID(user.getLoginID());
				aUserDTO.setUserName(user.getUserName());
				aUserDTO.setUserPassword(new String(user.getUserPassword()));
				aUserDTO.setUserRoleID(user.getUserRoleID());
				aUserDTO.setUserRoleName(theRoleMap.get(user.getUserRoleID()));
				aUserDTO.setEnabled(user.isEnabled());
				theUserDTOList.add(aUserDTO);
			}
			userDTOs.setUser(theUserDTOList);
		}
		catch (final RuntimeException ex)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}

		return userDTOs;
	}

	@SuppressWarnings("unchecked")
	public List<RedemptionInfoDTO> getUserRedemptionInfo(final String iCustomerId)
	{

		Session theSession = null;
		Criteria theCriteria = null;
		final List<RedemptionInfoDTO> redemptionInfoList = new ArrayList<RedemptionInfoDTO>();
		try
		{
			theSession = getSession();
			theCriteria = theSession.createCriteria(CustomerRedemption.class, "customerredemptions")
					.add(Restrictions.eq("customerredemptions.id.customerId", iCustomerId)).addOrder(Order.asc("redemptionDate"));
			final List<CustomerRedemption> theCustomerRedemptionList = theCriteria.list();
			if (theCustomerRedemptionList.isEmpty())
			{
				final UPCException upcEx = new UPCException();
				upcEx.setError(UPCErrorConstants.ErrorCode.INVALID_CUSTOMER_ID_ERROR);
				throw upcEx;
			}
			for (final CustomerRedemption aRedemptionInfo : theCustomerRedemptionList)
			{
				final RedemptionInfoDTO redemptionInfoDTO = new RedemptionInfoDTO();
				redemptionInfoDTO.setPackCodeSetName(aRedemptionInfo.getPackCodeSet().getPackCodeSetName());
				redemptionInfoDTO.setPromotionName(aRedemptionInfo.getPackCodeSet().getPromotion().getPromotionName());
				redemptionInfoDTO.setRedemptionDate(aRedemptionInfo.getRedemptionDate());
				redemptionInfoDTO.setPromotionCode(aRedemptionInfo.getId().getPromotionCode());
				redemptionInfoList.add(redemptionInfoDTO);
			}
		}
		catch (final UPCException upcEx)
		{
			throw upcEx;
		}
		catch (final RuntimeException ex)
		{
			final UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		}
		finally
		{
			releaseSession(theSession);
		}
		return redemptionInfoList;
	}

	private UserRolesDTO getUserRolesDTO(final List<UserRole> iRoleList, final List<Menu> iMenuList) throws Exception
	{
		final List<RoleDTO> theRoleDTOList = new ArrayList<RoleDTO>();
		final Map<Integer, String> aMenuMap = new HashMap<Integer, String>();
		for (final Menu aMenu : iMenuList)
		{
			aMenuMap.put(aMenu.getMenuId(), aMenu.getMenuName());
		}

		for (final UserRole aUserRole : iRoleList)
		{

			final RoleDTO aRoleDTO = new RoleDTO();
			aRoleDTO.setRoleId(aUserRole.getRoleId());
			aRoleDTO.setRoleName(aUserRole.getRoleName());

			if (theRoleDTOList.contains(aRoleDTO))
			{
				final RoleDTO roleDTO = theRoleDTOList.get(theRoleDTOList.indexOf(aRoleDTO));

				if (aUserRole.getMenu().getParentId() != 0)
				{
					final MenuDTO aParentMenuDTO = new MenuDTO();
					aParentMenuDTO.setMenuId(aUserRole.getMenu().getParentId());
					aParentMenuDTO.setMenuName(aMenuMap.get(aUserRole.getMenu().getParentId()));
					if (null != roleDTO.getMenu().get(roleDTO.getMenu().indexOf(aParentMenuDTO)).getSubMenu())
					{
						roleDTO.getMenu().get(roleDTO.getMenu().indexOf(aParentMenuDTO)).getSubMenu()
								.put(aUserRole.getMenu().getMenuId(), aUserRole.getMenu().getMenuName());
					}
					else
					{
						final Map<Integer, String> aMap = new HashMap<Integer, String>();
						aMap.put(aUserRole.getMenu().getMenuId(), aUserRole.getMenu().getMenuName());
						roleDTO.getMenu().get(roleDTO.getMenu().indexOf(aParentMenuDTO)).setSubMenu(aMap);
					}
				}
				else
				{
					final MenuDTO aMenuDTO = new MenuDTO();
					aMenuDTO.setMenuId(aUserRole.getMenu().getMenuId());
					aMenuDTO.setMenuName(aUserRole.getMenu().getMenuName());
					roleDTO.getMenu().add(aMenuDTO);
				}
				theRoleDTOList.remove(aRoleDTO);
				theRoleDTOList.add(roleDTO);
			}
			else
			{
				final MenuDTO aMenuDTO = new MenuDTO();
				aMenuDTO.setMenuId(aUserRole.getMenu().getMenuId());
				aMenuDTO.setMenuName(aUserRole.getMenu().getMenuName());
				final List<MenuDTO> aMenuDTOs = new ArrayList<MenuDTO>();
				aMenuDTOs.add(aMenuDTO);
				aRoleDTO.setMenu(aMenuDTOs);
				theRoleDTOList.add(aRoleDTO);
			}

		}
		final UserRolesDTO aUserRolesDTO = new UserRolesDTO();
		aUserRolesDTO.setUserRole(theRoleDTOList);
		return aUserRolesDTO;
	}

	// =================================================
	// Accessors
	// =================================================

}
