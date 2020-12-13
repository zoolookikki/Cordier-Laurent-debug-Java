package com.hemebiotech.analytics;

import java.io.IOException;



/**
 * @author fouziahajji
 * L'interface pour ecrire le resultat dans un fichier
 * 
 */
public interface ISymptomWriter {

    /**
     * Ecrit la map de symptomes dans le fichier result.out
     *
     * @throws IOException
     *
     * @return un fichier avec le nombre de chaque symptomes
     *
     * @author fouziahajji
     */

	void writeSymptoms() throws IOException;
	
}
