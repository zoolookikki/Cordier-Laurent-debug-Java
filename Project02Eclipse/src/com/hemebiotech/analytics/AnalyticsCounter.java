package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class AnalyticsCounter {
	static String res="";
	public static void main(String args[]) throws Exception {
		String filepath=args[0];
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		LinkedList<String> tabout=new LinkedList<String>();
		if (filepath != null) {
			try {
				BufferedReader reader=new BufferedReader(new FileReader(filepath));
				while (reader.ready()) {
					String str=reader.readLine();
					if(!result.containsKey(str)){
						result.put(str, 1);
						tabout.add(str);
					}else
						result.put(str,result.get(str)+1);
				}
				reader.close();
				Collections.sort(tabout);
				tabout.stream().forEach(i->{res+= i +" "+i+" found \n";});
				FileWriter writer = new FileWriter ("result.out");
				writer.write(res);
				writer.close();
			} catch (FileNotFoundException e) {
				System.out.println("inputfile not found");
			} catch ( IOException e){
				System.out.println("reading error chack if file is not corrupted and not used by others applications");
			}
		}
		// next generate output
	}
}
