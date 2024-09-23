package com.hemebiotech.analytics; 

import java.util.Map;
import java.util.List;
import java.util.TreeMap;

/**
 * Count the number of occurrences for each symptom.
 * 
 * input : a file name containing a list of symptom labels.
 * output : a file name containing for each symptom its occurrences for example "symptoms 1: 3" 
 * 
 * @author Cordier Laurent
 * @version 1.1
 */
public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	private Map<String, Integer> result;

	/**
	 * Reads a list of symptoms from a file then writes to a file the number of occurrences for each symptom.
	 * 
	 * @param sourceFileName The file string to read.
	 * @param destinationFileName The file string to write.
	 */
	public AnalyticsCounter(final String sourceFileName, final String destinationFileName) {
		reader = new ReadSymptomDataFromFile(sourceFileName);
		writer = new WriteSymptomDataToFile(destinationFileName);
		result = new TreeMap<String, Integer>();
	}
	
	/**
	 * - get the list of symptoms.
	 * - counts the occurrences of each existing symptom.
	 * - writes the result to the output file.
	 */
	public void treatment() {
		List<String> symptoms;
		
		symptoms = reader.getSymptoms(); 
		for(String symptom : symptoms) 
			result.put(symptom, result.getOrDefault(symptom, 0) + 1); // if quantity not exist or exist, we add 1.
		writer.writeSymptoms(result);
	}

}

