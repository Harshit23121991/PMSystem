package com.kelloggs.upc.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "packs", namespace = "com.kelloggs.upc.common.dto")
//@XStreamAlias("packs")
public class PacksDTO {
	
	
	private List<PackDTO> aPacks;
	@XmlElement(name = "Pack")
	public List<PackDTO> getaPacks() {
		return aPacks;
	}

	public void setaPacks(final List<PackDTO> iPacks) {
		this.aPacks = iPacks;
	}	
	
	
}
