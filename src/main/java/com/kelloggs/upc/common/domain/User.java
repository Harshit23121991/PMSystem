package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_t")
public class User implements Serializable {
	

	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 8731182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, insertable = true, updatable = false)
	private int userID;
	
	@Column(name = "login_id", unique = true)
	private String loginID;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_role_id")
	private int userRoleID;
	
	@Column(name = "user_password")
	private byte[] userPassword;
	
	@Column(name = "is_enabled")
	private boolean isEnabled;
	
	
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
	// =================================================
	// Private Methods
	// =================================================

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(final boolean iIsEnabled) {
		this.isEnabled = iIsEnabled;
	}
	// =================================================
	// Accessors
	// =================================================

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

	public byte[] getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(final byte[] iUserPassword) {
		this.userPassword = iUserPassword;
	}

}
