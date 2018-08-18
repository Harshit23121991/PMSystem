package com.kelloggs.upc.common.utils;

import static com.kelloggs.upc.common.constants.UPCServiceConstants.UPC_ARR;
import static com.kelloggs.upc.common.constants.UPCServiceConstants.UPC_ARR_LEN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import com.kelloggs.upc.common.constants.UPCErrorConstants;
import com.kelloggs.upc.common.constants.UPCServiceConstants;
import com.kelloggs.upc.common.exception.UPCException;

public class UPCUtils {
	
	
	/**
	 * @return
	 * 
	 * Returns a random code based on the UPC_ARR and UP_ARR_LEN.
	 */
	public static String generateCode(final String codePrefix) {
		Random random = new Random();
		StringBuilder randomCode = new StringBuilder();
		
		randomCode.append(codePrefix);
		
		int upcSize = UPCServiceConstants.UPC_LEN - codePrefix.length(); 
		for (int i = 0; i < upcSize; i++) {
			randomCode.append(UPC_ARR[random.nextInt(UPC_ARR_LEN)]);
		}
		return randomCode.toString();
	}
	
	
	/**
	 * @param batchSize
	 * @return
	 * Returns a Set of Unique Pack Codes based on the batchsize.
	 */
	public static Set<String> buildPackCodes(final String prefix, final int batchSize) {

		Set<String> uniquePackCodes = new HashSet<String>(batchSize * 2);
		Random random = new Random();
		int upcSize = UPCServiceConstants.UPC_LEN - prefix.length();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < batchSize; i++) {
			sb = new StringBuilder();
			sb.append(prefix);
			for (int j = 0; j < upcSize; j++) {
				sb.append(UPC_ARR[random.nextInt(UPC_ARR_LEN)]);
			}

			uniquePackCodes.add(sb.toString());
			sb = null;
		}

		return uniquePackCodes;

	}
	
	/**
	 * @param stringTODate
	 * @return
	 * Converts date in  String format to Date object.
	 */
	public static Date converterToDate(final String stringTODate) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date convertedDate = null;
		try {
			convertedDate = dateFormat.parse(stringTODate);
		} catch (ParseException e) {
			UPCException upcEx = new UPCException();
			upcEx.setError(UPCErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
			throw upcEx;
		}
		return convertedDate;
	}
	
	
	/**
	 * @return
	 * 
	 * Converts current time into corresponding Date object in GMT.
	 */
	public static Date getGMTFromDefaultTimeZone() {
		

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MILLISECOND, -(TimeZone.getDefault().getRawOffset()));
		
		return calendar.getTime();	
		
	}
	
	
	/**
	 * @param date
	 * @return
	 * 
	 * Converts the given date into corresponding Date object in GMT.
	 */
	public static Date getGMTFromDefaultTimeZone(final Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MILLISECOND, -(TimeZone.getDefault().getRawOffset()));
		return calendar.getTime();
		
	}
	
}
