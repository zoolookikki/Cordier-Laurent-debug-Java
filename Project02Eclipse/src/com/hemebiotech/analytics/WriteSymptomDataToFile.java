package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    String filename;
    static String res="";
    /**
     * 
     * @param filename name of output file
     */
    public WriteSymptomDataToFile(String filename){
        this.filename=filename;
    }
    @Override
    public void writeSymptoms(Map<String, Integer> MapData) {
        List<String> list=new LinkedList<>();
        MapData.forEach((k,v)->list.add(k));
        Collections.sort(list);
        list.stream().forEach(i->{res+= MapData.get(i) +" "+i+" found \n";});
        try{
            FileWriter writer = new FileWriter ("result.out");
			writer.write(res);
			writer.close();
        }catch(IOException e){
            System.out.println("writing "+filename+"failed");
        }
    }
}
