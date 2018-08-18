/*
 * Copyright (c) 2014, Cluster India.
 * 
 */
package com.kelloggs.upc.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * The Class GenerateCodeContext.
 */
@Component
public class GenerateCodeContext
{

	/** The generate code interface. */
	@Autowired
	@Qualifier(value = "fileGenerateCodeStrategy")
	private GenerateCodeStrategy generateCodeInterface;

	/**
	 * Execute generate unique pack codes.
	 * 
	 * @param promotionId
	 *           the promotion id
	 * @param packCodeSetId
	 *           the pack code set id
	 * @param noOfCodes
	 *           the no of codes
	 * @param userId
	 *           the user id
	 * @return true, if successful
	 */
	public boolean executeGenerateUniquePackCodes(final int promotionId, final int packCodeSetId, final int noOfCodes,
			final short userId)
	{

		return generateCodeInterface.generateUniquePackCodes(promotionId, packCodeSetId, noOfCodes, userId);
	}

}
