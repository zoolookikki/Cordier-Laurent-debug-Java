package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomsDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public WriteSymptomsDataToFile(String filepath) {
		this.filepath = filepath;
	}

	public WriteSymptomsDataToFile() {
		this.filepath = "result.out";
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		if (filepath != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, false));
				for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
					writer.write(entry.getKey() + " : " + entry.getValue());
					writer.newLine();
				}
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
