package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * 
 */

public class WriteSymptomeDataToFile implements ISymptomWriter {

	private String filename;
	
	/**
	 * @param filename, the name of the written file with symptoms
	 */
	public WriteSymptomeDataToFile(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void WriteSymptoms(Map<String, Integer> symptoms) {
		if (filename != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename,false));
				
				for(var entry : symptoms.entrySet()) {
					writer.write(entry.getKey() + " = " + entry.getValue());
					writer.newLine();
				}
				
				writer.close();
				System.out.println("Le fichier est bien éditer.");
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}