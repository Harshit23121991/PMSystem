package com.kelloggs.upc.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "CustomerRedemptions", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("CustomerRedemptions")
public class CustomerRedemptionsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<CustomerRedemptionDTO> customerRedemptions;

	public List<CustomerRedemptionDTO> getCustomerRedemptions() {
		return customerRedemptions;
	}

	public void setCustomerRedemptions(final List<CustomerRedemptionDTO> iCustomerRedemptions) {
		customerRedemptions = iCustomerRedemptions;
	}
	
}

