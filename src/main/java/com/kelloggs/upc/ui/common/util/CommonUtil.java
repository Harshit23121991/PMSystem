package com.kelloggs.upc.ui.common.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.kelloggs.upc.common.dto.ExceptionDTO;
import com.kelloggs.upc.ui.common.UPCConstants;

/**
 * The Class CommonUtil.
 */
public class CommonUtil {
	
	/**
	 * Gets the exception dto.
	 *
	 * @param iExceptionDTOXml the i exception dto xml
	 * @return the exception dto
	 */
	public static ExceptionDTO getExceptionDTO(final String iExceptionDTOXml) {
		ExceptionDTO aExceptionDTO = null;
		try {
			JAXBContext context = JAXBContext.newInstance(ExceptionDTO.class);
			Unmarshaller unMarshaller = context.createUnmarshaller();
			StringReader reader = new StringReader(iExceptionDTOXml);
			aExceptionDTO = (ExceptionDTO) unMarshaller.unmarshal(reader);
		} catch (JAXBException jaxbException) {
			aExceptionDTO = new ExceptionDTO();
			aExceptionDTO.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
		}
		return aExceptionDTO;
	}
}