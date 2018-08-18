package com.kelloggs.upc.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XmlRootElement(name = "countries", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("countries")
public class CountriesDTO {
	
	
	private List<CountryDTO> aCountries;
		
	@XmlElement(name = "Country")
	public List<CountryDTO> getaCountries() {
		return aCountries;
	}

	public void setaCountries(final List<CountryDTO> iCountries) {
		this.aCountries = iCountries;
	}
}
