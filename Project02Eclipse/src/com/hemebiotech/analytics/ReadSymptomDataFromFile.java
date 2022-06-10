package com.hemebiotech.analytics;

import java.io.*;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public TreeMap<String, Integer> hashMapSymptoms() {
        TreeMap<String, Integer> mapSymptoms
                = new TreeMap<>();

        try {
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            int count = 1;
            while ((line != null)) {
                String symptoms = line;

                if (!mapSymptoms.containsKey(symptoms)) {
                    mapSymptoms.put(symptoms, count);
                } else {
                    Integer currentValue = mapSymptoms.get(symptoms);
                    mapSymptoms.replace(symptoms, ++currentValue);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapSymptoms;
    }

}
