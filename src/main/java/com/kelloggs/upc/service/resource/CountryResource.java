package com.kelloggs.upc.service.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kelloggs.upc.common.dto.CountriesDTO;
import com.kelloggs.upc.common.dto.CountryDTO;
import com.kelloggs.upc.service.service.CountryService;

@Controller
@RequestMapping(value = "/country")
public class CountryResource {
	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	@Autowired
	private CountryService countryService;
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
	@RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllCountry() {
		java.util.List<CountryDTO> aCountryList = null;
		aCountryList = countryService.getCountries();
		CountriesDTO countries = new CountriesDTO();
		countries.setaCountries(aCountryList);
		return new ModelAndView("xml", "countries", countries);

	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getCountryDetails(@RequestParam("countryid") final String iCountryId,
			@RequestParam("countrycode") final String iCountryCode) {

		CountriesDTO countries = null;
		countries = countryService.getCountries(iCountryId, iCountryCode);
		List<CountryDTO> theCountryDTOList = countries.getaCountries();
		CountryDTO aCountryDTO = null;
		if (!theCountryDTOList.isEmpty()) {
			aCountryDTO = theCountryDTOList.get(0);
		} else {
			aCountryDTO = new CountryDTO();
		}
		return new ModelAndView("xml", "countries", aCountryDTO);
	}
     
}
