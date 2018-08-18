package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * The persistent class for the menu_t database table.
 * 
 */
@Entity
@Table(name = "menu_t")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private int menuId;

	@Column(name = "menu_name")
	private String menuName;

	@Column(name = "order_number")
	private int orderNumber;

	@Column(name = "parent_id")
	private int parentId;

    public Menu() {
    }

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(final int iMenuId) {
		this.menuId = iMenuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(final String iMenuName) {
		this.menuName = iMenuName;
	}

	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(final int iOrderNumber) {
		this.orderNumber = iOrderNumber;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(final int iParentId) {
		this.parentId = iParentId;
	}

}