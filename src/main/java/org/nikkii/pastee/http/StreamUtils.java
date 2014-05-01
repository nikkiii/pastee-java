package org.nikkii.pastee.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Basic file/stream utilities
 * 
 * @author Nikki
 * 
 */
public class StreamUtils {

	/**
	 * Read all of the data from an InputStream into a string
	 * @param inputStream
	 * 			The stream to read from
	 * @return
	 * 			The data, lines separated by \n
	 * @throws IOException
	 * 			If a problem occurred while reading
	 */
	public static String readContents(InputStream inputStream)
			throws IOException {
		StringBuilder contents = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				contents.append(line).append("\n");
			}
		} finally {
			reader.close();
		}
		return contents.toString().trim();
	}
}