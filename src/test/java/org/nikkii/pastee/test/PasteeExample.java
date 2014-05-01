package org.nikkii.pastee.test;

import java.io.IOException;

import org.nikkii.pastee.Pastee;
import org.nikkii.pastee.PasteePaste;
import org.nikkii.pastee.PasteeRequest;
import org.nikkii.pastee.PasteeResult;
import org.nikkii.pastee.PasteeReturn;

/**
 * An example of the Paste.ee Java API
 * 
 * @author Nikki
 *
 */
public class PasteeExample {

	public static void main(String[] args) throws Exception {
		// Change the api key if you wish
		Pastee pastee = new Pastee("public");
		
		try {
			// Submit a request with the paste "Hello!" and description "Meow"
			PasteeRequest request = new PasteeRequest();
			request.setPaste("Hello!")
				   .setDescription("Meow");
			String url = pastee.simplePaste(request, PasteeReturn.MIN);
			
			System.out.println("Minimal URL: " + url);
			
			// Submit the same request, but get the full response
			PasteeResult res = pastee.paste(request);
			
			if (res.isSuccess()) {
				PasteePaste paste = res.getPaste();
				System.out.println("ID: " + paste.getId() + "\nLink: " + paste.getNormalLink() + "\nRaw Link: " + paste.getRawLink() + "\nDownload Link: " + paste.getDownloadLink() + "\nMin Link: " + paste.getMinLink());
			} else {
				System.out.println("Error: " + res.getErrorMessage());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
