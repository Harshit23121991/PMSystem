package com.kelloggs.upc.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kelloggs.upc.common.constants.UPCErrorConstants;
import com.kelloggs.upc.common.constants.UPCServiceConstants;
import com.kelloggs.upc.common.domain.Batch;
import com.kelloggs.upc.common.domain.Pack;
import com.kelloggs.upc.common.domain.User;
import com.kelloggs.upc.common.dto.BatchDTO;
import com.kelloggs.upc.common.exception.UPCException;
import com.kelloggs.upc.common.utils.UPCUtils;

@Repository
public class BatchDAOImpl extends BaseDaoImpl implements BatchDAO {


	// =================================================
	// Private Methods
	// =================================================
	// =================================================
	// Accessors
	// =================================================
	@SuppressWarnings("unchecked")
	public List<BatchDTO> getBatchs(final Integer iPackCodeSetId) {
		List<Batch> theBatchList = new ArrayList<Batch>();
		List<BatchDTO> batchDTOList = new ArrayList<BatchDTO>();
		Session theSession = null;
		try {
			theSession = getSession();
			final Criteria theCriteria = theSession.createCriteria(Batch.class, "batch")
					.add(Restrictions.eq("batch.packCodeSet.packCodeSetID", iPackCodeSetId));
			theBatchList = (List<Batch>) theCriteria.list();
			
			BatchDTO batchDTO = null;
			for (Batch batch : theBatchList) {
				batchDTO = new BatchDTO();
				batchDTO.setPromotionBatchID(batch.getPromotionBatchID());
				batchDTO.setNoOfCodes(batch.getNoOfCodes());
				batchDTO.setGeneratedBy(batch.getCreatedBy().getUserName());
				batchDTO.setGeneratedDate(batch.getCreatedDate());
				batchDTO.setType(batch.getType());
				if (batch.getRequestedBy() != null) {
					batchDTO.setDownloadedBy(batch.getRequestedBy().getUserName());
				}	
				batchDTO.setDownloadedDate(batch.getRequestedDate());
				batchDTO.setStatus(batch.getStatus());		
				
				batchDTOList.add(batchDTO);
			}
		} catch (RuntimeException ex) {
			UPCException upcEx = new UPCException();
			upcEx.setRootCause(ex);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		} finally {
			releaseSession(theSession);
		}
		return batchDTOList;
	}
	public Integer createBatch(final int iPackCodeSetId, final int iNoOfCodes, final short iUserId) {

		Session session = getSession();
		Integer batchId = null;
		Transaction tx = session.getTransaction();
		
		try {

			// 1.Building the Batch.
			Batch aBatch = new Batch();
			Pack pack = new Pack();
			pack.setPackCodeSetID(iPackCodeSetId);
			aBatch.setPackCodeSet(pack);
			aBatch.setNoOfCodes(iNoOfCodes);
			User user = new User();
			user.setUserID(iUserId);
			aBatch.setCreatedBy(user);
			aBatch.setCreatedDate(UPCUtils.getGMTFromDefaultTimeZone());
			aBatch.setType(UPCServiceConstants.BATCH_GENERATION_TYPE_NORMAL);

			
			// Begin Transaction.
			
			tx.begin();
			// Saving.
			batchId = (Integer) session.save(aBatch);
			// Transaction commmit.
			tx.commit();

		} catch (RuntimeException runEx) {
			// Transaction rollback.
			try {
				tx.rollback();
			} catch (RuntimeException runEx1) {
				runEx1.printStackTrace();
			}
			UPCException upcEx = new UPCException();
			upcEx.setRootCause(runEx);
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;
		} finally {
			releaseSession(session);
		}

		return batchId;

	}

	public boolean updateBatchStatus(final int iBatchId, final short iStatus) {

		Session session = getSession();
		Transaction tx = session.getTransaction();
		
		try {

			tx.begin();
			Batch batch1 = (Batch) session.createCriteria(Batch.class).add(Restrictions.idEq(iBatchId)).uniqueResult();
			batch1.setStatus(iStatus);
			session.update(batch1);
			tx.commit();

		} catch (RuntimeException runEx) {
			
			UPCException upcEx = new UPCException();
			upcEx.setRootCause(runEx);
			// Transaction rollback.
			try {
				tx.rollback();
			} catch (RuntimeException runEx1) {
				upcEx.setRootCause(runEx1);
			}
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;

		} finally {

			releaseSession(session);
		}

		return true;
	}
	
	
	public boolean updateRequestedByForBatch(final int iBatchId, final short iUserId) {
		
		Session session = getSession();
		Transaction tx = session.getTransaction();
		
		try {

			session = getSession();
			tx = session.beginTransaction();
			tx.begin();
			Batch aBatch = (Batch) session.createCriteria(Batch.class).add(Restrictions.idEq(iBatchId)).uniqueResult();
			
			User user = new User();
			user.setUserID(iUserId);
			aBatch.setRequestedBy(user);
			aBatch.setRequestedDate(UPCUtils.getGMTFromDefaultTimeZone());

			session.update(aBatch);
			tx.commit();

		} catch (RuntimeException runEx) {
			
			UPCException upcEx = new UPCException();
			upcEx.setRootCause(runEx);
			// Transaction rollback.
			try {
				tx.rollback();
			} catch (RuntimeException runEx1) {
				upcEx.setRootCause(runEx1);
			}
			upcEx.setError(UPCErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw upcEx;

		} finally {

			releaseSession(session);
		}

		return true;

		
		
		
	}

}
