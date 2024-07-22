package Project02Eclipse.src.com.hemebiotech.analytics;

import java.util.Map;
/**
 * The ISymptomWriter interface provides a method for writing symptom data to a destination.
 */

public interface ISymptomWriter {
   /**
    * Writes the given symptom data to a destination.
    * The symptom data is provided as a map where the key is the symptom and the value is the number of occurrences.
    * @param symptoms a map containing symptom names as keys and their occurrence counts as values
    */
   void writeSymptoms(Map<String, Integer> symptoms) ;
}