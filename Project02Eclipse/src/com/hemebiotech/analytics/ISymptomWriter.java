package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Write the content of a order Map variable in a file output
 * The filename is define in the constructor of the class
 */
public interface ISymptomWriter {
	/**
	 * @param symptoms Map of all symptoms read from a file and counted
	 */
	public void WriteSymptoms(Map<String,Integer> symptoms);
}
