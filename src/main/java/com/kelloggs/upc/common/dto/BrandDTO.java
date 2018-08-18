/**
 *
 */
package com.kelloggs.upc.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * @author brout
 *
 */
@XmlRootElement(name = "brand", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("brand")
public class BrandDTO implements Serializable
{
	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 2818020043212551189L;
	// =================================================
	// Instance Variables
	// =================================================

	private String brandID;

	private String brandName;

	private String brandCode;

	private CountryDTO country;

	/** The message. */
	private String message;


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
	// =================================================
	// Accessors
	// =================================================



	public String getBrandName()
	{
		return brandName;
	}

	public void setBrandName(final String iBrandName)
	{
		this.brandName = iBrandName;
	}

	public String getBrandCode()
	{
		return brandCode;
	}

	public void setBrandCode(final String iBrandCode)
	{
		this.brandCode = iBrandCode;
	}

	public CountryDTO getCountry()
	{
		return country;
	}

	public void setCountry(final CountryDTO iCountry)
	{
		this.country = iCountry;
	}

	public String getBrandID()
	{
		return brandID;
	}

	public void setBrandID(final String brandID)
	{
		this.brandID = brandID;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(final String message)
	{
		this.message = message;
	}

}
