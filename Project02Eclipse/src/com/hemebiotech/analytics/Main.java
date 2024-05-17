package com.hemebiotech.analytics;

/**
 * The Main class is the entry point of the application. It reads symptoms from
 * a file, counts and sorts them, and then writes the results to another file.
 */
public class Main {

	/**
	 * The main method of the application.
	 * 
	 * @param args Command line arguments (not used in this application)
	 */
	public static void main(String[] args) {
		// Create a new symptom reader
		ISymptomReader reader = new ReadSymptomDataFromFile();
		// Create a new symptom writer
		ISymptomWriter writer = new WriteSymptomsDataToFile();
		// Create a new analytics counter with the reader and writer
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
		// Get the list of symptoms from the reader
		analyticsCounter.unsortedList = reader.getSymptoms();
		// Count the symptoms in the list
		analyticsCounter.symptomsMap = analyticsCounter.countSymptoms(analyticsCounter.unsortedList);
		// Sort the counted symptoms
		analyticsCounter.symptomsMap = analyticsCounter.sortSymptoms(analyticsCounter.symptomsMap);
		// Write the sorted symptoms to a file
		analyticsCounter.writer.writeSymptoms(analyticsCounter.symptomsMap);

	}

}
