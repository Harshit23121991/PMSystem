/**
 * UPCExceptionResolver.java
 */

package com.kelloggs.upc.service.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kelloggs.upc.common.dto.ExceptionDTO;
import com.kelloggs.upc.common.exception.UPCException;

public class UPCExceptionResolver implements HandlerExceptionResolver {

	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	private int order;

	// =================================================
	// Constructors
	// =================================================
	// =================================================
	// Overridden Methods
	// =================================================
	/**
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public ModelAndView resolveException(final HttpServletRequest iRequest, final HttpServletResponse iResponse, final Object iHandler,
			final Exception iException) {
		iException.printStackTrace();
		final ExceptionDTO anExceptionDTO = new ExceptionDTO();
		if (iException instanceof UPCException) {
			anExceptionDTO.setErrorKey(((UPCException) iException).getError().getKey());
			anExceptionDTO.setErrorMessage(((UPCException) iException).getError().getMessage());

		} else {
			anExceptionDTO.setErrorMessage(iException.getMessage());
		}
		return new ModelAndView("plist", "error", anExceptionDTO);
	}

	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================
	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================
	public int getOrder() {
		return this.order;
	}

	public void setOrder(final int iOrder) {
		this.order = iOrder;
	}
}
