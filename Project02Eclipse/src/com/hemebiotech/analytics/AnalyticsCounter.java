package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter  {


	public ISymptomWriter writer;
	public ISymptomReader reader;

	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {

		this.reader = new ReadSymptomDataFromFile("symptoms.txt");
		this.writer = new WriteSymptomDataToFile();

	}

	public List<String>GetSymptoms() {

		List <String>result= reader.GetSymptoms();
		System.out.println(result);
		return result;

	}
	public Map <String, Integer> countSymptoms (List<String> symptoms) {

		Map<String, Integer> countsympt =  new HashMap<String, Integer>();

		for (String symptom :symptoms) {

			if(countsympt.containsKey(symptom)) {

				countsympt.put(symptom, countsympt.get(symptom) + 1);

			}else {
				countsympt.put(symptom,1);
			}
		}

		return countsympt;

	}

	public Map<String, Integer> sortSymptoms (Map<String,Integer> symptoms) {

		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		for (Map.Entry<String, Integer> mp :sortedSymptoms.entrySet()) {
			sortedSymptoms.get(mp.getKey());
			sortedSymptoms.get(mp.getValue());

		}
		return sortedSymptoms;
	}
	public void writeSymptoms (Map<String, Integer> symptoms) {	
		writer.writeSymptoms(symptoms);
	}
}






