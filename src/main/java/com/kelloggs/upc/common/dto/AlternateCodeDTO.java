package com.kelloggs.upc.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XmlRootElement(name = "alternateCode", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("alternateCode")
public class AlternateCodeDTO {

	private String alternateCode;

	public String getAlternateCode() {
		return alternateCode;
	}

	public void setAlternateCode(final String theAlternateCode) {
		this.alternateCode = theAlternateCode;
	}

}
