package com.hemebiotech.analytics;

/**
 * AnalyticsCounter class test.
 * 
 * @author Cordier Laurent
 * @version 1.0
 */
public class Main {
	
	/**
	 * Main entry point of the application/
	 * 
	 * @param args The command line arguments passed to the program. Not used.
	 */
	public static void main(String args[]) {
		
		try {
 			ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile ("symptoms.txt");
			WriteSymptomDataToFile writer = new WriteSymptomDataToFile ("result.out") ;
			AnalyticsCounter analysis = new AnalyticsCounter (reader, writer);

			/*
			 * 4 steps :
			 * - get the list of symptoms.
			 * - counts the occurrences of each existing symptom.
			 * - sorts the list of symptoms and occurrences alphabetically.
			 * - writes the result to the output file.
			 */
			writer.writeSymptoms(analysis.sortSymptoms(analysis.countSymptoms(reader.getSymptoms())));
			
			System.out.println ("treatment completed");
			
		} catch (Exception e) {
			// to catch any other internal or forgotten errors
			System.out.println("Unexpected error : " + e.getMessage());
			// for debugging if necessary
			//e.printStackTrace();
		}
		
	}

}
