package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	static String res="";
	public static void main(String args[]) throws Exception {
		String filepath=args[0];
		ISymptomReader ir=new ReadSymptomDataFromFile(filepath);
		List<String> list=ir.getSymptoms();
		
		ISymptomWriter iw=new WriteSymptomDataToFile("result.out");
		iw.writeSymptoms(sortSymptoms(countSymptoms(list)));
	}
	/**
	 * 
	 * @param symptoms Unordered map containing each stmptom as key and it's count
	 * @return ordered map containing each stmptom as key and it's count
	 */
	public static Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String,Integer> result=new LinkedHashMap<String,Integer>();
		List<String> symptomsList=new LinkedList<>(symptoms.keySet());
		Collections.sort(symptomsList);
		for(int i=0;i<symptomsList.size();i++){
			String str=symptomsList.get(i);
			result.put(str,symptoms.get(str));
		}
		return result;
	}
	/**
	 * 
	 * @param symptoms List of symptoms
	 * @return Map containing each stmptom as key and it's count
	 */
	public static Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String,Integer> result=new HashMap<String,Integer>();
		symptoms.stream().forEach(i->{
			if(result.containsKey(i)){
				result.put(i,result.get(i)+1);
			}else{
				result.put(i,1);
			}
		});
		return result;
	}
}
