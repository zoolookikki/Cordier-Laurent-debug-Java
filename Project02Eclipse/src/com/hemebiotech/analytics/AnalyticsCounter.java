package com.hemebiotech.analytics; 

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Count the number of occurrences for each symptom.
 * input : a file containing a list of symptom labels
 * output : a file containing for each symptom its occurrences for example "symptoms 1: 3" 
 * 
 */
public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer; 

	/**
     * reads a list of symptoms from a file then writes to a file the number of occurrences for each symptom.
	 * @param reader The file to read.
	 * @param writer The file to write.
	 */
	public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * count the occurrences of each symptom.
	 * @param symptoms Raw listing of all Symptoms, duplicates are possible/probable.
	 * @return A Map collection containing the name of the symptom and its occurrence. 
	 */
	public Map<String, Integer> countSymptoms(final List<String> symptoms) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		for(String symptom : symptoms) 
			result.put(symptom, result.getOrDefault(symptom, 0) + 1); // if quantity not exist or exist, we add 1.

		return result ;
	}

	/**
	 * sorts the list of symptoms and occurrences alphabetically.
	 * @param symptoms A Map collection containing the name of the symptom and its occurrence.
	 * @return A Map collection sorted list.
	 */
	/* test : à supprimer si TreeMap depuis le début */
 	public Map<String, Integer> sortSymptoms(final Map<String, Integer> symptoms) { 
 	
		// Convert to TreeMap to sort by key.
		TreeMap<String, Integer> result = new TreeMap<>(symptoms);		
		
		return result;
	}	

}

