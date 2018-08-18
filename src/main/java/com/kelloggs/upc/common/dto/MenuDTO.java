package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "menu", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("menu")
public class MenuDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int menuId;
	private String menuName;
	private Map<Integer, String> subMenu;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(final int iMenuId) {
		this.menuId = iMenuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(final String iMenuName) {
		this.menuName = iMenuName;
	}
	public Map<Integer, String> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(final Map<Integer, String> iSubMenu) {
		this.subMenu = iSubMenu;
	}
	
	@Override
	public boolean equals(final Object arg0) {
		if (arg0 == null) {
			return false;
		}
		if (!(arg0 instanceof MenuDTO)) {
			return false;
		}
		MenuDTO arg1 = (MenuDTO) arg0;
		return (this.menuId == arg1.getMenuId()) && (arg1.getMenuName().equals(this.menuName));

	}

	@Override
	public int hashCode() {
		int code = 0;
		code += menuId;
		if (menuName != null) {
			code += menuName.hashCode();
		}
		return code;
	}

}
