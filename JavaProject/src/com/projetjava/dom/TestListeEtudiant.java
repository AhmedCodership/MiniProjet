package com.projetjava.dom;

public class TestListeEtudiant
{

	public static void main(String[] args)
	{
		/* Création des étudiants */
		Etudiant etu = new Etudiant();
		etu.setId("0001");
		etu.setNom("Dubois");
		etu.setPrenom("Mathieu");
		etu.setGroupe("A");
		
		Etudiant etu2 = new Etudiant();
		etu2.setId("0002");
		etu2.setNom("Marionaud");
		etu2.setPrenom("Stéphane");
		etu2.setGroupe("D");
		
		Etudiant etu3 = new Etudiant();
		etu3.setId("0004");
		etu3.setNom("Joellier");
		etu3.setPrenom("Yvette");
		etu3.setGroupe("B");
		
		/* Création de la liste des étudiants */
		CollectionEtudiant collection = new CollectionEtudiant();
		collection.ajouterEtudiant(etu);
		collection.ajouterEtudiant(etu2);
		collection.ajouterEtudiant(etu3);
		
		System.out.println(collection.toString());
	}

}
