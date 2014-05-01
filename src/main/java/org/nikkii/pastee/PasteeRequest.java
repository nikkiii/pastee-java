package org.nikkii.pastee;

import org.nikkii.pastee.http.RequestData;

/**
 * Represents a Paste.ee API request
 * 
 * @author Nikki
 *
 */
public class PasteeRequest {
	/**
	 * The paste description
	 */
	private String description;
	
	/**
	 * The paste syntax highlighter
	 */
	private String language;
	
	/**
	 * The paste contents
	 */
	private String paste;
	
	/**
	 * Encrypted flag (disables syntax highlighting and uses prettyprint after the paste has been decrypted with a key)
	 */
	private boolean encrypted;
	
	/**
	 * The paste expiration time
	 */
	private int expire = 0;
	
	/**
	 * The paste view expiration
	 */
	private int expireViews;
	
	/**
	 * Get the paste syntax highlighter
	 * 
	 * @return The syntax highlighter
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Set the paste syntax highlighter
	 * 
	 * @param language The syntax highlighter
	 * @return The PasteeRequest instance, for chaining
	 */
	public PasteeRequest setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Get the paste contents
	 * 
	 * @return The paste contents
	 */
	public String getPaste() {
		return paste;
	}

	/**
	 * Set the paste contents
	 * 
	 * @param paste The paste contents
	 * @return The PasteeRequest instance, for chaining
	 */
	public PasteeRequest setPaste(String paste) {
		this.paste = paste;
		return this;
	}

	/**
	 * Check whether the paste's encrypted flag is set
	 * 
	 * @return The encrypted flag
	 */
	public boolean isEncrypted() {
		return encrypted;
	}

	/**
	 * Set the paste encrypted flag
	 * 
	 * @param encrypted Boolean for whether the paste is encrypted
	 * @return The PasteeRequest instance, for chaining
	 */
	public PasteeRequest setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
		return this;
	}

	/**
	 * Get the paste expiration time
	 * 
	 * @return The paste expiration time
	 */
	public int getExpire() {
		return expire;
	}

	/**
	 * Set the paste expiration time
	 * 
	 * @param expire The paste expiration time in minutes
	 * @return The PasteeRequest instance, for chaining
	 */
	public PasteeRequest setExpire(int expire) {
		this.expire = expire;
		return this;
	}
	
	/**
	 * Get the paste expiration views
	 * @return The expiration views
	 */
	public int getExpireViews() {
		return expireViews;
	}
	
	/**
	 * Set the paste expiration view count
	 * 
	 * @param expireViews The paste expiration view count
	 * @return The PasteeRequest instance, for chaining
	 */
	public PasteeRequest setExpireViews(int expireViews) {
		this.expireViews = expireViews;
		return this;
	}

	/**
	 * Get the paste description
	 * 
	 * @return The paste description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the paste description
	 * 
	 * @param description The paste description
	 * @return The PasteeRequest instance, for chaining
	 */
	public PasteeRequest setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Transform this PasteeRequest into a RequestData object
	 * 
	 * @return The request object
	 */
	public RequestData toRequestData() {
		RequestData data = new RequestData();
		data.put("paste", paste);
		
		if(description != null)
			data.put("description", description);
		
		if(language != null)
			data.put("language", language);
		
		if(encrypted)
			data.put("encrypted", "1");
		
		if(expire > 0)
			data.put("expire", expire);
		
		if(expireViews > 0)
			data.put("expire", "views;" + expireViews);
		
		return data;
	}
}
