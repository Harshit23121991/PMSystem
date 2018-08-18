package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "users", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("users")
public class UserDTOs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<UserDTO> user;

	public List<UserDTO> getUser() {
		return user;
	}

	public void setUser(final List<UserDTO> iUser) {
		this.user = iUser;
	}

}
