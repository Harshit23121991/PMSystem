/*
 * AuthenticationFilter.java
 * This Class filters all the request to the rest services and authenticates the request
 *
 * */
package com.kelloggs.upc.service.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.kelloggs.upc.service.service.AuthenticationService;


public class AuthenticationFilter implements Filter
{
	// =================================================
	// Class Variables
	// =================================================
	@Autowired
	private AuthenticationService authenticationService;

	// =================================================
	// Instance Variables
	// =================================================
	// =================================================
	// Constructors
	// =================================================
	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================
	// =================================================
	// Overridden Methods
	// =================================================

	public void destroy()
	{
		// TODO Auto-generated method stub

	}


	public void doFilter(final ServletRequest iRequest, final ServletResponse iResponse, final FilterChain filterChain)
			throws IOException, ServletException
	{
		final HttpServletRequest ahttpServletRequest = (HttpServletRequest) iRequest;
		final HttpServletResponse aHttpServletResponse = (HttpServletResponse) iResponse;
		if (authenticationService.isValid(ahttpServletRequest.getHeader("appid"), ahttpServletRequest.getHeader("key")))
		{
			filterChain.doFilter(iRequest, iResponse);
		}
		else
		{
			aHttpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}
	}


	public void init(final FilterConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub

	}

}
