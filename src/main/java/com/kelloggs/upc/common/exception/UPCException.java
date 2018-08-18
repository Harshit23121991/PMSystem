/**
 * UPCException.java
 */

package com.kelloggs.upc.common.exception;

import java.util.Locale;
import  com.kelloggs.upc.common.constants.UPCErrorConstants.ErrorCode;

public class UPCException extends RuntimeException {

	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = -3709264861199164443L;

	// =================================================
	// Instance Variables
	// =================================================
	
	private Locale locale;
	private String localizedErrorMessage;
	
	private Throwable rootCause;
	
	private ErrorCode error;
	// =================================================
	// Constructors
	// =================================================
	public UPCException() { 
		
	}
	
	public UPCException(ErrorCode error, Throwable rootCause){
		
		this.rootCause = rootCause;
		this.error = error;
	}
	

	public UPCException(final ErrorCode errorCode) {
		this.error = errorCode;
	}

	/**
	 * @param iErrorCode
	 * @param iErrorKey
	 * @param iLocale
	 */
	public UPCException(final ErrorCode errorCode, final Locale iLocale) {
		this(errorCode);
		this.locale = iLocale;
	}

	
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


	public String getLocalizedErrorMessage() {
		return this.localizedErrorMessage;
	}

	public void setLocalizedErrorMessage(final String iLocalizedErrorMessage) {
		this.localizedErrorMessage = iLocalizedErrorMessage;
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(final Locale iLocale) {
		this.locale = iLocale;
	}

	public ErrorCode getError() {
		return error;
	}

	public void setError(final ErrorCode iError) {
		this.error = iError;
	}

	public Throwable getRootCause() {
		return rootCause;
	}

	public void setRootCause(Throwable rootCause) {
		this.rootCause = rootCause;
	}



}
