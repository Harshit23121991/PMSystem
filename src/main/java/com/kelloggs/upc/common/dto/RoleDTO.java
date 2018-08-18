package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "role", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("role")
public class RoleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private String roleName;
	private List<MenuDTO> menu;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(final String iRoleName) {
		this.roleName = iRoleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(final int iRoleId) {
		this.roleId = iRoleId;
	}
	public List<MenuDTO> getMenu() {
		return menu;
	}
	public void setMenu(final List<MenuDTO> iMenu) {
		this.menu = iMenu;
	}
	
	@Override
	public boolean equals(final Object arg0) {
		if (arg0 == null) {
			return false;
		}
		if (!(arg0 instanceof RoleDTO)) {
			return false;
		}
		RoleDTO arg1 = (RoleDTO) arg0;
		return (this.roleId == arg1.getRoleId()) && (arg1.getRoleName().equals(this.roleName));

	}

	@Override
	public int hashCode() {
		int code = 0;
		code += roleId;
		if (roleName != null) {
			code += roleName.hashCode();
		}
		return code;
	}
}
