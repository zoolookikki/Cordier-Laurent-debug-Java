package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;

public class  WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath = null;
	
	/**
	 * each line of the file is composed of a symptom name and its occurrence.
	 * @param filepath a full or partial path to file.
	 */
	public WriteSymptomDataToFile (final String filepath) {
		if (filepath == null)
			throw new IllegalArgumentException("Incorrect result file name");
		this.filepath = filepath;
	}
	
	@Override
	public void WriteSymptoms(final Map<String, Integer> symptoms) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter (filepath));
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write (entry.getKey() + ": " + entry.getValue() + "\n");				
			}			
			writer.close();
 		} catch (FileNotFoundException e) {
			System.out.println("Unable to write result : " + e.getMessage ());
		} catch (IOException e) {
			System.out.println("File write error : " + e.getMessage());
		}
	}

}
