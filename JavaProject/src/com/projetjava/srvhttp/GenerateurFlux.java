package com.projetjava.srvhttp;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import HTML.HTML;

import com.projetjava.classes.HTTPInterpreter;

import com.projetjava.interpretor.Parser;

import com.projetjava.interpretor.Parser;

import com.projetjava.interpretor.Parser;

public class GenerateurFlux implements HTTPInterpreter{
	
	//Ajout temporaire de Romain Gueffier
	private HTML h;
	
	
	
	public void getParam(String rq){
	
		if ((rq != null) && (rq.startsWith("GET "))){
			String rqOrig = rq; 
			/*rq = rq.substring(rq.indexOf(" ")+1);	// on recoit un "GET /mapage.html HTTP/1.1"
			rq = rq.substring(0, rq.indexOf(" "));	// du coup on decompose pour chopper juste la page
			rq = rq.substring(1, rq.length());		// on vire le "/" devant le nom de page*/
			
			System.out.println(rq);
			String param;
			param = "action";
			String actionValue = this.getValeurParam(rq,param);
			System.out.println("actionValue = "+actionValue);
			param = "id";
			String idValue = getValeurParam(rq,param);
			System.out.println(idValue);
			param = "truc";
			String trucValue = getValeurParam(rq,param);
			System.out.println(actionValue);
			
			
			/*if(rq.length() != 0){
				System.out.println("Decomposition : "+rq);	// affichage pour debug
			}*/
			// virer lecture fichier
			// decomposer parametres
			// recuperer chaine
			/*if(rq.length() == 0){
				System.out.println("Taille de la chaine : "+rq.length());	// affichage pour debug
				rq = getIndex();
				System.out.println("Aucune page demand�e, on envoie l'index.html");
				
			}*/
			
			
			
			
			/*File f = new File(rq);
					if (f.isFile()){ // bloc a remplacer par un appel de methode
						DataInputStream dis = new DataInputStream(new FileInputStream(f));
						System.out.println("Fichier balanc� : "+f); // debug, voir quel nom de fichier on envoie
						byte[] data = new byte[(int) f.length()];
						//System.out.println(data); // affichage du fichier en bytes 
						dis.readFully(data); dis.close();
						this.s.getOutputStream().write(data);
						String t = new String( data , "Cp1252" );
						System.out.println("\n"+t); // affichage contenu fichier
					}
			*/
		}
		
	}

	public String getValeurParam(String rq, String parametreARechercher){
		if(rq.indexOf("?") != -1){
			System.out.println("rq.substring(rq.lenght : "+rq.length()+", rq.indexOf(?) :"+rq.indexOf("?"));
			String listeParam = rq.substring(rq.indexOf("?"),rq.length()); // on choppe les parametres
			listeParam = listeParam.substring(1,listeParam.indexOf(" "));
			System.out.println("listeParam : "+listeParam+"\n"); // affichage param
			parametreARechercher = parametreARechercher + "=";
			int action = listeParam.indexOf(parametreARechercher);
			System.out.println("Recherche de "+parametreARechercher+" dans "+listeParam+"...");
			String paramValue = null;
			if(action != -1){
				System.out.println(parametreARechercher+" trouv� !");
				paramValue = listeParam.substring(listeParam.indexOf(parametreARechercher)+parametreARechercher.length(),listeParam.length()); // si le param action existe on supprime la partie "param="
				System.out.println("Suppression du nom du parametre dans la chaine param ("+listeParam.indexOf(parametreARechercher)+parametreARechercher.length()+":"+listeParam.length()+") pour avoir la valeur...");
				System.out.println("paramValue vaut maintenant : "+paramValue);
				int autreParam = paramValue.indexOf("&");
				if(autreParam == -1){
					System.out.println("Autre parametre non trouv�...");
					// si on trouve pas de &, la liste de param est termin�e donc le param page = totalit� de la chaine
					System.out.println("Pas d'autre param, value : "+paramValue);
				}
				else{
					System.out.println("Autre parametre trouv� !! ");
					System.out.println("on tronque paramValue sur 0 � &");
					paramValue = paramValue.substring(0,paramValue.indexOf("&")); // si on trouve &, la liste de param est pas termin�e donc le param page = 0 � recherche &
				}
				System.out.println("value : "+paramValue+"\n\n\n");
			}
			return paramValue;
		}else{
	@Override
	public String getIndex() {
		// TODO Auto-generated method stub
		/* Appel de l'analyseur pour afficher la liste basique des �tudiants 
		 * R�cup�ration des objets et appel de la fonction associ�es du generateurHTML
		 * Passer les objets en param�tres
		 * R�cup�rer le String contenant le html en sortie du g�n�rateur
		 */
		//Generator g = new Generator();
		this.h = new HTML();
		this.h.setTitle("Accueil - Liste d'�tudiants");
		this.h.setHeaderTable();
		this.h.addHeaderTableField("Nom des �tudiants");
		this.h.setBodyTable();
		this.h.addBodyTableField("Bob L�ponge");
		this.h.addBodyTableField("Bob L�ponge");
		this.h.addBodyTableField("Bob L�ponge");
		this.h.addBodyTableField("Bob L�ponge");
		this.h.addBodyTableField("Bob L�ponge");
		this.h.addBodyTableField("Bob L�ponge");
		this.h.addBodyTableField("Bob L�ponge");
		this.h.addBodyTableField("Bob L�ponge");
		this.h.setEndTable();
		
		return this.h.getHTML();
	}
		//g.getHTML(null,null);
		
		return null;
	}

	@Override
	public String getDetails(String param) {
		// TODO Auto-generated method stub
		/* Appel de l'analyseur pour afficher la liste d�taill�e d'un �tudiant
		 * R�cup�ration des objets et appel de la fonction associ�es du generateurHTML
		 * Passer les objets en param�tres
		 * R�cup�rer le String contenant le html en sortie du g�n�rateur
		 */
		return null;
	}

	@Override
	public String addStudent(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	

}