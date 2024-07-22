package Project02Eclipse.src.com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Implementation of the interface ISymptomReader that reads symptom data from a file.
 * Each symptom is expected to be on a new line in the file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private String filepath;
	/**
	 * Reads the symptom data from the specified file if the filepath is not null.
	 * It uses a BufferedReader to read the file line by line and adds each line to the result list.
	 * If an IOException occurs during reading, the stack trace is printed.
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @return a list of symptoms read from the file
	 */

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	@Override
	public List<String> getSymptoms() {
		// New ArrayList called result which is empty for now
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				//As long as they are symptoms to read, adds them to the ArrayList result. When done, reading task is closed.
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//When it's over and if no errors found, result contains the symptoms read.
		return result;
	}
}
