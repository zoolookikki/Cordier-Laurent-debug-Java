package com.hemebiotech.analytics;

/**
 * AnalyticsCounter program.
 * 
 * @author Cordier Laurent
 * @version 1.1
 */
public class Main {
	
	/**
	 * Main entry point of the application/
	 * 
 	 * @param args The command line arguments passed to the program. 
	 *             <ul>
	 *               <li> source file name : Name of the file to analyze.</li>
	 *               <li> destination file name : Name of result file.</li>
	 *             </ul>	 
	 */
	public static void main(String args[]) {
		
		try {
			if (args.length == 2) {
				AnalyticsCounter analysis = new AnalyticsCounter(args[0], args[1]);
				analysis.treatment() ;
				System.out.println ("treatment completed");
			} else 
				System.out.println ("usage: <source file name> <destination file name>\n");
		} catch (Exception e) {
			// to catch any other internal or forgotten errors
			System.out.println("Unexpected error : " + e.getMessage());
			// for debugging if necessary
			//e.printStackTrace();
		}
		
	}

}
