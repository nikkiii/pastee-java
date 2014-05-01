package org.nikkii.pastee;

/**
 * A class representing a Paste.ee API response
 * 
 * @author Nikki
 *
 */
public class PasteeResult {
	/**
	 * The result status
	 */
	private PasteeResultStatus status;
	
	/**
	 * The paste error code
	 */
	private int errorCode;
	
	/**
	 * The paste error message
	 */
	private String errorMessage;
	
	/**
	 * The paste object, if successful
	 */
	private PasteePaste paste;
	
	/**
	 * Empty constructor just as a placeholder
	 */
	public PasteeResult() {
		
	}

	/**
	 * Get the result status
	 * 
	 * @return The paste result status
	 */
	public PasteeResultStatus getStatus() {
		return status;
	}

	/**
	 * Set the result status
	 * 
	 * @param status The result status
	 */
	public void setStatus(PasteeResultStatus status) {
		this.status = status;
	}

	/**
	 * Get the paste error code
	 * 
	 * @return The error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Set the paste error code
	 * 
	 * @param errorCode The error code
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Get the paste error message
	 * 
	 * @return The error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Set the paste error message
	 * 
	 * @param errorMessage The error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Get the paste if the request was successful
	 * 
	 * @return The paste object
	 */
	public PasteePaste getPaste() {
		return paste;
	}

	/**
	 * Set the paste object
	 * 
	 * @param paste The paste object
	 */
	public void setPaste(PasteePaste paste) {
		this.paste = paste;
	}

	/**
	 * Check whether this request was successful
	 * 
	 * @return True, if the status is SUCCESS
	 */
	public boolean isSuccess() {
		return status == PasteeResultStatus.SUCCESS;
	}
}
