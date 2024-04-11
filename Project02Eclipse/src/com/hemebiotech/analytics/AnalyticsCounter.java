package com.hemebiotech.analytics;

public class AnalyticsCounter {
	static String res="";
	public static void main(String args[]) throws Exception {
		String filepath=args[0];
		ISymptomReader ir=new ReadSymptomDataFromFile(filepath);
		ISymptomWriter iw=new WriteSymptomDataToFile("result.out");
		iw.writeSymptoms(ir.GetSymptoms());
	}
}
