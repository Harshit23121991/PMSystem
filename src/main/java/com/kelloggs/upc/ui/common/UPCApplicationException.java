package com.kelloggs.upc.ui.common;

/**
 * The Class UPCApplicationException.
 */
public class UPCApplicationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 142511440975209427L;
	
	/** The error code. */
	private Integer errorCode;
	
	/** The error key. */
	private String errorKey;
	
	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new uPC application exception.
	 */
	public UPCApplicationException() {

	}

	/**
	 * Instantiates a new uPC application exception.
	 *
	 * @param iMessage the i message
	 */
	public UPCApplicationException(final String iMessage) {
		super(iMessage);
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param iErrorCode the new error code
	 */
	public void setErrorCode(final Integer iErrorCode) {
		this.errorCode = iErrorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param iErrorMessage the new error message
	 */
	public void setErrorMessage(final String iErrorMessage) {
		this.errorMessage = iErrorMessage;
	}

	/**
	 * Gets the error key.
	 *
	 * @return the error key
	 */
	public String getErrorKey() {
		return errorKey;
	}

	/**
	 * Sets the error key.
	 *
	 * @param iErrorKey the new error key
	 */
	public void setErrorKey(final String iErrorKey) {
		this.errorKey = iErrorKey;
	}

}
