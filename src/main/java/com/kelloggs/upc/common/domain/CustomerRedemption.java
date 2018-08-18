package com.kelloggs.upc.common.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_redemption_t")
public class CustomerRedemption implements Serializable {
	

	// =================================================
	// Class Variables
	// =================================================
	private static final long serialVersionUID = 8731182217276505663L;

	// =================================================
	// Instance Variables
	// =================================================
	@Id
	private CustomerRedemptionPk id;
	
	@Column(name = "redemption_date")
	private Date redemptionDate;

	//bi-directional many-to-one association to Pack
    @ManyToOne
	@JoinColumn(name = "pack_code_set_id", insertable = false, updatable = false)
	private Pack packCodeSet;
    
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
	public Date getRedemptionDate() {
		return redemptionDate;
	}

	public void setRedemptionDate(final Date iRedemptionDate) {
		this.redemptionDate = iRedemptionDate;
	}

	public CustomerRedemptionPk getId() {
		return id;
	}

	public void setId(final CustomerRedemptionPk iId) {
		this.id = iId;
	}

	public Pack getPackCodeSet() {
		return packCodeSet;
	}

	public void setPackCodeSet(final Pack iPackCodeSet) {
		this.packCodeSet = iPackCodeSet;
	}

	// =================================================
	// Accessors
	// =================================================
	
}
