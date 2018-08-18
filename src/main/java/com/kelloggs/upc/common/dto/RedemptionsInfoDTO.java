package com.kelloggs.upc.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name = "RedemptionsInfo", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("RedemptionsInfo")
public class RedemptionsInfoDTO {

	private List<RedemptionInfoDTO> redemptionInfo;

	@XmlElement(name = "RedemptionInfo")
	public List<RedemptionInfoDTO> getRedemptionInfo() {
		return redemptionInfo;
	}

	public void setRedemptionInfo(final List<RedemptionInfoDTO> iRedemptionInfo) {
		this.redemptionInfo = iRedemptionInfo;
	}
}
