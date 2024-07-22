package Project02Eclipse.src.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * The AnalyticsCounter class provides methods to count occurrences of symptoms.
 */
public class AnalyticsCounter {
	/**
	 * Counts the occurrences of each symptom in the given list.
	 * Uses a TreeMap to store the symptom as the key and its occurrence count as the value in alphabetical order.
	 * @param symptomsToCount a list of symptoms to be counted
	 * @return a map where the key is the symptom and the value is the number of occurrences of that symptom
	 */
public Map<String, Integer> countSymptoms (List<String> symptomsToCount){
	Map<String, Integer> symptomsDictionnary = new TreeMap<>();
	// Loop through each symptom in the list symptomsToCount
	for (String symptom : symptomsToCount){
		Integer count = symptomsDictionnary.get(symptom);
		// If the symptom already exists in the dictionary, increment its count by 1
		if (count != null) {
			symptomsDictionnary.put(symptom, count+1);
		}
		// Otherwise, add the symptom to the dictionary with a count of 1
		else {
			symptomsDictionnary.put(symptom, 1);
		}
	}
	// Once the loop is finished, return the updated dictionary
	return symptomsDictionnary;
}
}
