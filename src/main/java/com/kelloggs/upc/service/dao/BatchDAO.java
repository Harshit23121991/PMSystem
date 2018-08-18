package com.kelloggs.upc.service.dao;

import java.util.List;

import com.kelloggs.upc.common.dto.BatchDTO;

public interface BatchDAO extends BaseDao {

	public List<BatchDTO> getBatchs(Integer iPackCodeSetId);

	public Integer createBatch(int iPackCodeSetId, int iNoOfCodes, short iUserId);

	public boolean updateBatchStatus(int iBatchId, short iStatus);
	
	public boolean updateRequestedByForBatch(int iBatch, short iUserId);

}
