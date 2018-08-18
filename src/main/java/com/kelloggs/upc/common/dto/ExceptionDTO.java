/**
 * ExceptionDTO.java
 */

package com.kelloggs.upc.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XmlRootElement(name = "error", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("error")
public class ExceptionDTO {

	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	private int errorCode;
	private String errorKey;
	private String errorMessage;
	private String localizedErrorMessage;

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
	public int getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(final int iErrorCode) {
		this.errorCode = iErrorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(final String iErrorMessage) {
		this.errorMessage = iErrorMessage;
	}

	public String getLocalizedErrorMessage() {
		return this.localizedErrorMessage;
	}

	public void setLocalizedErrorMessage(final String iLocalizedErrorMessage) {
		this.localizedErrorMessage = iLocalizedErrorMessage;
	}

	public String getErrorKey() {
		return this.errorKey;
	}

	public void setErrorKey(final String iErrorKey) {
		this.errorKey = iErrorKey;
	}
}
