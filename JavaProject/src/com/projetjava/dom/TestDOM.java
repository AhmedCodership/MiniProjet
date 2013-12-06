package com.projetjava.dom;
public class TestDOM
{
	public static void main(String args[])
	{
		
		CollectionEtudiant coll = new CollectionEtudiant();
		
		Etudiant javaXML = new Etudiant();

		javaXML.setId("30");

		javaXML.setNom("toto");

		javaXML.setPrenom("loic");
		
		javaXML.setGroupe("groupe");

		coll.ajouterEtudiant(javaXML);

		System.out.println(coll.toString());

		boolean sauve = coll.lectureFichier("etudiant.xml");

		if (!sauve) {
			System.err.println("Erreur lors de la sauvegarde du fichier"); 
		}

		System.out.println(coll.toString());
	}
}
