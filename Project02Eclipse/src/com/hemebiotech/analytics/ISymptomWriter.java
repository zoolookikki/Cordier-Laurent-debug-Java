package com.hemebiotech.analytics;

import java.util.Map;
/**
 * interface representing any method that write Map data in new given filename
 * 
 */
public interface ISymptomWriter {
    /**
     * sort MapData in alphabetical order and write it in text file
     * @param MapData
     */
    void writeSymptoms(Map<String,Integer> MapData);
}
