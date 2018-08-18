package com.kelloggs.upc.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "user", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("user")
public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userID;
	private String loginID;
	private String userName;
	private int userRoleID;
	private String userRoleName;
	private String userPassword;
	private boolean isEnabled;

	public String getUserName() {
		return userName;
	}
	public void setUserName(final String iUserName) {
		this.userName = iUserName;
	}
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(final int iUserRoleID) {
		this.userRoleID = iUserRoleID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(final String iUserPassword) {
		this.userPassword = iUserPassword;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(final boolean iIsEnabled) {
		this.isEnabled = iIsEnabled;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(final int iUserID) {
		this.userID = iUserID;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(final String iLoginID) {
		this.loginID = iLoginID;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(final String iUserRoleName) {
		this.userRoleName = iUserRoleName;
	}
}
