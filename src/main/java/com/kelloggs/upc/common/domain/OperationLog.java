package com.kelloggs.upc.common.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the operation_log_t database table.
 * 
 */
@Entity
@Table(name = "operation_log_t")
public class OperationLog implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The op id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "op_id", unique = true, insertable = true, updatable = false)
	private int opId;

	/** The entity id. */
	@Column(name = "entity_id")
	private int entityId;

	/** The entity type. */
	@Column(name = "entity_type")
	private short entityType;

	/** The op time. */
	@Column(name = "op_time")
	private Date opTime;

	/** The op type. */
	@Column(name = "op_type")
	private String opType;

	//bi-directional many-to-one association to User
	/** The user. */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * Instantiates a new operation log.
	 */
	public OperationLog()
	{
	}

	/**
	 * Gets the op id.
	 * 
	 * @return the op id
	 */
	public int getOpId()
	{
		return this.opId;
	}

	/**
	 * Sets the op id.
	 * 
	 * @param iOpId
	 *           the new op id
	 */
	public void setOpId(final int iOpId)
	{
		this.opId = iOpId;
	}

	/**
	 * Gets the entity id.
	 * 
	 * @return the entity id
	 */
	public int getEntityId()
	{
		return this.entityId;
	}

	/**
	 * Sets the entity id.
	 * 
	 * @param iEntityId
	 *           the new entity id
	 */
	public void setEntityId(final int iEntityId)
	{
		this.entityId = iEntityId;
	}

	/**
	 * Gets the entity type.
	 * 
	 * @return the entity type
	 */
	public short getEntityType()
	{
		return this.entityType;
	}

	/**
	 * Sets the entity type.
	 * 
	 * @param iEntityType
	 *           the new entity type
	 */
	public void setEntityType(final short iEntityType)
	{
		this.entityType = iEntityType;
	}

	/**
	 * Gets the op time.
	 * 
	 * @return the op time
	 */
	public Date getOpTime()
	{
		return this.opTime;
	}

	/**
	 * Sets the op time.
	 * 
	 * @param iOpTime
	 *           the new op time
	 */
	public void setOpTime(final Date iOpTime)
	{
		this.opTime = iOpTime;
	}

	/**
	 * Gets the op type.
	 * 
	 * @return the op type
	 */
	public String getOpType()
	{
		return this.opType;
	}

	/**
	 * Sets the op type.
	 * 
	 * @param iOpType
	 *           the new op type
	 */
	public void setOpType(final String iOpType)
	{
		this.opType = iOpType;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser()
	{
		return this.user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param iUser
	 *           the new user
	 */
	public void setUser(final User iUser)
	{
		this.user = iUser;
	}

}
