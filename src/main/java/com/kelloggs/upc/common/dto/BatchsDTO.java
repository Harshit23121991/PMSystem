package com.kelloggs.upc.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;



@XmlRootElement(name = "batchs", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("batchs")
public class BatchsDTO {
	

	private List<BatchDTO> aBatchs;
	
	@XmlElement(name = "Batch")
	public List<BatchDTO> getaBatchs() {
		return aBatchs;
	}

	public void setaBatchs(final List<BatchDTO> iBatchs) {
		this.aBatchs = iBatchs;
	}
	
}
