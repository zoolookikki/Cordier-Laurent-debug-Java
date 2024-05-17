package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The WriteSymptomsDataToFile class implements the ISymptomWriter interface. It
 * provides functionality to write symptoms data to a file.
 */
public class WriteSymptomsDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * Constructor with a filepath parameter.
	 * 
	 * @param filepath The path of the file where the symptoms data will be written.
	 */
	public WriteSymptomsDataToFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Default constructor. Sets the filepath to "result.out".
	 */
	public WriteSymptomsDataToFile() {
		this.filepath = "result.out";
	}

	/**
	 * Writes the symptoms data to a file. Each line in the file represents a
	 * symptom and its count, separated by " : ".
	 * 
	 * @param symptoms A map where the key is the symptom name and the value is the
	 *                 count of occurrences.
	 */
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
