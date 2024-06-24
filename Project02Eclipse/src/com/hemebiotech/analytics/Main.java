package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * The program is about to count a list of symptom from a file line per line
 * That will order list of symptom in alphabetic order and write it in a file output
 */
public class Main {

	public static void main(String[] args) throws Exception  {
		String filepath =  "Project02Eclipse/symptoms.txt";
		String filename = "result.out";
		
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		ISymptomWriter writer = new WriteSymptomeDataToFile(filename);
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
				
		List<String> symptoms = analyticsCounter.getSymptoms();
		
		Map<String,Integer> orderSymptoms = analyticsCounter.countSymptoms(symptoms);
		
		orderSymptoms = analyticsCounter.sortSymptoms(orderSymptoms);
		
		analyticsCounter.writeSymptoms(orderSymptoms);
	}
}
