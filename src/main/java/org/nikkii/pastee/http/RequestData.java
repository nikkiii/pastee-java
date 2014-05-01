package org.nikkii.pastee.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple wrapper for a Map which contains Request data
 * 
 * @author Nikki
 * 
 */
public class RequestData {
	
	/**
	 * The data map used to store values
	 */
	private Map<String, Object> data = new HashMap<String, Object>();
	
	/**
	 * Set a key to a value
	 * @param key
	 * 			The key to set
	 * @param value
	 * 			The value to set
	 * @return
	 * 			The PostData instance for chaining
	 */
	public RequestData put(String key, Object value) {
		data.put(key, value);
		return this;
	}
	
	/**
	 * Get a value
	 * @param key
	 * 			The key to get the value for
	 * @return
	 * 			The value, or null if not found
	 */
	public Object get(String key) {
		return data.get(key);
	}
	
	/**
	 * Transform this data into a URLEncoded string
	 * @return
	 * 			The URL Encoded String
	 * @throws IOException
	 * 			If an encoding error occurs
	 */
	public String toPostString() throws IOException {
		return HttpUtil.implode(data);
	}
}