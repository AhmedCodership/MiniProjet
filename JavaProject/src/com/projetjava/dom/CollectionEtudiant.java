package com.projetjava.dom;
import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class CollectionEtudiant
{
	protected ArrayList listeEtudiant;

	public CollectionEtudiant()
	{
		this.listeEtudiant = new ArrayList();
	}
	
	public boolean ajouterEtudiant(Etudiant etudiant)
	{
		return this.listeEtudiant.add(etudiant);
	}
	
	public String toString()
	{
		String result="Liste etudiant : ";
		int nbEtudiant = this.listeEtudiant.size();
		result += ""+ nbEtudiant +" étudiants(s) \n\n";
	
		for (int i= 0; i<nbEtudiant; i++)
		{
	
			Etudiant etudiant = (Etudiant)(this.listeEtudiant.get(i));
			result+="Etudiant "+(i+1)+" :\n";
			result+= etudiant.toString();
			result+="\n";
		}
		return result;
	}
	
	public boolean lectureFichier(String filename)
	{
		boolean resultLecture = true;

		try {

			// Ouverture du fichier XML
			File f = new File(filename);
			System.out.println(f.getAbsolutePath());
			FileInputStream inputStream = new FileInputStream(f);
			InputSource src = new InputSource(inputStream);
			
			// Construction arbre DOM
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(src);
	
			// Parcours de l'abre pour création des objets
			this.listeEtudiant = new ArrayList();
			NodeList etudiants = document.getElementsByTagName("etudiant");

			// obtenir la liste de tous les éléments « Etudiant » de l’arbre DOM
			for (int i=0; i<etudiants.getLength(); i++)
			{
				Etudiant etudiant = new Etudiant();
	
				// obtenir l’élément livre suivant et avec cet élément :
	
				// mettre à jour le titre du livre
				//Element etu = (Element) (livres.item(i));

				//Element titre = (Element)(etudiants.getElementsByTagName("Titre").item(0));

				//Text titre_text = (Text)(titre.getFirstChild());

				//l.setTitre(titre_text.getData().replaceAll("\n",""));
	
				// mettre à jour les auteurs du livre
	
				// mettre à jour l’éditeur et l’ISBN du livre
	
				// mettre à jour l’année de parution du livre
	
				// mettre à jour l’édition du livre
	
				// mettre à jour le nombre de pages du livre
	
				// mettre à jour la langue de rédaction du livre
	
				this.listeEtudiant.add(etudiant);
			}
			inputStream.close();
		}
		catch (Exception e) {return false;}

		return resultLecture;
	}

	public boolean ecritureFichier(File out)
	{
		return false;
	}

}
