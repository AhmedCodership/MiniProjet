package com.projetjava.srvhttp;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import com.projetjava.classes.HTTPInterpreter;
import com.projetjava.generatorHTML.Generator;
import com.projetjava.generatorHTML.generator;

public class GenerateurFlux implements HTTPInterpreter{
	
	public void getParam(String rq){
	
		if ((rq != null) && (rq.startsWith("GET "))){
			String rqOrig = rq; 
			rq = rq.substring(rq.indexOf(" ")+1);	// on recoit un "GET /mapage.html HTTP/1.1"
			rq = rq.substring(0, rq.indexOf(" "));	// du coup on decompose pour chopper juste la page
			rq = rq.substring(1, rq.length());		// on vire le "/" devant le nom de page
			
			if(rq.length() != 0){
				System.out.println("Decomposition : "+rq);	// affichage pour debug
			}
			// virer lecture fichier
			// decomposer parametres
			// recuperer chaine
			if(rq.length() == 0){
				System.out.println("Taille de la chaine : "+rq.length());	// affichage pour debug
				rq = getIndex();
				System.out.println("Aucune page demandée, on envoie l'index.html");
				
			}
			
			String param = rqOrig.substring(rqOrig.indexOf("?"),rqOrig.length()); // on choppe les parametres
			param = param.substring(0,param.indexOf(" "));
			System.out.println("Param : "+param+"\n"); // affichage contenu fichier
			
			/*File f = new File(rq);
					if (f.isFile()){ // bloc a remplacer par un appel de methode
						DataInputStream dis = new DataInputStream(new FileInputStream(f));
						System.out.println("Fichier balancé : "+f); // debug, voir quel nom de fichier on envoie
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

	@Override
	public String getIndex() {
		// TODO Auto-generated method stub
		/* Appel de l'analyseur pour afficher la liste basique des étudiants 
		 * Récupération des objets et appel de la fonction associées du generateurHTML
		 * Passer les objets en paramètres
		 * Récupérer le String contenant le html en sortie du générateur
		 */
		Generator g = new Generator();
		g.getHTML(null,null);
		
		return null;
	}

	@Override
	public String getDetails(String param) {
		// TODO Auto-generated method stub
		/* Appel de l'analyseur pour afficher la liste détaillée d'un étudiant
		 * Récupération des objets et appel de la fonction associées du generateurHTML
		 * Passer les objets en paramètres
		 * Récupérer le String contenant le html en sortie du générateur
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