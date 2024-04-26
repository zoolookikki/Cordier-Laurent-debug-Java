package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Map;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms)  {
	
		

		try {
			FileWriter filesympt = new FileWriter ("results.out");
			BufferedWriter buffsympt = new BufferedWriter (filesympt);
			for (Entry<String, Integer> results : symptoms.entrySet()) {

				String key = results.getKey();
				Integer value = results.getValue();
				String line = key +"    :"+value +"\n";
				if ( results != null ) {

					buffsympt.write(key);
					buffsympt.write(value);
					buffsympt.write(line);
				}
				buffsympt.close();
			}

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}