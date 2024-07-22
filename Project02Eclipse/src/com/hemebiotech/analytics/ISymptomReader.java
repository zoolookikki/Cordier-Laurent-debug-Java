package Project02Eclipse.src.com.hemebiotech.analytics;

import java.util.List;
/**
 * Interface for reading symptom data from a source.
 * The main focus is on the return value, which is a list of strings that may contain many duplications.
 */
public interface ISymptomReader {
	/**
	 * Retrieves a list of symptoms from a data source.
	 * If no data is available, returns an empty list.
	 * @return a raw listing of all symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms ();
}
