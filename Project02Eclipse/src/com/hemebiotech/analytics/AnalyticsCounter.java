package Project02Eclipse.src.com.hemebiotech.analytics;

import java.io.*;

/* Ouverture de la classe primaire Analytics Counter */
public class AnalyticsCounter {

	/* Déclaration des variables de décompte des symptômes*/

	static int headacheCount = 0;
	static int rashCount = 0;
	static int pupilCount = 0;
	static int otherSymptomFound = 0;

    /* Ouverture de la fonction main*/
	public static void main(String args[])  {

		/*Fonction de lecture du fichier symptoms.txt */
		try {
			//J'ouvre le fichier avec le FileReader, puis je le lis avec le BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
			String line = reader.readLine();
			// Boucle pour lire le fichier, tant qu'il y a des lignes à lire
			while (line != null) {
				//System.out.println(line);
				if (line.equals("headache")) {
					headacheCount++;
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				} else {
					otherSymptomFound++;
				}
				line = reader.readLine();
			}
			reader.close();

			// Afficher les symptômes et leur nombre d'occurences
			System.out.println("Total of headaches found " + headacheCount);
			System.out.println("Total rash symptom found: " + rashCount);
			System.out.println("Total dilated pupils symptom found: " + pupilCount);
			System.out.println("Total of other symptoms found: " + otherSymptomFound);

			// Créer un nouveau fichier result.txt
			FileWriter writer = new FileWriter ("result.txt");
			BufferedWriter buffwriter = new BufferedWriter(writer);
			//Ecrire les résultats dans le fichier result.txt
			buffwriter.write("headache: " + headacheCount + "\n");
			buffwriter.write("rash: " + rashCount + "\n");
			buffwriter.write("dialated pupils: " + pupilCount + "\n");
			buffwriter.write("others symptoms: " + otherSymptomFound + "\n");
			buffwriter.close();
			writer.close();

			// Le catch sert pour la totalité du bloc try du début de lecture du fichier
		} catch (FileNotFoundException e) {
			System.err.println("Fichier non trouvé :" + e.getMessage());
	   		} catch (IOException e) {
			System.err.println("Erreur dans le fichier:" + e.getMessage());
		}

		 }
}


