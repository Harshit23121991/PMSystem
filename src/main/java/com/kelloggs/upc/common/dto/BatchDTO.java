package com.kelloggs.upc.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XmlRootElement(name = "batch", namespace = "com.kelloggs.upc.common.dto")
@XStreamAlias("batch")
public class BatchDTO {
	
	// =================================================
		// Class Variables
		// =================================================
		@SuppressWarnings("unused")
		private static final long serialVersionUID = 1818020043212551189L;
		// =================================================
		// Instance Variables
		// =================================================
			
		private int promotionBatchID;

		private int packCodeSetID;

		private int noOfCodes;
		
		private String generatedBy;
		
		private Date generatedDate;
				
		private String downloadedBy;
		
		private Date downloadedDate;
		
		private short status;
		
		private int type;

		public short getStatus() {
			return status;
		}

		public void setStatus(final short iStatus) {
			this.status = iStatus;
		}
		
		
		public int getPromotionBatchID() {
			return promotionBatchID;
		}

		public void setPromotionBatchID(final int iPromotionBatchID) {
			this.promotionBatchID = iPromotionBatchID;
		}

		public int getPackCodeSetID() {
			return packCodeSetID;
		}

		public void setPackCodeSetID(final int iPackCodeSetID) {
			this.packCodeSetID = iPackCodeSetID;
		}

		public int getNoOfCodes() {
			return noOfCodes;
		}

		public void setNoOfCodes(final int iNoOfCodes) {
			this.noOfCodes = iNoOfCodes;
		}

		
		public Date getGeneratedDate() {
			return generatedDate;
		}

		public void setGeneratedDate(final Date iGeneratedDate) {
			this.generatedDate = iGeneratedDate;
		}

		
		public Date getDownloadedDate() {
			return downloadedDate;
		}

		public void setDownloadedDate(final Date iDownloadedDate) {
			this.downloadedDate = iDownloadedDate;
		}

		public String getGeneratedBy() {
			return generatedBy;
		}

		public void setGeneratedBy(final String iGeneratedBy) {
			this.generatedBy = iGeneratedBy;
		}

		public String getDownloadedBy() {
			return downloadedBy;
		}

		public void setDownloadedBy(final String iDownloadedBy) {
			this.downloadedBy = iDownloadedBy;
		}

		public int getType() {
			return type;
		}

		public void setType(final int iType) {
			this.type = iType;
		}
}
