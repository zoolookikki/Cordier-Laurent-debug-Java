package com.hemebiotech.analytics;

public class Main {
	
	public static void main(String args[]) {
		
		try {
 			ReadSymptomDataFromFile sourceFile = new ReadSymptomDataFromFile ("symptoms.txt");
			WriteSymptomDataToFile destinationFile = new WriteSymptomDataToFile ("result.out") ;
			AnalyticsCounter analysis = new AnalyticsCounter (sourceFile, destinationFile);

			analysis.treatment () ;
			System.out.println ("treatment completed");
			
		} catch (Exception e) {
			// to catch any other internal or forgotten errors
			System.out.println("Unexpected error : " + e.getMessage());
			// for debugging if necessary
			//e.printStackTrace();
		}
		
	}

}
