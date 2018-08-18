/**
 * 
 */
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


@Entity
@Table(name = "promotion_batch_t")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Batch implements Serializable
{
	// =================================================
	// Class Variables 
	// =================================================
	private static final long serialVersionUID = 8761182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Id
	@Column(name = "PROMOTION_BATCH_ID", unique = true, insertable = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int promotionBatchID;

	@Column(name = "NO_OF_CODES")
	private int noOfCodes;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "REQUESTED_DATE")
	private Date requestedDate;

	@ManyToOne
	@JoinColumn(name = "requested_by", insertable = true, updatable = true)
	private User requestedBy;

	@Column(name = "status")
	private short status;

	//bi-directional many-to-one association to Pack
	@ManyToOne
	@JoinColumn(name = "pack_code_set_id")
	private Pack packCodeSet;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "created_by", insertable = true, updatable = true)
	private User createdBy;

	@Column(name = "type")
	private int type;

	public short getStatus()
	{
		return status;
	}

	public void setStatus(final short theStatus)
	{
		this.status = theStatus;
	}


	public int getPromotionBatchID()
	{
		return promotionBatchID;
	}

	public void setPromotionBatchID(final int iPromotionBatchID)
	{
		this.promotionBatchID = iPromotionBatchID;
	}

	public int getNoOfCodes()
	{
		return noOfCodes;
	}

	public void setNoOfCodes(final int iNoOfCodes)
	{
		this.noOfCodes = iNoOfCodes;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(final Date iCreatedDate)
	{
		this.createdDate = iCreatedDate;
	}

	public Date getRequestedDate()
	{
		return requestedDate;
	}

	public void setRequestedDate(final Date iRequestedDate)
	{
		this.requestedDate = iRequestedDate;
	}

	public User getRequestedBy()
	{
		return requestedBy;
	}

	public void setRequestedBy(final User iRequestedBy)
	{
		this.requestedBy = iRequestedBy;
	}

	public Pack getPackCodeSet()
	{
		return packCodeSet;
	}

	public void setPackCodeSet(final Pack iPackCodeSet)
	{
		this.packCodeSet = iPackCodeSet;
	}

	public User getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(final User iCreatedBy)
	{
		this.createdBy = iCreatedBy;
	}

	public int getType()
	{
		return type;
	}

	public void setType(final int iType)
	{
		this.type = iType;
	}



}
