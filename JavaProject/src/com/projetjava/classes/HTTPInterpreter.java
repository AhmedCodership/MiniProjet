package com.projetjava.classes;

public interface HTTPInterpreter {
	//--Fonctions associ�es aux requ�tes http
	public String getIndex();
	/* Appel de l'analyseur pour afficher la liste basique des �tudiants 
	 * R�cup�ration des objets et appel de la fonction associ�es du generateurHTML
	 * Passer les objets en param�tres
	 * R�cup�rer le String contenant le html en sortie du g�n�rateur
	 */
	
	public String getDetails(String param);
	/* Appel de l'analyseur pour afficher la liste d�taill�e d'un �tudiant
	 * R�cup�ration des objets et appel de la fonction associ�es du generateurHTML
	 * Passer les objets en param�tres
	 * R�cup�rer le String contenant le html en sortie du g�n�rateur
	 */
	
	public String addStudent(String param);
	
	public String deleteStudent(String param);
}
