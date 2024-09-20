package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a destination.
 * Symptom data must be a Map collection.
 * 
 * @author Cordier Laurent
 * @version 1.0
 */
public interface ISymptomWriter {
	/**
	 * Write symptom data to a destination.
	 * 
	 * @param symptoms A Map collection containing the name of the symptom and its occurrence.
	 */
	void writeSymptoms(final Map<String, Integer> symptoms) ;
}
