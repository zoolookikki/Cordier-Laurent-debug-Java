package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a destination
 * Symptom data must be a Map collection.
 */
public interface ISymptomWriter {
	void WriteSymptoms(final Map<String, Integer> symptoms) ;
}
