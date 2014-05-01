package org.nikkii.pastee;

import java.io.IOException;

import org.nikkii.pastee.http.HttpUtil;
import org.nikkii.pastee.http.RequestData;

import com.eclipsesource.json.JsonObject;

/**
 * The main class for the Paste.ee API
 * 
 * @author Nikki
 *
 */
public class Pastee {
	
	private static final String PASTE_URL = "//paste.ee";

	/**
	 * API Key
	 */
	private String apiKey;
	
	/**
	 * Secure HTTP flag
	 */
	private boolean secure = false;
	
	/**
	 * Construct a new anonymous pastebin object
	 */
	public Pastee() {
		this.apiKey = "public";
	}

	/**
	 * Construct a new pastebin object with an api key
	 * 
	 * @param apiKey Your Pastebin API key
	 */
	public Pastee(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Construct a new pastebin object with an api key and secure flag
	 * 
	 * @param apiKey Your Pastebin API key
	 */
	public Pastee(String apiKey, boolean secure) {
		this.apiKey = apiKey;
		this.secure = secure;
	}
	
	/**
	 * Get a paste from Paste.ee
	 * 
	 * @param id The paste id
	 * @return PasteePaste
	 * @throws IOException If an error occurred while contacting Paste.ee
	 */
	public String get(String id) throws IOException {
		return HttpUtil.executeGet(getWebsiteURL() + "/r/" + id);
	}
	
	/**
	 * Submit a simple paste and get the specified return value
	 * 
	 * @param request The paste contents to wrap
	 * @param ret The return type
	 * @return The return link/data
	 * @throws IOException If an error occurred while contacting the api
	 */
	public String simplePaste(String contents, PasteeReturn ret) throws IOException {
		return simplePaste(new PasteeRequest().setPaste(contents), ret);
	}
	
	/**
	 * Submit a simple paste and get the specified return value
	 * 
	 * @param request The PasteeRequest object to submit
	 * @param ret The return type
	 * @return The return link/data
	 * @throws IOException If an error occurred while contacting the api
	 */
	public String simplePaste(PasteeRequest request, PasteeReturn ret) throws IOException {
		RequestData req = request.toRequestData();
		req.put("key", apiKey)
		   .put("format", "simple")
		   .put("return", ret.name().toLowerCase());
		System.out.println(req.toPostString());
		return HttpUtil.executePost(getApiURL(), req);
	}
	
	/**
	 * Submit a simple contents-only paste
	 * 
	 * @param contents The paste contents
	 * @return The PasteeResult object
	 * @throws IOException If an error occurred contacting the api
	 */
	public PasteeResult paste(String contents) throws IOException {
		return paste(new PasteeRequest().setPaste(contents));
	}
	
	/**
	 * Submit a paste and get the full result
	 * 
	 * @param request The Paste Request
	 * @return The result
	 * @throws IOException If an error occurred contacting the api
	 */
	public PasteeResult paste(PasteeRequest request) throws IOException {
		RequestData req = request.toRequestData();
		req.put("key", apiKey);
		
		String jsonData = HttpUtil.executePost(getApiURL(), req);
		
		return parseResult(JsonObject.readFrom(jsonData));
	}
	
	/**
	 * Parse the JSON Response into a PasteeResult object
	 * 
	 * @param object The JSON Object to deserialize
	 * @return The parsed PasteeResult
	 */
	private PasteeResult parseResult(JsonObject object) {
		PasteeResult result = new PasteeResult();
		PasteeResultStatus status = object.get("status").asString().equals("success") ? PasteeResultStatus.SUCCESS : PasteeResultStatus.ERROR;
		result.setStatus(status);
		
		if (status == PasteeResultStatus.ERROR) {
			result.setErrorCode(object.get("errorcode").asInt());
			result.setErrorMessage(object.get("error").asString());
		} else {
			result.setPaste(new PasteePaste(object.get("paste").asObject()));
		}
		
		return result;
	}
	
	public void setSecure(boolean secure) {
		this.secure = secure;
	}
	
	public boolean isSecure() {
		return secure;
	}
	
	/**
	 * Get the API URL (accounting for https)
	 * @return The API URL
	 */
	private String getApiURL() {
		return getWebsiteURL() + "/api";
	}
	
	/**
	 * Get the Website URL (accounting for https)
	 * @return The website url
	 */
	private String getWebsiteURL() {
		return (secure ? "https:" : "http:") + PASTE_URL;
	}
}
