/**
 * Contains all the errorCodes,SuccessMessages and ErrorMessages for the UPCService. 
 */
package com.kelloggs.upc.common.constants;

/**
 * The Class UPCErrorConstants.
 */
public class UPCErrorConstants
{

	// Error Codes 
	/** The Constant ERROR_CODE_GENERATE_CODES. */
	public static final int ERROR_CODE_GENERATE_CODES = 1;

	// Error Messages 
	/** The Constant ERROR_MSG. */
	public static final String ERROR_MSG = "ERROR";

	/** The Constant ERROR_MESSAGE_GENERATE_CODES. */
	public static final String ERROR_MESSAGE_GENERATE_CODES = "Unable to generate codes";

	/** The Constant SYSTEM_ERROR_MSG. */
	public static final String SYSTEM_ERROR_MSG = "SYSTEM_ERROR";

	/** The Constant SYSTEM_ERROR_KEY. */
	public static final String SYSTEM_ERROR_KEY = "UPC_001";

	/** The Constant USERNAME_PASSWORD_DOESNT_MATCH_MSG. */
	public static final String USERNAME_PASSWORD_DOESNT_MATCH_MSG = "USERNAME_PASSWORD_DOESNT_MATCH";

	/** The Constant USERNAME_PASSWORD_DOESNT_MATCH_KEY. */
	public static final String USERNAME_PASSWORD_DOESNT_MATCH_KEY = "UPC_002";

	/** The Constant INVALID_ROLE_ID_MSG. */
	public static final String INVALID_ROLE_ID_MSG = "INVALID_ROLE_ID";

	/** The Constant INVALID_ROLE_ID_KEY. */
	public static final String INVALID_ROLE_ID_KEY = "UPC_003";

	/** The Constant USERNAME_NOT_FOUND_MSG. */
	public static final String USERNAME_NOT_FOUND_MSG = "USERNAME_NOT_FOUND";

	/** The Constant USERNAME_NOT_FOUND_KEY. */
	public static final String USERNAME_NOT_FOUND_KEY = "UPC_004";

	/** The Constant USERNAME_ALREADY_EXITS_MSG. */
	public static final String USERNAME_ALREADY_EXITS_MSG = "USERNAME_ALREADY_EXITS";

	/** The Constant USERNAME_ALREADY_EXITS_KEY. */
	public static final String USERNAME_ALREADY_EXITS_KEY = "UPC_005";

	/** The Constant MANDATORY_PARAMS_MISSING_MSG. */
	public static final String MANDATORY_PARAMS_MISSING_MSG = "MANDATORY_PARAMS_MISSING";

	/** The Constant MANDATORY_PARAMS_MISSING_KEY. */
	public static final String MANDATORY_PARAMS_MISSING_KEY = "UPC_006";

	/** The Constant INVALID_INPUT_PARAM_MSG. */
	public static final String INVALID_INPUT_PARAM_MSG = "INVALID_INPUT_PARAM";

	/** The Constant INVALID_INPUT_PARAM_KEY. */
	public static final String INVALID_INPUT_PARAM_KEY = "UPC_007";

	/** The Constant INVALID_PROMOTION_CODE_MSG. */
	public static final String INVALID_PROMOTION_CODE_MSG = "INVALID_PROMOTION_CODE";

	/** The Constant INVALID_PROMOTION_CODE_KEY. */
	public static final String INVALID_PROMOTION_CODE_KEY = "UPC_008";

	/** The Constant INVALID_PROMOTION_ID_MSG. */
	public static final String INVALID_PROMOTION_ID_MSG = "INVALID_PROMOTION_ID";

	/** The Constant INVALID_PROMOTION_ID_KEY. */
	public static final String INVALID_PROMOTION_ID_KEY = "UPC_009";

	/** The Constant INVALID_CUSTOMER_ID_MSG. */
	public static final String INVALID_CUSTOMER_ID_MSG = "INVALID_CUSTOMER_ID";

	/** The Constant INVALID_CUSTOMER_ID_KEY. */
	public static final String INVALID_CUSTOMER_ID_KEY = "UPC_010";

	/** The Constant BRANDNAME_ALREADY_EXITS_MSG. */
	public static final String BRANDNAME_ALREADY_EXITS_MSG = "BRANDNAME_ALREADY_EXISTS";

	/** The Constant BRANDNAME_ALREADY_EXITS_KEY. */
	public static final String BRANDNAME_ALREADY_EXITS_KEY = "UPC_011";

	/** The Constant BRANDNAME_NOT_FOUND_MSG. */
	public static final String BRANDNAME_NOT_FOUND_MSG = "BRANDNAME_NOT_FOUND";

	/** The Constant BRANDNAME_NOT_FOUND_KEY. */
	public static final String BRANDNAME_NOT_FOUND_KEY = "UPC_012";

	/** The Constant PROMOTION_NOT_FOUND_MSG. */
	public static final String PROMOTION_NOT_FOUND_MSG = "PROMOTION_NAME_NOT_FOUND";

	/** The Constant PROMOTION_NOT_FOUND_KEY. */
	public static final String PROMOTION_NOT_FOUND_KEY = "UPC_013";

	/** The Constant PROMOTION_NAME_ALREADY_EXITS_MSG. */
	public static final String PROMOTION_NAME_ALREADY_EXITS_MSG = "PROMOTION_NAME_ALREADY_EXISTS";

	/** The Constant PROMOTION_NAME_ALREADY_EXITS_KEY. */
	public static final String PROMOTION_NAME_ALREADY_EXITS_KEY = "UPC_014";

	/** The Constant NO_CUSTOMER_REDEMPTION_MSG. */
	public static final String NO_CUSTOMER_REDEMPTION_MSG = "NO_CUSTOMER_REDEMPTION";

	/** The Constant NO_CUSTOMER_REDEMPTION_KEY. */
	public static final String NO_CUSTOMER_REDEMPTION_KEY = "UPC_015";

	/** The Constant PROMOTION_CODE_TABLE_NOT_CREATED_MSG. */
	public static final String PROMOTION_CODE_TABLE_NOT_CREATED_MSG = "PROMOTION_CODE_TABLE_NOT_CREATED";

	/** The Constant PROMOTION_CODE_TABLE_NOT_FOUND_KEY. */
	public static final String PROMOTION_CODE_TABLE_NOT_FOUND_KEY = "UPC_016";

	/** The Constant PACKCODESET_NAME_ALREADY_EXITS_MSG. */
	public static final String PACKCODESET_NAME_ALREADY_EXITS_MSG = "PACKCODESET_NAME_ALREADY_EXISTS";

	/** The Constant PACKCODESET_NAME_ALREADY_EXITS_KEY. */
	public static final String PACKCODESET_NAME_ALREADY_EXITS_KEY = "UPC_017";

	/** The Constant PACKCODESET_NAME_NOT_FOUND_MSG. */
	public static final String PACKCODESET_NAME_NOT_FOUND_MSG = "PACKCODESET_NAME_NOT_EXISTS";

	/** The Constant PACKCODESET_NAME_NOT_FOUND_KEY. */
	public static final String PACKCODESET_NAME_NOT_FOUND_KEY = "UPC_018";

	/** The Constant FILE_NOT_FOUND_MSG. */
	public static final String FILE_NOT_FOUND_MSG = "PACKCODESET_NAME_ALREADY_EXISTS";

	/** The Constant FILE_NOT_FOUND_KEY. */
	public static final String FILE_NOT_FOUND_KEY = "UPC_019";


	/** The Constant PROMOTION_NOT_PURGEBLE_MSG. */
	public static final String PROMOTION_NOT_PURGEBLE_MSG = "PROMOTION_NOT_PURGEBLE";

	/** The Constant PROMOTION_NOT_PURGEBLE_KEY. */
	public static final String PROMOTION_NOT_PURGEBLE_KEY = "UPC_020";


	// Success Message
	/** The Constant SUCCESS_MSG. */
	public static final String SUCCESS_MSG = "SUCCESS";

	/** The Constant SUCCESS_GENERATE_CODES. */
	public static final String SUCCESS_GENERATE_CODES = "Code Generation initiated successfully";

	/** The Constant SUCCESS_CREATE_PROMOTION. */
	public static final String SUCCESS_CREATE_PROMOTION = "A promotion created successfully";

	/** The Constant SUCCESS_CREATE_PACKCODESET. */
	public static final String SUCCESS_CREATE_PACKCODESET = "A pack code set created successfully";

	/** The Constant SUCCESS_CREATE_BRAND. */
	public static final String SUCCESS_CREATE_BRAND = "A Brand created successfully";

	/** The Constant SUCCESS_UPDATE_BRAND. */
	public static final String SUCCESS_UPDATE_BRAND = "A Brand updated successfully";

	/** The Constant SUCCESS_UPDATE_PROMOTION. */
	public static final String SUCCESS_UPDATE_PROMOTION = "A Promotion updated successfully";

	/** The Constant SUCCESS_UPDATE_PACKCODESET. */
	public static final String SUCCESS_UPDATE_PACKCODESET = "A pack code set updated successfully";

	/** The Constant SUCCESS_DELETE_PROMOTION. */
	public static final String SUCCESS_DELETE_PROMOTION = "A Promotion deleated successfully";

	/** The Constant SUCCESS_DELETE_BRAND. */
	public static final String SUCCESS_DELETE_BRAND = "A Brand deleted successfully";

	/** The Constant SUCCESS_DELETE_PACKCODESET. */
	public static final String SUCCESS_DELETE_PACKCODESET = "A pack code set deleted successfully";

	/** The Constant SUCCESS_PURGE_PROMOTION. */
	public static final String SUCCESS_PURGE_PROMOTION = "Promotion purged successfully";


	/**
	 * The Enum ErrorCode.
	 */
	public static enum ErrorCode
	{

		/** The system error. */
		SYSTEM_ERROR("UPC_001", "SYSTEM_ERROR"),

		/** The username password doesnt match error. */
		USERNAME_PASSWORD_DOESNT_MATCH_ERROR("UPC_002", "USERNAME_PASSWORD_DOESNT_MATCH"),

		/** The invalid role id error. */
		INVALID_ROLE_ID_ERROR("UPC_003", "INVALID_ROLE_ID"),

		/** The username not found error. */
		USERNAME_NOT_FOUND_ERROR("UPC_004", "USERNAME_NOT_FOUND"),

		/** The username already exists error. */
		USERNAME_ALREADY_EXISTS_ERROR("UPC_005", "USERNAME_ALREADY_EXISTS"),

		/** The mandatory params missing error. */
		MANDATORY_PARAMS_MISSING_ERROR("UPC_006", "MANDATORY_PARAMS_MISSING"),

		/** The invalid input param error. */
		INVALID_INPUT_PARAM_ERROR("UPC_007", "INVALID_INPUT_PARAM"),

		/** The invalid promotion code error. */
		INVALID_PROMOTION_CODE_ERROR("UPC_008", "INVALID_PROMOTION_CODE"),

		/** The invalid promotion id error. */
		INVALID_PROMOTION_ID_ERROR("UPC_009", "INVALID_PROMOTION_ID"),

		/** The invalid customer id error. */
		INVALID_CUSTOMER_ID_ERROR("UPC_010", "INVALID_CUSTOMER_ID"),

		/** The brandname already exists error. */
		BRANDNAME_ALREADY_EXISTS_ERROR("UPC_011", "BRANDNAME_ALREADY_EXISTS"),

		/** The brand not found error. */
		BRAND_NOT_FOUND_ERROR("UPC_012", "BRAND_NOT_FOUND"),

		/** The promotion not found error. */
		PROMOTION_NOT_FOUND_ERROR("UPC_013", "PROMOTION_NOT_FOUND"),

		/** The promotion name already exists error. */
		PROMOTION_NAME_ALREADY_EXISTS_ERROR("UPC_014", "PROMOTION_NAME_ALREADY_EXISTS"),

		/** The no customer redemption error. */
		NO_CUSTOMER_REDEMPTION_ERROR("UPC_015", "NO_CUSTOMER_REDEMPTION"),

		/** The promotion code table not created error. */
		PROMOTION_CODE_TABLE_NOT_CREATED_ERROR("UPC_016", "PROMOTION_CODE_TABLE_NOT_CREATED"),

		/** The packcodeset name already exists error. */
		PACKCODESET_NAME_ALREADY_EXISTS_ERROR("UPC_017", "PACKCODESET_NAME_ALREADY_EXISTS"),

		/** The packcodeset name not found msg. */
		PACKCODESET_NAME_NOT_FOUND_MSG("UPC_018", "PACKCODESET_NAME_NOT_EXISTS"),

		/** The file not found msg. */
		FILE_NOT_FOUND_MSG("UPC_019", "FILE_NOT_FOUND"),

		/** The promotion not purgeble key. */
		PROMOTION_NOT_PURGEBLE_KEY("UPC_20", "PROMOTION_NOT_PURGEBLE");

		/** The key. */
		private final String key;

		/** The message. */
		private final String message;

		/**
		 * Instantiates a new error code.
		 * 
		 * @param iKey
		 *           the i key
		 * @param iMessage
		 *           the i message
		 */
		ErrorCode(final String iKey, final String iMessage)
		{
			this.key = iKey;
			this.message = iMessage;

		}

		/**
		 * Gets the key.
		 * 
		 * @return the key
		 */
		public String getKey()
		{
			return key;
		}


		/**
		 * Gets the message.
		 * 
		 * @return the message
		 */
		public String getMessage()
		{
			return message;
		}


	}

}
