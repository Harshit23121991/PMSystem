package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XmlRootElement(name = "userRoles", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("userRoles")
public class UserRolesDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RoleDTO> userRole;
	public List<RoleDTO> getUserRole() {
		return userRole;
	}
	public void setUserRole(final List<RoleDTO> iUserRole) {
		this.userRole = iUserRole;
	}
	
}
