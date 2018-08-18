package com.kelloggs.upc.common.dto;


/**
 * The Class SignInDTO.
 */
public class SignInDTO {
	
	/** The id. */
	private String id;
	
	/** The display name. */
	private String displayName;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param iId the new id
	 */
	public void setId(final String iId) {
		this.id = iId;
	}
	
	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}
	
	/**
	 * Sets the display name.
	 *
	 * @param iDisplayName the new display name
	 */
	public void setDisplayName(final String iDisplayName) {
		this.displayName = iDisplayName;
	}

}
