package com.kelloggs.upc.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XmlRootElement(name = "country", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("country")
public class CountryDTO implements Serializable
{
	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 2818020043216551189L;
	// =================================================
	// Instance Variables
	// =================================================
	private String countryID;

	private String countryName;

	private String countryCode;


	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(final String icountryCode)
	{
		this.countryCode = icountryCode;
	}



	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName(final String iCountryName)
	{
		this.countryName = iCountryName;
	}

	public String getCountryID()
	{
		return countryID;
	}

	public void setCountryID(final String countryID)
	{
		this.countryID = countryID;
	}

}
