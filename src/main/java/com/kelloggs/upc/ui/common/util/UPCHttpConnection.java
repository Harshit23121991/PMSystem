/**
 * UPCHttpConnection.java
 */

package com.kelloggs.upc.ui.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;

import com.kelloggs.upc.ui.common.UPCApplication;
import com.kelloggs.upc.ui.common.UPCApplicationException;
import com.kelloggs.upc.ui.common.UPCConstants;

/**
 * The Class UPCHttpConnection.
 */
public class UPCHttpConnection {

	// =================================================
	// Class Variables
	// =================================================
	/** The Constant LOGGER. */
	static final Logger LOGGER = Logger.getLogger(UPCHttpConnection.class);

	/**
	 * The Enum REQUEST_TYPE.
	 */
	public static enum REQUEST_TYPE {
		GET, POST
	};

	// =================================================
	// Instance Variables
	// =================================================
	/** The url string. */
	private String urlString;
	
	/** The status code. */
	private int statusCode;
	
	/** The post body string. */
	private String postBodyString;
	
	/** The post body map. */
	private Map<String, String> postBodyMap;
	
	/** The response string. */
	private String responseString;
	
	/** The response bytes. */
	private byte[] responseBytes;

	// =================================================
	// Constructors
	// =================================================
	/**
	 * Instantiates a new uPC http connection.
	 *
	 * @param iURLString the i url string
	 * @param iPostBodyMap the i post body map
	 * @param iPostBodyString the i post body string
	 */
	public UPCHttpConnection(final String iURLString, final Map<String, String> iPostBodyMap, final String iPostBodyString) {
		urlString = iURLString;
		postBodyMap = iPostBodyMap;
		postBodyString = iPostBodyString;
	}

	// =================================================
	// Overridden Methods
	// =================================================
	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (postBodyMap != null) {
			String aValue = null;
			final Set<String> aKeys = postBodyMap.keySet();
			final StringBuilder aBuilder = new StringBuilder();
			for (String aKey : aKeys) {
				aValue = postBodyMap.get(aKey);
				aBuilder.append(aKey);
				aBuilder.append("=");
				aBuilder.append(aValue);
				aBuilder.append("&");
			}
			final int anIndex = aBuilder.lastIndexOf("&");
			aBuilder.deleteCharAt(anIndex);
			return urlString + "?" + aBuilder;
		}
		return urlString;
	}

	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================
	/**
	 * Used for invoking GET requests
	 * @throws UPCApplicationException 
	 */
	public void invokeGet() throws UPCApplicationException {
		final HttpParams aHttpParams = new BasicHttpParams();
		aHttpParams.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		aHttpParams.setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 30000);
		aHttpParams.setIntParameter(HttpConnectionParams.SO_TIMEOUT, 60000);
		final HttpClient aHttpClient = new DefaultHttpClient(aHttpParams);
		try {
			final HttpGet aHttpGet = new HttpGet(urlString);
			aHttpGet.addHeader("appid", UPCApplication.applicationConfig.getProperty("auth.appid"));
			aHttpGet.addHeader("key", UPCApplication.applicationConfig.getProperty("auth.key"));
			try {
				final HttpResponse aHTTPResponse = aHttpClient.execute(aHttpGet);
				statusCode = aHTTPResponse.getStatusLine().getStatusCode();
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(" Made a GET request for the URL " + urlString);
				}
				if (statusCode == HttpStatus.SC_OK && aHTTPResponse.getEntity() != null) {
					responseBytes = IOUtils.toByteArray(aHTTPResponse.getEntity().getContent());
					responseString = new String(responseBytes, "UTF8").trim();
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(" Response from GET has status " + statusCode + " and response is " + responseString);
					}
				} else {
					UPCApplicationException upcException = new UPCApplicationException();
					upcException.setErrorKey(UPCConstants.UPC_UI_BACKEND_SYSTEM_ERROR_KEY);
					throw upcException;
				}
			} catch (final ClientProtocolException aClientProtocolException) {
				LOGGER.error(" Exception occured while invoking GET ", aClientProtocolException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			} catch (final SocketTimeoutException aSocketTimeoutException) {
				LOGGER.error(" Request timed out while invoking GET ", aSocketTimeoutException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			} catch (final IOException anIOException) {
				LOGGER.error(" IO Exception occured while invoking GET ", anIOException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			}
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(" Response Recieved from the remote server is " + responseString);
			}
		} catch (final IllegalStateException anIllegalStateException) {
			LOGGER.error(" Illegal State Exception " + anIllegalStateException);
			UPCApplicationException upcException = new UPCApplicationException();
			upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
			throw upcException;
		} finally {
			aHttpClient.getConnectionManager().shutdown();
		}
	}

	/**
	 * Invoke get1.
	 *
	 * @throws UPCApplicationException the uPC application exception
	 */
	public void invokeGet1() throws UPCApplicationException {
		final HttpParams aHttpParams = new BasicHttpParams();
		aHttpParams.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		aHttpParams.setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 30000);
		aHttpParams.setIntParameter(HttpConnectionParams.SO_TIMEOUT, 60000);
		final HttpClient aHttpClient = new DefaultHttpClient(aHttpParams);
		try {
			final HttpGet aHttpGet = new HttpGet(urlString);
			aHttpGet.addHeader("appid", UPCApplication.applicationConfig.getProperty("auth.appid"));
			aHttpGet.addHeader("key", UPCApplication.applicationConfig.getProperty("auth.key"));
			try {
				final HttpResponse aHTTPResponse = aHttpClient.execute(aHttpGet);
				statusCode = aHTTPResponse.getStatusLine().getStatusCode();
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(" Made a GET request for the URL " + urlString);
				}
				if (statusCode == HttpStatus.SC_OK && aHTTPResponse.getEntity() != null) {
					aHTTPResponse.getAllHeaders();
					//aHTTPResponse.getHeaders("Content-Type")[0].getValue();
					/*if("application/xml;charset=ISO-8859-1".equalsIgnoreCase(aHTTPResponse.getFirstHeader("Content-Type").getValue())){
						String errorResponse =  new String(IOUtils.toByteArray(aHTTPResponse.getEntity().getContent()), "UTF8").trim();
						ExceptionDTO oexceptionDTO = CommonUtil.getExceptionDTO(errorResponse);
						UPCApplicationException usAppException = new UPCApplicationException();
						usAppException.setErrorCode(oexceptionDTO.getErrorCode());
						usAppException.setErrorKey(oexceptionDTO.getErrorKey());
						usAppException.setErrorMessage(oexceptionDTO.getErrorMessage());
						throw usAppException;
					}*/
					responseBytes = IOUtils.toByteArray(aHTTPResponse.getEntity().getContent());
					// responseString = new String(responseBytes, "UTF8").trim();
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(" Response from GET has status " + statusCode + " and response is " + responseString);
					}
				} else {
					UPCApplicationException upcException = new UPCApplicationException();
					upcException.setErrorKey(UPCConstants.UPC_UI_BACKEND_SYSTEM_ERROR_KEY);
					throw upcException;
				}
			} catch (final ClientProtocolException aClientProtocolException) {
				LOGGER.error(" Exception occured while invoking GET ", aClientProtocolException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			} catch (final SocketTimeoutException aSocketTimeoutException) {
				LOGGER.error(" Request timed out while invoking GET ", aSocketTimeoutException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			} catch (final IOException anIOException) {
				LOGGER.error(" IO Exception occured while invoking GET ", anIOException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			}
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(" Response Recieved from the remote server is " + responseString);
			}
		} catch (final IllegalStateException anIllegalStateException) {
			LOGGER.error(" Illegal State Exception " + anIllegalStateException);
			UPCApplicationException upcException = new UPCApplicationException();
			upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
			throw upcException;
		} finally {
			aHttpClient.getConnectionManager().shutdown();
		}
	}

	/**
	 * Used for invoking POST requests
	 * 
	 * @return
	 * @throws UPCApplicationException 
	 */
	public void invokePost() throws UPCApplicationException {
		final HttpParams aHttpParams = new BasicHttpParams();
		aHttpParams.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		aHttpParams.setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 30000);
		aHttpParams.setIntParameter(HttpConnectionParams.SO_TIMEOUT, 60000);
		final HttpClient aHttpClient = new DefaultHttpClient(aHttpParams);
		try {
			final HttpPost aHttpPost = new HttpPost(urlString);
			aHttpPost.addHeader("appid", UPCApplication.applicationConfig.getProperty("auth.appid"));
			aHttpPost.addHeader("key", UPCApplication.applicationConfig.getProperty("auth.key"));
			this.updatePostBodyParameters(aHttpPost);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(" About to make a POST request for the URL " + urlString + " and post body map as " + postBodyMap);
			}
			try {
				final HttpResponse aHTTPResponse = aHttpClient.execute(aHttpPost);
				statusCode = aHTTPResponse.getStatusLine().getStatusCode();
				if (statusCode == HttpStatus.SC_OK && aHTTPResponse.getEntity() != null) {
					responseBytes = IOUtils.toByteArray(aHTTPResponse.getEntity().getContent());
					responseString = new String(responseBytes, "UTF8").trim();
				} else {
					UPCApplicationException upcException = new UPCApplicationException();
					upcException.setErrorKey(UPCConstants.UPC_UI_BACKEND_SYSTEM_ERROR_KEY);
					throw upcException;
				}
			} catch (final ClientProtocolException aClientProtocolException) {
				LOGGER.error(" Exception occured while invoking POST ", aClientProtocolException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			} catch (final SocketTimeoutException aSocketTimeoutException) {
				LOGGER.error(" Request timed out while invoking GET ", aSocketTimeoutException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			} catch (final IOException anIOException) {
				LOGGER.error(" IO Exception occured while invoking POST ", anIOException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			}
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(" Response Recieved from the remote server is " + responseString);
			}
		} catch (final UPCApplicationException aUPCApplicationException) {
			throw aUPCApplicationException;
		}  catch (final IllegalStateException anIllegalStateException) {
			LOGGER.error(" Illegal State Exception " + anIllegalStateException);
			UPCApplicationException upcException = new UPCApplicationException();
			upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
			throw upcException;
		} finally {
			aHttpClient.getConnectionManager().shutdown();
		}
	}

	/**
	 * Returns true if 200 is returned
	 * 
	 * @return boolean
	 * @throws SBException
	 */
	public boolean didSucceed() {
		boolean didSucceed = false;
		if (this.statusCode == HttpStatus.SC_OK && StringUtils.isNotBlank(responseString)) {
			didSucceed = true;
		}
		return didSucceed;
	}

	// =================================================
	// Private Methods
	// =================================================
	/**
	 * @param iPostMethod
	 * @throws UPCApplicationException 
	 */
	private void updatePostBodyParameters(final HttpPost iHttpPost) throws UPCApplicationException {
		if (postBodyMap != null && !postBodyMap.isEmpty()) {
			final List<NameValuePair> aParamList = new ArrayList<NameValuePair>();
			for (final Map.Entry<String, String> anEntry : postBodyMap.entrySet()) {
				aParamList.add(new BasicNameValuePair(anEntry.getKey(), anEntry.getValue()));
			}
			try {
				iHttpPost.setEntity(new UrlEncodedFormEntity(aParamList, HTTP.UTF_8));
			} catch (final UnsupportedEncodingException anUnsupportedEncodingException) {
				LOGGER.debug(" UnsupportedEncodingException exception occured while updating post map : " + anUnsupportedEncodingException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			}
		}
		if (StringUtils.isNotEmpty(postBodyString)) {
			try {
				iHttpPost.setEntity(new StringEntity(postBodyString, HTTP.UTF_8));
			} catch (final UnsupportedEncodingException anUnsupportedEncodingException) {
				LOGGER.debug(" UnsupportedEncodingException exception occured while updating post body : " + anUnsupportedEncodingException);
				UPCApplicationException upcException = new UPCApplicationException();
				upcException.setErrorKey(UPCConstants.UPC_UI_SYSTEM_ERROR_KEY);
				throw upcException;
			}
		}
	}

	// =================================================
	// Accessors
	// =================================================
	/**
	 * Gets the response string.
	 *
	 * @return the response string
	 */
	public String getResponseString() {
		return this.responseString;
	}

	/**
	 * Sets the response string.
	 *
	 * @param iResponseString the new response string
	 */
	public void setResponseString(final String iResponseString) {
		this.responseString = iResponseString;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode() {
		return this.statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param iStatusCode the new status code
	 */
	public void setStatusCode(final int iStatusCode) {
		this.statusCode = iStatusCode;
	}

	/**
	 * Gets the response bytes.
	 *
	 * @return the response bytes
	 */
	public byte[] getResponseBytes() {
		return this.responseBytes;
	}

	/**
	 * Sets the response bytes.
	 *
	 * @param iResponseBytes the new response bytes
	 */
	public void setResponseBytes(final byte[] iResponseBytes) {
		this.responseBytes = iResponseBytes;
	}
}
