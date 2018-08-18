/**
 * 
 */
package com.kelloggs.upc.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author aku148
 *
 */
@XmlRootElement(name = "response", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("response")
public class ResponseDTO {
	
	
	private String status;
	
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(final String iStatus) {
		this.status = iStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String iMessage) {
		this.message = iMessage;
	}
	
	

}
