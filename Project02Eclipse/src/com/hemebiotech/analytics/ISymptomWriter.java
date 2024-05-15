package com.hemebiotech.analytics;

import java.util.Map;

/**
 * The ISymptomWriter interface provides a contract for writing symptoms data.
 * Classes implementing this interface should provide their own implementation
 * of the writeSymptoms method.
 */
public interface ISymptomWriter {

	/**
	 * Writes the symptoms data to a specific destination.
	 * 
	 * @param symptoms A map where the key is the symptom name and the value is the
	 *                 count of occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);

}
