package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 */

public class AnalyticsCounter {
	
	private static ISymptomReader reader;
	private static ISymptomWriter writer;
	
	public static void main(String args[]) throws Exception {
		
		Main execute = new Main();
		execute.main();
		
	}
	
	/**
	 * @param reader
	 * @param writer
	 */
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		
		AnalyticsCounter.reader = reader;
		AnalyticsCounter.writer = writer;
		
	}
	
	public static class Main {
		
		/**
		 * 
		 */
		
		public void main(){
			
			String filepath =  "Project02Eclipse/symptoms.txt";
			String filename = "result.out";
			
			reader = new ReadSymptomDataFromFile(filepath);
			writer = new WriteSymptomeDataToFile(filename);
					
			List<String> symptoms = reader.GetSymptoms();
			
			Map<String,Integer> orderSymptoms = countSymptoms(symptoms);
			
			orderSymptoms = sortSymptoms(orderSymptoms);
			
			writeSymptoms(orderSymptoms);
			
		}
		
	}
	
	/**
	 * @param filename
	 * @return
	 */
	
	public static List<String> getSymptoms(){
		
		List<String> symptoms = reader.GetSymptoms();
		
		return symptoms;
		
	}
	
	/**
	 * @param filename
	 * @param symptoms
	 */
	
	public static void writeSymptoms(Map<String,Integer> symptoms) {
		
		
		writer.writeSymptoms(symptoms);
		
	}
	
	/**
	 * @param symptoms
	 * @return
	 */
	
	public static Map<String,Integer> countSymptoms(List<String> symptoms) {
		
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
	 * @param symptoms
	 * @return
	 */
	
	public static Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms) {
		
		Map<String,Integer> sortMap = new TreeMap<String,Integer>(symptoms);
		
		return sortMap;
		
	}
	
}
