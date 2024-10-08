package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Anything that will read symptom data from a source.
 * 
 * @author Cordier Laurent
 * @version 1.0
 * 
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath = null;
	
	/**
	 * Each line of the file is composed of a character string which is the name of a symptom.
	 * 
	 * @param filepath a full or partial path to file.
	 * @throws IllegalArgumentException if filepath is null
	 */
	public ReadSymptomDataFromFile (String filepath) {
		if (filepath == null)
			throw new IllegalArgumentException("Incorrect source file name");
		this.filepath = filepath;
	}
	
	/**
	 * Implementation of the method to obtain a list of all symptoms.
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
	
		try {
			BufferedReader reader = new BufferedReader (new FileReader(filepath));
			String line;
			int cptLine = 0;
			
			while ((line = reader.readLine()) != null) {
				cptLine++ ;
				System.out.println("line " + cptLine + " : " + line);
				result.add(line);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Unable to read source file : " + e.getMessage ());
		} catch (IOException e) {
			System.out.println("Error reading file : " + e.getMessage());
		}
		
		return result;
	}
	
}
