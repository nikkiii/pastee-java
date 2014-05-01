package org.nikkii.pastee;

import com.eclipsesource.json.JsonObject;

/**
 * Represents a Paste.ee paste response
 * 
 * @author Nikki
 *
 */
public class PasteePaste {
	
	/**
	 * The paste id/key
	 */
	private String id;
	
	/**
	 * The normal paste viewing link
	 */
	private String normalLink;
	
	/**
	 * The raw paste link
	 */
	private String rawLink;
	
	/**
	 * The paste download link
	 */
	private String downloadLink;
	
	/**
	 * The Paste.ee Minimal viewing link
	 */
	private String minLink;

	/**
	 * Construct a new Paste object from the JSON response
	 * 
	 * @param object The JSON Object to parse from
	 */
	public PasteePaste(JsonObject object) {
		this.id = object.get("id").asString();
		this.normalLink = object.get("link").asString();
		this.rawLink = object.get("raw").asString();
		this.downloadLink = object.get("download").asString();
		this.minLink = object.get("min").asString();
	}

	/**
	 * Get the paste id
	 * Example: AbCd1
	 * 
	 * @return The unique paste id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Get the paste viewing link
	 * Example: http://paste.ee/p/AbCd1
	 * 
	 * @return The paste viewing link
	 */
	public String getNormalLink() {
		return normalLink;
	}

	/**
	 * Get the paste raw link
	 * Example: http://paste.ee/r/AbCd1
	 * 
	 * @return The paste raw link
	 */
	public String getRawLink() {
		return rawLink;
	}

	/**
	 * Get the paste download link
	 * Example: http://paste.ee/d/AbCd1
	 * 
	 * @return The paste download link
	 */
	public String getDownloadLink() {
		return downloadLink;
	}
	
	/**
	 * Get the minimal website paste link
	 * Example: http://min.paste.ee/AbCd1
	 * 
	 * @return The minimal paste link
	 */
	public String getMinLink() {
		return minLink;
	}
	
}
