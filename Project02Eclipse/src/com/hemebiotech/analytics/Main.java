package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String filePathIn = "symptoms.txt";
		String filePathOut = "result.out";
				
		AnalyticsCounter analysis = new AnalyticsCounter(filePathIn, filePathOut);
		analysis.readFile();
		analysis.analyseData();
		analysis.writeFile();

	}

}
