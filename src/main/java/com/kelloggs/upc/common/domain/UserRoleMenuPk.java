package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRoleMenuPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_role_id")
	private int userRoleID;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "menu_name")
	private String menuName;

	public UserRoleMenuPk() {
		// TODO Auto-generated constructor stub
	}

	public UserRoleMenuPk(final int iUserRoleID, final String iRoleName, final String iMenuName) {
		this.userRoleID = iUserRoleID;
		this.roleName = iRoleName;
		this.menuName = iMenuName;
	}

	public int getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(final int iUserRoleID) {
		this.userRoleID = iUserRoleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(final String iRoleName) {
		this.roleName = iRoleName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(final String iMenuName) {
		this.menuName = iMenuName;
	}

	@Override
	public boolean equals(final Object arg0) {
		if (arg0 == null) {
			return false;
		}
		if (!(arg0 instanceof UserRoleMenuPk)) {
			return false;
		}
		UserRoleMenuPk arg1 = (UserRoleMenuPk) arg0;
		return (this.userRoleID == arg1.getUserRoleID())
				&& (arg1.getRoleName().equals(this.roleName))
				&& (arg1.getMenuName().equals(this.menuName));

	}

	@Override
	public int hashCode() {
		int code = 0;
		code += userRoleID;
		if (roleName != null) {
			code += roleName.hashCode();
		}
		if (menuName != null) {
			code += menuName.hashCode();
		}
		return code;
	}
}