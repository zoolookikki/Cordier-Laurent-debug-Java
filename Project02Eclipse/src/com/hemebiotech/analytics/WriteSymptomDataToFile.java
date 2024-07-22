package Project02Eclipse.src.com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.File;
/**
 * The WriteSymptomDataToFile class implements the ISymptomWriter interface
 * to write symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    public File file;

    /**
     * Constructs a WriteSymptomDataToFile object that will write to the specified file.
     * If the file does not exist, it will be created.
     * If the file exist, it will be updated.
     * @param filepath the path to the file where symptom data will be written
     */
    public WriteSymptomDataToFile(String filepath) {
        this.file = this.createFile(filepath);
    }
    /**
     * Creates a file at the specified filepath.
     * If the file already exists, it prints a message indicating so.
     *
     * @param filepath the path to the file to be created
     * @return the created File object, or null if an error occurs
     */
    public File createFile(String filepath) {
        try {
            File myFile = new File(filepath);
            if (myFile.createNewFile()) {
                System.out.println("Fichier créé");
            } else {
                System.out.println("Fichier déjà existant");
            }
            return myFile;
            //In case of an error in the try block, catch the exception, print the error message, and return a null File instance
        } catch (IOException e) {
            System.err.println("Une erreur est survenue : " + e);
        }
        return null;
    }
    /**
     * Writes the symptom data to the file.
     * The symptom data is provided as a map where the key is the symptom and the value is the number of occurrences.
     *
     * @param symptoms a map containing symptom names as keys and their occurrence counts as values
     */

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.file));
            // Loop to retrieve entries from the map
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String symptom = entry.getKey();
                Integer occurence = entry.getValue();
                // Write to the file and move to the next line for each new entry
                bufferedWriter.write(symptom + " = " + occurence);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Une erreur est survenue : " + e);
        }
    }
}
