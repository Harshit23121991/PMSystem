package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the user_role_t database table.
 * 
 */
@Entity
@Table(name = "user_role_t")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "sl_no")
	private int slNo;
	
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

	//bi-directional many-to-one association to Menu
    @ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

    public UserRole() {
    }

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(final int iRoleId) {
		this.roleId = iRoleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(final String iRoleName) {
		this.roleName = iRoleName;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(final Menu iMenu) {
		this.menu = iMenu;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(final int iSlNo) {
		this.slNo = iSlNo;
	}
	
}