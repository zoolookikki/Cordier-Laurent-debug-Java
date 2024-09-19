package com.hemebiotech.analytics;

public class Main {
	
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
			writer.WriteSymptoms(analysis.sortSymptoms(analysis.countSymptoms(reader.GetSymptoms())));
			
			System.out.println ("treatment completed");
			
		} catch (Exception e) {
			// to catch any other internal or forgotten errors
			System.out.println("Unexpected error : " + e.getMessage());
			// for debugging if necessary
			//e.printStackTrace();
		}
		
	}

}
