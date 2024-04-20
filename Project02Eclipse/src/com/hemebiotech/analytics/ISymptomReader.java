package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms();
	/**
	 * 
	 * @param symptoms List of symptoms
	 * @return Map containing each stmptom as key and it's count
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms);
	/**
	 * 
	 * @param symptoms Unordered map containing each stmptom as key and it's count
	 * @return ordered map containing each stmptom as key and it's count
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms);
}
