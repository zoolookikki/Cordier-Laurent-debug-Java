package com.hemebiotech.analytics; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class AnalyticsCounter {

	private static void incrementSymptoms (final String symptom, Map<String, Integer> symptoms) {
		int quantity = 1 ;
		if(symptoms.containsKey(symptom)) 
			quantity = symptoms.get(symptom) + 1;
		symptoms.put(symptom, quantity);
	}

	public static void main(String args[]) {
		try {
			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			WriteSymptomDataToFile resultToFile = new WriteSymptomDataToFile ("result.out") ;
			Map<String, Integer> symptomsOccurrences = new HashMap<String, Integer>();
			String line;
			int cptLine = 0;
			
			while ((line = reader.readLine()) != null) {
				cptLine++ ;
				System.out.println("ligne " + cptLine + " : " + line);
				if (line.equals("headache"))
					incrementSymptoms ("headache", symptomsOccurrences) ;
				else if (line.equals("rash")) 
					incrementSymptoms ("rash", symptomsOccurrences) ;
				else if (line.contains("dialated pupils")) 
					incrementSymptoms ("dialated pupils", symptomsOccurrences) ;
			}
			reader.close () ;
			
			// generate output
			resultToFile.WriteSymptoms (symptomsOccurrences);
			System.out.println ("traitement terminé");
		
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier à lire est inexistant : " + e.getMessage ());
		} catch (IOException e) {
			System.out.println("Erreur de lecture du fichier : " + e.getMessage());
		// For the moment, i prefer to manage this type of internal error in the general case.              
		// } catch (IllegalArgumentException e) {
		//	System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Erreur inattendue : " + e.getMessage());
			// for debugging if necessary
			// e.printStackTrace();
		}
	}
	
}

