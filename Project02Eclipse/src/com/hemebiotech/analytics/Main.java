package Project02Eclipse.src.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
/**
 * The Main class is the entry point of the symptom analytics application.
 * It reads symptoms from a file, counts the occurrences of each symptom,
 * and writes the results to another file.
 */
public class Main {
    /**
     * This application needs 2 files : One to read from and One to write into.
     * The path to these are given by the following Strings "SymptomFileToReadAccess" and "WriteSymptomFileAccess".
     */
    public static final String SymptomFileToReadAccess = "symptoms.txt";
    public static final String WriteSymptomFileAccess = "result.out";
    /**
     * The main method orchestrates the following process :
     * Reading symptoms from a source file.
     * Counting the occurrences of each symptom.
     * Creating a result file and writing the counted symptoms in it.
     */
    public static void main(String[] args) {
        // Using the constructor to read the file
        ReadSymptomDataFromFile listSymptoms = new ReadSymptomDataFromFile(SymptomFileToReadAccess);
        // Store the results of the getSymptoms function to access in the main method
        List<String> listSymptomsread = listSymptoms.getSymptoms();

        AnalyticsCounter countingOfSymptoms = new AnalyticsCounter();
        Map<String, Integer> symptomsCounted = countingOfSymptoms.countSymptoms(listSymptomsread);

        // Using the constructor to create the result.out file
        WriteSymptomDataToFile manageFile = new WriteSymptomDataToFile(WriteSymptomFileAccess);
        // Write to the file using the writeSymptoms method
        manageFile.writeSymptoms(symptomsCounted);
    }
}
