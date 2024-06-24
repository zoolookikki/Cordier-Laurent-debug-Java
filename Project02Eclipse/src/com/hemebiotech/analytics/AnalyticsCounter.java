package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private static ISymptomReader reader;
	private static ISymptomWriter writer;
	
	/**
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		AnalyticsCounter.reader = reader;
		AnalyticsCounter.writer = writer;
	}
	/**
	 * Call the method GetSymptoms from reader attribute 
	 * @return a List variable of the symptoms
	 */
	public List<String> getSymptoms(){
		List<String> symptoms = reader.GetSymptoms();
		
		return symptoms;
	}
	/**
	 * @param symptoms a Map variable with the count of symptoms
	 * Call the method WriteSymptoms from writer attribute 
	 */
	public void writeSymptoms(Map<String,Integer> symptoms) {
		writer.WriteSymptoms(symptoms);
	}
	/**
	 * @param symptoms a List variable with all the symptoms
	 * 
	 * Add a symptom in a Map variable from a List variable which content all symptoms
	 * If the symptom already exist, add +1 at the value else add the symptom with 1 for starting value
	 * 
	 * @return a Map variable with all the symptoms counted
	 */
	public Map<String,Integer> countSymptoms(List<String> symptoms) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for (String symptom : symptoms) {
			if(symptom != null) {
				if(!map.containsKey(symptom)) {
					map.put(symptom, 1);
				} else {
					map.put(symptom, map.get(symptom) + 1);
				}
			}
		}
		return map;
	}
	/**
	 * @param symptoms Map of all symptoms counted
	 * @return a Map variable with symptoms in alphabetic order
	 */
	public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms) {
		Map<String,Integer> sortMap = new TreeMap<String,Integer>(symptoms);
		
		return sortMap;
	}
}
