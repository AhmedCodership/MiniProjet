package com.projetjava.classes;

public interface HTTPInterpreter {
	//--Fonctions associées aux requètes http
	public String getIndex();
	/* Appel de l'analyseur pour afficher la liste basique des étudiants 
	 * Récupération des objets et appel de la fonction associées du generateurHTML
	 * Passer les objets en paramètres
	 * Récupérer le String contenant le html en sortie du générateur
	 */
	
	public String getDetails(String param);
	/* Appel de l'analyseur pour afficher la liste détaillée d'un étudiant
	 * Récupération des objets et appel de la fonction associées du generateurHTML
	 * Passer les objets en paramètres
	 * Récupérer le String contenant le html en sortie du générateur
	 */
	
	public String addStudent(String param);
	
	public String deleteStudent(String param);
}
