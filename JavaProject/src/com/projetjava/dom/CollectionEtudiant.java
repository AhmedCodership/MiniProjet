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
	
				// obtention de l'élément etudiant
				Element etu = (Element) (etudiants.item(i));
	
				// mise a jour de l'id de l'etudiant 
				Element id = (Element)(etu.getElementsByTagName("id").item(0));
				Text id_text = (Text)(id.getFirstChild());
				etudiant.setId(id_text.getData().replaceAll("\n",""));
	
				// mise à jour du nom de l'etudiant
				Element nom = (Element)(etu.getElementsByTagName("nom").item(0));
				Text nom_text = (Text)(nom.getFirstChild());
				etudiant.setNom(nom_text.getData().replaceAll("\n",""));
	
				// mise à jour du prénom de l'etudiant
				Element prenom = (Element)(etu.getElementsByTagName("prenom").item(0));
				Text prenom_text = (Text)(prenom.getFirstChild());
				etudiant.setPrenom(prenom_text.getData().replaceAll("\n",""));
	
				// mise à jour du groupe de l'etudiant
				Element groupe = (Element)(etu.getElementsByTagName("groupe").item(0));
				Text groupe_text = (Text)(groupe.getFirstChild());
				etudiant.setGroupe(groupe_text.getData().replaceAll("\n",""));
	
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
