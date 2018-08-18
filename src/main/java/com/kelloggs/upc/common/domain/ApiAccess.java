package com.kelloggs.upc.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "api_access_t")
public class ApiAccess implements Serializable
{
	// =================================================
	// Class Variables 
	// =================================================
	private static final long serialVersionUID = 8731182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Id
	@Column(name = "app_id", unique = true, insertable = true, updatable = false)
	private int appId;

	@Column(name = "is_enabled")
	private boolean isEnabled;

	@Column(name = "public_key")
	private byte[] publicKey;

	public byte[] getPublicKey()
	{
		return publicKey;
	}

	public void setPublicKey(final byte[] iPublicKey)
	{
		this.publicKey = iPublicKey;
	}

	public byte[] getPrivateKey()
	{
		return privateKey;
	}

	public void setPrivateKey(final byte[] iPrivateKey)
	{
		this.privateKey = iPrivateKey;
	}

	@Column(name = "private_key")
	private byte[] privateKey;

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
	public int getAppId()
	{
		return appId;
	}

	public void setAppId(final int iAppId)
	{
		this.appId = iAppId;
	}

	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================

	public boolean isEnabled()
	{
		return isEnabled;
	}

	public void setEnabled(final boolean iIsEnabled)
	{
		this.isEnabled = iIsEnabled;
	}

}
