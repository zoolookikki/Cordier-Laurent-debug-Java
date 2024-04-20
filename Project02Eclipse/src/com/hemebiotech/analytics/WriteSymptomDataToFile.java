package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    String filename;
    String str="";
    /**
     * 
     * @param filename name of output file
     */
    public WriteSymptomDataToFile(String filename){
        this.filename=filename;
    }
    @Override
    public void writeSymptoms(Map<String, Integer> MapData) {
        
        MapData.forEach((k,v)->{str+=k+" "+v+"found \n";});
        try{
            FileWriter writer = new FileWriter ("result.out");
			writer.write(str);
			writer.close();
        }catch(IOException e){
            System.out.println("writing "+filename+"failed");
        }
    }
}
