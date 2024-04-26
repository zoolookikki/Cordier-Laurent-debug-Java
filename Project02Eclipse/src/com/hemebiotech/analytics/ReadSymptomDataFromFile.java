package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
	public List<String> getSymptoms() {
		List<String> result = new LinkedList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader=new BufferedReader(new FileReader(filepath));
				while (reader.ready()) {
					String str=reader.readLine();
					result.add(str);
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
	
	

	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String,Integer> result=new LinkedHashMap<String,Integer>();
		List<String> symptomsList=new LinkedList<>(symptoms.keySet());
		Collections.sort(symptomsList);
		for(int i=0;i<symptomsList.size();i++){
			String str=symptomsList.get(i);
			result.put(str,symptoms.get(str));
		}
		return result;
	}

}
