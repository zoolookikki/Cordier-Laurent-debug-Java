package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;

public class  WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	public WriteSymptomDataToFile (final String filepath) {
		if (filepath == null)
			throw new IllegalArgumentException("Nom du fichier résultat incorrect");
		this.filepath = filepath;
	}
	
	@Override
	public void WriteSymptoms(final Map<String, Integer> symptoms) {
		try {
			FileWriter writer = new FileWriter (filepath);
			// compile nok, see later.
			//	symptoms.forEach((symptom, quantity) -> writer.write (symptom + ": " + quantity + "\n"));
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write (entry.getKey() + ": " + entry.getValue() + "\n");				
			}			
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Impossible d'écrire le résultat : " + e.getMessage ());
		} catch (IOException e) {
			System.out.println("Erreur d'écriture du fichier : " + e.getMessage());
		}
	}

}
