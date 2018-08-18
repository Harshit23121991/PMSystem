/**
 *  Contains constants wrt to UPCService.
 */
package com.kelloggs.upc.common.constants;

import java.io.File;


public class UPCServiceConstants
{

	public static final char[] UPC_ARR =
	{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z' };

	public static final short UPC_ARR_LEN = (short) UPC_ARR.length;

	public static final int UPC_LEN = 10;

	public static final String EMPTY_STRING = "";
	public static final String WINDOWS_FILE_SEPERATOR = "\\";

	public static final String NEW_LINE_CHARACTER = System.getProperty("line.separator");

	public static final int DEFAULT_UPC_BUFFER_SIZE = 10240;
	/*
	 * Promotion codes related constants.
	 */
	// batchSize = 1 million(10 lakhs).
	public static final int PROMOTION_CODES_BATCH_SIZE = 1000000;

	public static final String PROPERTY_PROMOTION_CODES_SHARED_DIR = "upc.promotion.codes.shared.dir.path";

	public static final String PROPERTY_PROMOTION_CODES_DB_DIR = "upc.promotion.codes.db.dir.path";

	public static final String PREFIX_PROMOTION_FOLDER = "promotion_";

	public static final String PREFIX_PACK_CODE_SET_FOLDER = "packcodeset_";

	public static final String PREFIX_BATCH_FILE = "batch_";

	public static final String PLACEHOLDER_PROMOTION_BASE_FOLDER = "<PROMOTION_BASE_FOLDER>";

	public static final String PLACEHOLDER_PROMOTION_ID = "<PROMOTION_ID>";
	public static final String PLACEHOLDER_PACK_CODE_SET_ID = "<PACK_CODE_SET_ID>";
	public static final String PLACEHOLDER_BATCH_ID = "<BATCH_ID>";
	public static final String SUFFIX_CSV_FILE = ".csv";

	// Example of new batch file is D:\promotion_1\packcodeset_2\batch_3.csv
	public static final String BATCH_FILE_PATH = new StringBuilder().append(PLACEHOLDER_PROMOTION_BASE_FOLDER)
			.append(File.separator).append(PREFIX_PROMOTION_FOLDER).append(PLACEHOLDER_PROMOTION_ID).append(File.separator)
			.append(PREFIX_PACK_CODE_SET_FOLDER).append(PLACEHOLDER_PACK_CODE_SET_ID).append(File.separator)
			.append(PREFIX_BATCH_FILE).append(PLACEHOLDER_BATCH_ID).append(SUFFIX_CSV_FILE).toString();


	public static final String WINDOWS_BATCH_FILE_PATH = new StringBuilder().append(PLACEHOLDER_PROMOTION_BASE_FOLDER)
			.append(WINDOWS_FILE_SEPERATOR).append(PREFIX_PROMOTION_FOLDER).append(PLACEHOLDER_PROMOTION_ID)
			.append(WINDOWS_FILE_SEPERATOR).append(PREFIX_PACK_CODE_SET_FOLDER).append(PLACEHOLDER_PACK_CODE_SET_ID)
			.append(WINDOWS_FILE_SEPERATOR).append(PREFIX_BATCH_FILE).append(PLACEHOLDER_BATCH_ID).append(SUFFIX_CSV_FILE)
			.toString();

	// Example of promotion directory is D:\promotion_1
	public static final String PROMOTION_DIRECTORY = new StringBuilder().append(PLACEHOLDER_PROMOTION_BASE_FOLDER)
			.append(File.separator).append(PREFIX_PROMOTION_FOLDER).append(PLACEHOLDER_PROMOTION_ID).toString();

	// Example of packcodeset directory is D:\promotion_1\packcodeset_2
	public static final String PACK_CODE_SET_DIRECTORY = new StringBuilder(PLACEHOLDER_PROMOTION_BASE_FOLDER)
			.append(File.separator).append(PREFIX_PROMOTION_FOLDER).append(PLACEHOLDER_PROMOTION_ID).append(File.separator)
			.append(PREFIX_PACK_CODE_SET_FOLDER).append(PLACEHOLDER_PACK_CODE_SET_ID).toString();

	// Request Params
	public static final String REQUEST_PARAM_PROMOTION_ID = "promotionId";
	public static final String REQUEST_PARAM_PACK_CODE_SET_ID = "packCodeSetId";
	public static final String REQUEST_PARAM_BATCH_ID = "batchId";
	public static final String REQUEST_PARAM_NO_OF_CODES = "noOfCodes";
	public static final String REQUEST_PARAM_USER_ID = "userId";

	// Database related constants.
	public static final short STATUS_BATCH_CODES_NOT_GENERATED = 0;
	public static final short STATUS_BATCH_CODES_GENERATED_ON_FILE_SYSTEM = 1;
	public static final short STATUS_BATCH_CODES_GENERATED_ON_DATABASE = 2;
	public static final short STATUS_BATCH_CODES_GENERATION_FAILED = 3;

	public static final short STATUS_PROMOTION_CODE_INACTIVE = 0;
	public static final short STATUS_PROMOTION_CODE_ACTIVE = 1;
	public static final short STATUS_PROMOTION_CODE_REDEEMED = 2;

	//Operation_log constants
	public static final short ENTITY_TYPE_BRAND = 0;
	public static final short ENTITY_TYPE_PROMOTION = 1;
	public static final short ENTITY_TYPE_PACK_CODE_SET = 2;

	public static final String OPERATION_TYPE_DELETE = "DELETE";
	public static final String OPERATION_TYPE_UPDATE = "UPDATE";
	public static final String OPERATION_TYPE_INSERT = "INSERT";


	public static final short BATCH_GENERATION_TYPE_NORMAL = 1;
	public static final short BATCH_GENERATION_TYPE_ALTERNATE = 2;

	public static final short LAST_HOUR = 23;
	public static final short LAST_MINUTE = 59;
	public static final short LAST_SECOND = 59;


	public static enum UPCDateFormat
	{

		DATE_AND_TIME_PATTERN("dd/MM/yyyy, HH:mm:ss");


		private final String string;

		UPCDateFormat(final String str)
		{
			this.string = str;
		}

		public String getString()
		{
			return string;
		}

	}


	public static enum UPCServiceRequestParam
	{


		//Common request params
		COUNTRY_ID("country_id"), BRAND_ID("brand_id"), PROMOTION_ID("promotion_id"), PACK_CODE_SET_ID("pack_code_set_id"), BATCH_ID(
				"batch_id"),


		//Promotion related request params.
		PROMOTION_NAME("promotion_name"), PROMOTION_CODE("promotion_code"), IS_PURGE_REQD("is_purging_reqd"), PURGE_DAYS(
				"purge_days"), PRODUCT_TYPE_ID("product_type_id"), USER_ID("user_id"),


		//Brand related request params.
		BRAND_NAME("brand_name"), BRAND_CODE("brand_code"), IS_ACTIVE("is_active"),

		//Pack Code Set related request params.
		PACK_CODE_SET_NAME("pack_code_set_name"), PRODUCT_ID("product_id"), NO_OF_CODES("no_of_codes"), START_DATE("start_date"), END_DATE(
				"end_date"),


		CUSTOMER_ID("customer_id"), FROM_DATE("from_date"), TO_DATE("to_date"),

		LOGIN_ID("login_id"), USER_NAME("user_id"), PASSWORD("password"), ROLE_ID("role_id"), IS_ENABLED("is_enabled"), IS_CREATE(
				"is_create");



		private final String string;

		UPCServiceRequestParam(final String string)
		{

			this.string = string;
		}

		public String getString()
		{
			return string;
		}


	}


}
