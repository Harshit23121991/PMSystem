package com.kelloggs.upc.service.strategy;

public interface GenerateCodeStrategy
{

	public boolean generateUniquePackCodes(int promotionId, int packCodeSetId, int noOfCodes, short userId);

}
