package com.hemebiotech.analytics; 

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer; 

	/**
     * reads a list of symptoms from a file then writes to a file the number of occurrences for each symptom.
	 * @param the file to read, the file to write.
	 */
	public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * count the occurrences of each symptom.
	 * @param raw listing of all Symptoms, duplicates are possible/probable.
	 * @return a Map collection containing the name of the symptom and its occurrence. 
	 */
	public Map<String, Integer> countSymptoms(final List<String> symptoms) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		for(String symptom : symptoms) 
			result.put(symptom, result.getOrDefault(symptom, 0) + 1); // if quantity not exist or exist, we add 1.

		return result ;
	}

	/**
	 * sorts the list of symptoms and occurrences alphabetically.
	 * @param a Map collection containing the name of the symptom and its occurrence.
	 * @return a Map collection sorted list.
	 */
 	public Map<String, Integer> sortSymptoms(final Map<String, Integer> symptoms) { 
 	
		// Convert to TreeMap to sort by key.
		TreeMap<String, Integer> result = new TreeMap<>(symptoms);		
		
		return result;
	}	
	

	/**
	 * processing to be launched for analysis.
	 */
	public void treatment () {
		List<String> symptoms = reader.GetSymptoms();
		Map<String, Integer> symptoms_occurences = countSymptoms (symptoms);
		symptoms_occurences = sortSymptoms (symptoms_occurences);
		// generate output
		writer.WriteSymptoms(symptoms_occurences);
	}
}

