package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class provides functionality to read, count, sort, and
 * write symptoms data.
 */
public class AnalyticsCounter {

	ISymptomReader reader;
	ISymptomWriter writer;
	Map<String, Integer> symptomsMap = new HashMap<String, Integer>();
	List<String> unsortedList = new ArrayList<String>();

	/**
	 * Constructor with a reader and writer parameters.
	 * 
	 * @param reader An object that implements the ISymptomReader interface.
	 * @param writer An object that implements the ISymptomWriter interface.
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Gets the symptoms from the reader.
	 * 
	 * @return A list of symptoms.
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom in a list.
	 * 
	 * @param symptoms A list of symptoms.
	 * @return A map where the key is the symptom name and the value is the count of
	 *         occurrences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	/**
	 * Sorts the symptoms by their names.
	 * 
	 * @param symptoms A map of symptoms and their counts.
	 * @return A sorted map where the key is the symptom name and the value is the
	 *         count of occurrences.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedListSymptoms = new TreeMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
			sortedListSymptoms.put(entry.getKey(), entry.getValue());
		}
		return sortedListSymptoms;
	}

	/**
	 * Writes the symptoms data to a specific destination using the writer.
	 * 
	 * @param symptoms A map where the key is the symptom name and the value is the
	 *                 count of occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
