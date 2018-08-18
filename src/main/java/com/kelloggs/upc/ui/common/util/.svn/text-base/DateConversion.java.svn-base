package com.kelloggs.upc.ui.common.util;

import static com.kelloggs.upc.ui.common.UPCConstants.DATE_PATTERN_DD_MM_YYYY;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kelloggs.upc.ui.common.UPCApplicationException;

/**
 * The Class DateConversion.
 */
public class DateConversion {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(DateConversion.class);

	/**
	 * Converter to date.
	 *
	 * @param iStringTODate the i string to date
	 * @return the date
	 */
	public static Date converterToDate(final String iStringTODate) {
		LOGGER.trace(" Entered converterToDate");
		DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_DD_MM_YYYY);
		Date convertedDate = null;
		try {
			convertedDate = dateFormat.parse(iStringTODate);
		} catch (ParseException e) {
			LOGGER.error("Exception :" + e);

		}
		LOGGER.trace(" Exist from converterToDate");
		return convertedDate;
	}

	/**
	 * Converter date to string.
	 *
	 * @param iDate the i date
	 * @return the string
	 */
	public static String converterDateToString(final Date iDate) {
		LOGGER.trace(" Entered converterDateToString");
		String convertedDate = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			convertedDate = df.format(iDate);
			LOGGER.debug(" Converted pattern in string format " + convertedDate);
		} catch (RuntimeException e) {
			LOGGER.error("RuntimeException Occurred ", e);
		}
		LOGGER.trace(" Entered converterDateToString");
		return convertedDate;
	}

	/**
	 * Converter date to string.
	 *
	 * @param iDate the i date
	 * @param iPattern the i pattern
	 * @return the string
	 * @throws UPCApplicationException the uPC application exception
	 */
	public static String converterDateToString(final Date iDate, final String iPattern)throws UPCApplicationException {
		String convertedDate = null;
		if (null != iPattern) {
			LOGGER.trace(" Entered converterDateToString");

			DateFormat df = new SimpleDateFormat(iPattern);
			try {
				convertedDate = df.format(iDate);
				LOGGER.debug(" Converted pattern in string format "
						+ convertedDate);
			} catch (RuntimeException e) {
				LOGGER.error("RuntimeException Occurred ", e);
			}
		} else {
			throw new UPCApplicationException(
					"Enter Corrent pattren i.e dd/MM/yyyy or dd-MM-yyyy etc ");
		}
		LOGGER.trace(" Entered converterDateToString");
		return convertedDate;
	}
	
	public static Date getEndOfDayDate() {
		
		Date systemDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(systemDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        systemDate = cal.getTime();
        
        return systemDate;
	}	
}
