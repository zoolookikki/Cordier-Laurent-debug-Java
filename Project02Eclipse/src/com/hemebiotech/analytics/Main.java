package com.hemebiotech.analytics;

public class Main {

	public static void main(String[] args) {
		ISymptomReader reader = new ReadSymptomDataFromFile();
		ISymptomWriter writer = new WriteSymptomsDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		analyticsCounter.unsortedList = reader.getSymptoms();
		analyticsCounter.symptomsMap = analyticsCounter.countSymptoms(analyticsCounter.unsortedList);
		analyticsCounter.symptomsMap = analyticsCounter.sortSymptoms(analyticsCounter.symptomsMap);
		analyticsCounter.writer.writeSymptoms(analyticsCounter.symptomsMap);

	}

}
