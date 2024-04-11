package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public Map<String,Integer> GetSymptoms() {
		Map<String,Integer> result = new HashMap<String,Integer>();
		
		if (filepath != null) {
			try {
				BufferedReader reader=new BufferedReader(new FileReader(filepath));
				while (reader.ready()) {
					String str=reader.readLine();
					result.put(str,(result.containsKey(str))?result.get(str)+1:1);
				}
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("inputfile not found");
			} catch ( IOException e){
				System.out.println("reading error chack if file is not corrupted and not used by others applications");
			}
		}
		return result;
	}

}
