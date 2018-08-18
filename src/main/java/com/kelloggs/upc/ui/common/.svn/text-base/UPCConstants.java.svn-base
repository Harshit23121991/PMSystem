package com.kelloggs.upc.ui.common;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

/**
 * The Class UPCConstants.
 */
public class UPCConstants {

	/** The Constant EMPTY_STRING. */
	public static final String EMPTY_STRING = "".intern();
	
	
	public static final int BUFFER_SIZE =  10240; 

	public static final String DATE_PATTERN_DD_MM_YYYY = "dd-MM-yyyy";
	
	/** The Constant TIMEOUT_ERROR_CODE. */
	public static final String TIMEOUT_ERROR_CODE = "TIME_OUT";

	/** The Constant SYSTEM_ERROR. */
	public static final String SYSTEM_ERROR = "UPC_001";

	/** The Constant INVALID_CODE_ERROR. */
	public static final String INVALID_CODE_ERROR = "UPC_008";

	/** The Constant DUPLICATE_USER_ERROR. */
	public static final String DUPLICATE_USER_ERROR = "UPC_005";

	/** The Constant PROMOTION_NOT_FOUND. */
	public static final String PROMOTION_NOT_FOUND = "UPC_013";

	/** The Constant DUPLICATE_PROMOTION_NAME. */
	public static final String DUPLICATE_PROMOTION_NAME = "UPC_014";

	/** The Constant BATCH_TYPE_NORMAL. */
	public static final Short BATCH_TYPE_NORMAL = 1;

	/** The resource bundle. */
	protected static final ResourceBundle RESOURCE_BUNDLE =  FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "SignIn");

	/**
	 * The Enum GenerateCodeStatus.
	 */
	public static enum GenerateCodeStatus {
		
		/** The INITIATED. */
		INITIATED((short) 0, "CODE_GENERATION_INITIATED_MSG"), 
		
		/** The INPROGRESS. */
		INPROGRESS((short) 1, "CODE_GENERATION_INPROGRESS_MSG"), 
		
		/** The COMPLETE. */
		COMPLETE((short) 2, "CODE_GENERATION_COMPLETE_MSG"), 
		
		/** The FAILED. */
		FAILED((short) 3, "CODE_GENERATION_FAILED_MSG");
		
		/** The generate code status lookup. */
		public static final Map<Short, GenerateCodeStatus > GENERATE_CODE_STATUS_LOOKUP = new HashMap<Short, GenerateCodeStatus>();
		static {
			for (GenerateCodeStatus status :GenerateCodeStatus.values()) {
				GENERATE_CODE_STATUS_LOOKUP.put(status.getStatus(), status);
			}
		}
		
		/** The status. */
		private final short status;
		
		/** The msg key. */
		private final String msgKey;
		
		/**
		 * Instantiates a new generate code status.
		 *
		 * @param iStatus the i status
		 * @param iMsgKey the i msg key
		 */
		GenerateCodeStatus(final short iStatus, final String iMsgKey) {
			this.status = iStatus;
			this.msgKey = iMsgKey;
		}

		/**
		 * Gets the status.
		 *
		 * @return the status
		 */
		public short getStatus() {
			return status;
		}

		/**
		 * Gets the msg key.
		 *
		 * @return the msg key
		 */
		public String getMsgKey() {
			return msgKey;
		}
		
		
	}
	
	/**
	 * The Enum ServiceURL.
	 */
	public static enum ServiceURL {
		
		
		/** The BAS e_ url. */
		BASE_URL(UPCApplication.applicationConfig.getProperty("service.base.url")),
		
		/** The LOGI n_ service. */
		LOGIN_SERVICE(BASE_URL.getUrl() + "/user/login.xml"),
		
		/** The USE r_ role s_ service. */
		USER_ROLES_SERVICE(BASE_URL.getUrl() + "/user/roles.xml"),
		
		/** The COUNTRIE s_ service. */
		COUNTRIES_SERVICE(BASE_URL.getUrl() + "/country/all.xml"),
		
		/** The BRAND s_ service. */
		BRANDS_SERVICE(BASE_URL.getUrl() + "/brand/details.xml"),
		
		/** The PROMOTION s_ service. */
		PROMOTIONS_SERVICE(BASE_URL.getUrl() + "/promotion/details.xml"),
		
		/** The PAC k_ service. */
		PACK_SERVICE(BASE_URL.getUrl() + "/pack/details.xml"),
		
		/** The BATC h_ detail s__ service. */
		BATCH_DETAILS__SERVICE(BASE_URL.getUrl() + "/batch/details.xml"),
		
		/** The GENERAT e_ code s_ service. */
		GENERATE_CODES_SERVICE(BASE_URL.getUrl() + "/promotioncodes/generatecodes.xml"),
		
		/** The DOWNLOA d_ code s_ service. */
		DOWNLOAD_CODES_SERVICE(BASE_URL.getUrl() + "/promotioncodes/downloadcodes.xml"),
		
		/** The VALIDAT e_ cod e_ service. */
		VALIDATE_CODE_SERVICE(BASE_URL.getUrl() + "/promotioncodes/validate.xml"),
		
		/** The ALTERNAT e_ cod e_ service. */
		ALTERNATE_CODE_SERVICE(BASE_URL.getUrl() + "/promotioncodes/alternate.xml"),
		
		/** The REDEMPTIO n_ inf o__ service. */
		REDEMPTION_INFO__SERVICE(BASE_URL.getUrl() + "/user/redemption.xml"),
		
		/** The PACKCOD e_ repor t___ service. */
		PACKCODE_REPORT___SERVICE(BASE_URL.getUrl() + "/report/packcoderedemption.xml"),
		
		/** The MANAG e_ createorupdat e_ use r_ service. */
		MANAGE_CREATEORUPDATE_USER_SERVICE(BASE_URL.getUrl() + "/user/update.xml"),
		
		/** The MANAG e_ searc h_ use r_ service. */
		MANAGE_SEARCH_USER_SERVICE(BASE_URL.getUrl()  + "/user/search.xml"),
		
		/** The MANAG e_ createorupdat e_ bran d_ service. */
		MANAGE_CREATEORUPDATE_BRAND_SERVICE(BASE_URL.getUrl() + "/brand/update.xml"),
		
		/** The MANAG e_ searc h_ bran d_ service. */
		MANAGE_SEARCH_BRAND_SERVICE(BASE_URL.getUrl() + "/brand/search.xml"),
		
		/** The MANAG e_ delet e_ bran d_ service. */
		MANAGE_DELETE_BRAND_SERVICE(BASE_URL.getUrl() + "/brand/update.xml"),
		
		/** The MANAG e_ createorupdateordelet e_ promotio n_ service. */
		MANAGE_CREATEORUPDATEORDELETE_PROMOTION_SERVICE(BASE_URL.getUrl() + "/promotion/update.xml"),
		
		/** The MANAG e_ searc h_ promotio n_ service. */
		MANAGE_SEARCH_PROMOTION_SERVICE(BASE_URL.getUrl() + "/promotion/search.xml"),
		
		/** The MANAG e_ promotio n_ allproducttype s_ service. */
		MANAGE_PROMOTION_ALLPRODUCTTYPES_SERVICE(BASE_URL.getUrl() + "/productType/all.xml"),
		
		/** The MANAG e_ promotio n_ searchbran d_ service. */
		MANAGE_PROMOTION_SEARCHBRAND_SERVICE(BASE_URL.getUrl() + "/brand/details.xml"),
		
		/** The MANAG e_ brandslis t_ packcod e_ service. */
		MANAGE_BRANDSLIST_PACKCODE_SERVICE(BASE_URL.getUrl() + "/brand/detailsbypromotion.xml"),
		
		/** The MANAG e_ createorupdat e_ packcod e_ service. */
		MANAGE_CREATEORUPDATE_PACKCODE_SERVICE(BASE_URL.getUrl() + "/pack/update.xml"),
		
		/** The MANAG e_ delet e_ packcod e_ service. */
		MANAGE_DELETE_PACKCODE_SERVICE(BASE_URL.getUrl() + "/pack/update.xml"),
		
		/** The MANAG e_ searc h_ packcod e_ service. */
		MANAGE_SEARCH_PACKCODE_SERVICE(BASE_URL.getUrl() + "/pack/search.xml");
		
		
		/** The url. */
		private final String url;
		
		/**
		 * Instantiates a new service url.
		 *
		 * @param iUrl the i url
		 */
		ServiceURL(final String iUrl) {
			this.url = iUrl;
		}
		
		/**
		 * Gets the url.
		 *
		 * @return the url
		 */
		public String getUrl() {
			return url;
		}
		
			
	}

	
	/**
	 * The Enum UPCMessages.
	 */
	public static enum UPCMessages {
		
		/** The SUCCESSMS g_ cod e_ generation. */
		SUCCESSMSG_CODE_GENERATION(RESOURCE_BUNDLE.getString("CODE_SUCCESS_MESSAGE")),
		
		/** The WARNMS g_ redemptioninf o_ nodatafound. */
		WARNMSG_REDEMPTIONINFO_NODATAFOUND(RESOURCE_BUNDLE.getString("RI_NO_DATA_FOUND")),
		
		/** The MANAGEUSE r_ creat e_ success. */
		MANAGEUSER_CREATE_SUCCESS(RESOURCE_BUNDLE.getString("USER_CREATE_SUCCESS")),
		
		/** The MANAGEUSE r_ updat e_ success. */
		MANAGEUSER_UPDATE_SUCCESS(RESOURCE_BUNDLE.getString("USER_UPDATE_SUCCESS")),
		
		/** The MANAGEBRAN d_ creat e_ success. */
		MANAGEBRAND_CREATE_SUCCESS(RESOURCE_BUNDLE.getString("BRAND_CREATE_MESSAGE")),
		
		/** The MANAGEBRAN d_ updat e_ success. */
		MANAGEBRAND_UPDATE_SUCCESS(RESOURCE_BUNDLE.getString("BRAND_UPDATE_MESSAGE")),
		
		/** The MANAGEBRAN d_ delet e_ success. */
		MANAGEBRAND_DELETE_SUCCESS(RESOURCE_BUNDLE.getString("BRAND_DELETE_MESSAGE")),
		
		/** The MANAGEPROMOTIO n_ creat e_ success. */
		MANAGEPROMOTION_CREATE_SUCCESS(RESOURCE_BUNDLE.getString("PROMOTION_CREATE_SUCCESS")),
		
		/** The MANAGEPROMOTIO n_ updat e_ success. */
		MANAGEPROMOTION_UPDATE_SUCCESS(RESOURCE_BUNDLE.getString("PROMOTION_UPDATE_SUCCESS")),
		
		/** The MANAGEPROMOTIO n_ delet e_ success. */
		MANAGEPROMOTION_DELETE_SUCCESS(RESOURCE_BUNDLE.getString("PROMOTION_DELETE_SUCCESS")),
		
		/** The MANAGEPACKCOD e_ creat e_ success. */
		MANAGEPACKCODE_CREATE_SUCCESS(RESOURCE_BUNDLE.getString("PACKCODE_CREATE_MESSAGE")),
		
		/** The MANAGEPACKCOD e_ updat e_ success. */
		MANAGEPACKCODE_UPDATE_SUCCESS(RESOURCE_BUNDLE.getString("PACKCODE_UPDATE_MESSAGE")),
		
		/** The MANAGEPACKCOD e_ delet e_ success. */
		MANAGEPACKCODE_DELETE_SUCCESS(RESOURCE_BUNDLE.getString("PACK_DELETE_MESSAGE"));
		
		
		/** The msg. */
		private final String msg;
		
		/**
		 * Instantiates a new uPC messages.
		 *
		 * @param imsg the imsg
		 */
		UPCMessages(final String imsg) {
			this.msg = imsg;
		}

		/**
		 * Gets the msg.
		 *
		 * @return the msg
		 */
		public String getMsg() {
			return msg;
		}
		
		
	}

	
	
	public static enum UPCRequestParam{
		
		
		//Common request params
		COUNTRY_ID("country_id"),
		BRAND_ID("brand_id"),
		PROMOTION_ID("promotion_id"),
		PACK_CODE_SET_ID("pack_code_set_id"),
		BATCH_ID("batch_id"),
		
		
		//Promotion related request params.
		PROMOTION_NAME("promotion_name"),
		PROMOTION_CODE("promotion_code"),
		IS_PURGE_REQD("is_purging_reqd"),
		PURGE_DAYS("purge_days"),
		PRODUCT_TYPE_ID("product_type_id"),
		USER_ID("user_id"),
		
		
		//Brand related request params.
		BRAND_NAME("brand_name"),
		BRAND_CODE("brand_code"),
		IS_ACTIVE("is_active"),
		
		//Pack Code Set related request params.
		PACK_CODE_SET_NAME("pack_code_set_name"),
		PRODUCT_ID("product_id"),
		NO_OF_CODES("no_of_codes"),
	    START_DATE("start_date"),
		END_DATE("end_date"),
		
		
		CUSTOMER_ID("customer_id"),
		FROM_DATE("from_date"),
		TO_DATE("to_date"),
	    
		LOGIN_ID("login_id"),
		USER_NAME("user_id"),
		PASSWORD("password"),
		ROLE_ID("role_id"),
		IS_ENABLED("is_enabled"),
		IS_CREATE("is_create");
		
		
		
		private final String string;
		
		UPCRequestParam(final String string ){
			
			this.string = string;
		}

		public String getString() {
			return string;
		}

		
	}
	
	
	/** The Constant UPC_UI_SYSTEM_ERROR_KEY. */
	public static final String UPC_UI_SYSTEM_ERROR_KEY = "UPC_UI_001";

	/** The Constant UPC_UI_BACKEND_SYSTEM_ERROR_KEY. */
	public static final String UPC_UI_BACKEND_SYSTEM_ERROR_KEY = "UPC_UI_002";

}
